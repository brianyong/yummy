<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="${contextPath}/resources/css/member/login.css" type="text/css"/>
</head>
<body>
	<!-- header.jsp 동적 include -->
	<jsp:include page="../common/header.jsp"/>
	
	<div class="container">
	    <ul class="Login_body">
	        <form action="${contextPath}/member/login" method="POST" onsubmit="return loginValidate();">
	            <li>
	                <div class="Login_Title">
	                    LOGIN
	                </div>
	            </li>
	            <li>
	                <div class="Login_box">
	                    <ul class="Login_box_li">
	                        <li>
	                            <input type="text" name="memberId" id="memberId" placeholder="ID">
	                        </li>
	                        <li>
	                            <div class="guide_text">ID를 입력해주세요</div>
	                        </li>
	                        <li>
	                            <input type="password" name="memberPw" id="memberPw" placeholder="PASSWORD">
	                        </li>
	                        <li>
	                            <div class="guide_text">비밀번호를 입력해주세요</div>
	                        </li>
	                        <li>
	                            <button type="submit" id="btn_login">로그인</button>
	                        </li>
	                        <li>
	                            <div class="lost_text">
	                                	기억나지 않으신가요? <a href="">아이디/비밀번호 찾기</a>
	                            </div>
	                        </li>
	                    </ul>
	                </div>
	            </li>
	        </form>
	    </ul>
	</div>
	
		<script>
	
		// 로그인 수행 시 아이디/비밀번호가 작성 되었는지 확인하는 유효성 검사
		function loginValidate(){
			// Validate: 유효한지 확인하다
			
			// 아이디가 입력되지 않았을 경우
			// "아이디를 입력해주세요" 경고창을 띄우고 로그인 수행하지 않음
			
			// 비밀번호가 입력되지 않았을 경우
			// "비밀번호를 입력해주세요" 경고창을 띄우고 로그인 수행하지 않음
			
	 		var memId = document.getElementById("memberId");
			var memPw = document.getElementById("memberPw");
			
			if((memId.value)==""){
				swal({
				"icon" :"info" ,
				"title":"아이디를 입력해주세요."
				}).then(function(){
					// alert창 닫기 버튼 클릭 후 아이디 입력창으로 포커스 이동
					memId.focus();
				});
				return false;
			}
			
			if((memPw.value)==""){
				swal({
				"icon" :"info" ,
				"title":"비밀번호를 입력해주세요."
				}).then(function(){
					memPw.focus();
				});
				return false;
			}
		}
		</script>
	
	
	
	<!-- footer.jsp 동적 include -->
	<jsp:include page="../common/footer.jsp"/>

</body>
</html>