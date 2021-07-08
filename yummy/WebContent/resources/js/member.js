// 회원 가입 유효성 검사

// 각 유효성 검사 결과를 저장할 객체
const checkObj = {
    "id": false,
    "pwd1": false,
    "pwd2": false,
    "name": false,
    "phone2": false,
    "email": false,
};

// 아이디가 입력될 때 마다 유효성 검사
// 조건: 영어, 숫자 6~14글자

// 이름 유효성 검사
// 조건 : 한글 두 글자 이상 10글자 이하 ->  /^[가-힣]{2,10}$/;

// 이메일 유효성 검사
// 조건 : 아이디 4글자 이상, 이메일 형식  ->   /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;


// 이름 유효성 검사
$("#name").on("input", function(){

    const regExp = /^[가-힣]{2,10}$/;

    const inputNm = $(this).val().trim();

    if(regExp.test(inputNm)){
        $("#checkName").text("유효합니다.").css("color", "green");
        checkObj.name = true;
    } else{
        $("#checkName").text("한글 2~10글자 사이로 입력").css("color", "red");
        checkObj.name = false;

    }

});


// 아이디 유효성 검사(Ajax 방식)
$("#id").on("input", function(){

    // 정규표현식 객체 생성
    const regExp = /^[a-zA-Z\d]{6,12}$/;

    // 입력된 아이디(양쪽 공백 제거)를 얻어와 inputId 변수에 저장
    const inputId = $("#id").val().trim();

    // 입력된 아이디가 정규식에 일치하는 경우 == 유효한 값인 경우
    if(regExp.test(inputId)){
	
        // Ajax를 이용하여 비동기적으로 아이디 중복 검사를 진행

        // jQuery를 이용한 Ajax
        $.ajax({url:"idDupCheck", // 요청 주소(필수로 작성!)
               data: {"id": inputId}, // 전달하려는 값(파라미터)
               type: "post", // 데이터 전달 방식

               success: function(result){
                    // 매개변수 result: 서버에서 비동기로 전달 받은 응답 데이터

                    console.log(result);

                    if(result > 0){ // 아이디가 중복 되는 경우
                        $("#checkId").text("이미 사용중인 아이디 입니다.").css("color", "red");
                        checkObj.id = false;
                    }else{
                        $("#checkId").text("사용 가능한 아이디 입니다.").css("color", "green");
                        checkObj.id = true;
                    }


               }, // 비동기 통신 성공 시 동작
               error: function(e){
                    // 매개변수 e: 예외 발생 시 Exception 객체를 전달 받음 

                    console.log("ajax 통신 실패");
                    console.log(e);


               }, // 비동기 통신 실패 시 동작
        });

    } else{
        $("#checkId").text("영어, 숫자 6~12글자로 작성").css("color", "red");
        checkObj.id = false;
    }

});


// 비밀번호 유효성 검사
$("#pwd1").on("input", function(){

    const regExp = /^[A-Za-z\d\#\-\_]{6,20}$/;

    const inputPw = $(this).val().trim();

    if(regExp.test(inputPw)){
        $("#checkPwd1").text("사용 가능합니다.").css("color", "green");
        checkObj.pwd1 = true;
    }else{
        $("#checkPwd1").text("다시 입력해주세요.").css("color", "red");
        checkObj.pwd1 = false;
    }
});


// 비밀번호, 비밀번호 확인 일치 여부 판단
$("#pwd1,  #pwd2").on("input", function(){

    const pwd1 = $("#pwd1").val();
    const pwd2 = $("#pwd2").val();

    if( pwd1.trim() == ""  && pwd2.trim() == ""  ){ // 둘다 비었을 때
        $("#checkPwd1").html("&nbsp;"); // &nbsp;  == 띄어쓰기
        $("#checkPwd2").html("&nbsp;");

        checkObj.name = false;

    } else if(  pwd1 == pwd2   ){
        $("#checkPwd2").text("비밀번호가 일치합니다.").css("color", "green");
        checkObj.pwd2 = true;
    }else{
        $("#checkPwd2").text("비밀번호가 일치하지 않습니다.").css("color", "red");
        checkObj.pwd2 = false;
    }
});


// 전화번호 유효성 검사
$(".phone").on("input", function(){

    // 전화번호 input 태그에 4글자 초과 입력하지 못하게 하는 이벤트
    if ($(this).val().length > 4) {
        $(this).val($(this).val().slice(0, 4));
    }

    const regExp1 = /^[\d]{3,4}$/;
    const regExp2 = /^[\d]{4}$/;

    const ph2 = $("#phone2").val();
    const ph3 = $("#phone3").val();

    if(regExp1.test(ph2) && regExp2.test(ph3)){
        $("#checkPhone").text("사용 가능한 전화번호 입니다.").css("color", "green");
        checkObj.phone2 = true;
    }else{
        $("#checkPhone").text("다시 입력해주세요.").css("color", "red");
        checkObj.phone2 = false;
    }

});


// 이메일 유효성 검사
$("#email").on("input", function(){

    const regExp = /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;

    const inputEmail = $(this).val().trim();

    if(regExp.test(inputEmail)){
        $("#checkEmail").text("사용 가능한 이메일 입니다.").css("color", "green");
        checkObj.email = true;
    } else{
        $("#checkEmail").text("다시 입력해주세요.").css("color", "red");
        checkObj.email = false;
    }

});

// 체크박스 다중 선택 스크립트 
$(".TOS_Content").on(
				"click",
				"#check_all",
				function() {
					$(this).parents(".TOS_Content").find('input').prop(
							"checked", $(this).is(":checked"));
});

// 체크박스 개별 선택				
$(".TOS_Content").on("click", ".normal", function() {
			var is_checked = true;

			$(".TOS_Content .normal").each(function() {
				is_checked = is_checked && $(this).is(":checked");
			});

			$("#check_all").prop("checked", is_checked);
});
		
//체크박스 체크 여부 확인 스크립트
function TOSvalidate(){
	if ($("#check_all:checked").length == 0) {
					swal({
						"icon" : "info",
						"title" : "약관 동의를 체크해주세요."
					})
					return false;
	}
}



// 회원 가입 버튼 클릭 시 요소 전체 유효성 검사 여부 확인
function validate(){
	
/*	var a = console.log($("input:checkbox[name='ck']:checked").length);
	
	if (a!=4) {
       swal({
					"icon" : "info",
					"title" : "약관 동의를 체크해주세요."
		})
	return false;
    }*/


    // checkObj에 작성된 속성들이 모두 true인지 확인

    // 객체 내 속성을 순차접근하는 반복문 :  for in구문
    for(const key in checkObj ){

        if( !checkObj[key] ){ // false 값을 가진 속성이 있을 경우
            let msg;
			switch (key) {
			case "id":
				msg = "아이디가 유효하지 않습니다.";
				break;
			case "pwd1":
				msg = "비밀번호가 유효하지 않습니다.";
				break;
			case "pwd2":
				msg = "비밀번호가 일치하지 않습니다. ";
				break;
			case "name":
				msg = "이름이 유효하지 않습니다.";
				break;
			case "phone2":
				msg = "전화번호가 유효하지 않습니다. ";
				break;
			case "email":
				msg = "이메일이 유효하지 않습니다.";
					break;
		/*	case "check_all":
				msg = "약관에 동의하세요.";
					break;*/
			} 

            // msg에 담긴 내용 출력
            swal(msg).then(function(){ 

                const selector = "#" + key;

                $(selector).focus();
                // 유효하지 않은 값을 입력한 부분으로 포커스 이동
            });

            return false;  // submit 이벤트 제거(회원가입 실행 X)

        }

    }
	
}
