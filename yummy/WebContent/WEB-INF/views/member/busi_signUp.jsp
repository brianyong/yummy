<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입(비즈니스)</title>

<link rel="stylesheet" href="${contextPath}/resources/css/member/signUp.css" type="text/css"/>

</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="container">
		<!-- 
			상대경로에서 사용하는 기호
			(빈칸 ) : 현재 폴더
			/	  : 하위 폴더
			../   : 상위 폴더 
		 -->

		<div class="py-5 text-center">
			<h2>회원 가입(비즈니스)</h2>
			<hr class="hr_Title1">
		</div>

		<div class="row">
			<div class="col-md-6 offset-md-3">

				<!--<form method="POST" action="signUp" class="needs-validation" name="signUpForm" onsubmit="return TOSvalidate();"> 
				error였던 지점(TOSvalidate()) : 다른함수도 이름 다른지 확인해 볼 것-->
				<form method="POST" action="busi_signUp" class="needs-validation" name="signUpForm" onsubmit="return validate();">
				
					<!-- 이름 -->
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="name"><img src="${contextPath}/resources/images/member/icon/nm.png" /></label>
						</div>
						<div class="col-md-6">
							<input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요"required>
						</div>

						<div class="col-md-6 offset-md-3">
							<span id="checkName">&nbsp;</span>
						</div>
					</div>

					<!-- 아이디 -->
					<div class="row mb-5 form-row">
						<div class="col-md-3">
							<label for="id"><img
								src="${contextPath}/resources/images/member/icon/id.png" /></label>
						</div>
						<div class="col-md-6">
							<input type="text" class="form-control" name="id" id="id"
								maxlength="12" placeholder="아이디를 입력하세요" autocomplete="off"
								required>
							<!-- required : 필수 입력 항목으로 지정 -->
							<!-- autocomplete="off" : input 태그 자동완성 기능을 끔 -->

							<!-- 팝업창 중복체크 여부 판단을 위한 hidden 타입 요소 -->
							<!-- <input type="hidden" name="idDup" id="idDup" value="false"> -->
						</div>
						<div class="col-md-6 offset-md-3">
							<span id="checkId">&nbsp;</span>
						</div>
					</div>


					<!-- 비밀번호 -->
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="pwd1"><img src="${contextPath}/resources/images/member/icon/pw.png" /></label>
						</div>
						<div class="col-md-6">
							<input type="password" class="form-control" id="pwd1" name="pwd1"
								maxlength="20" placeholder="비밀번호를 입력하세요" required>
						</div>

						<div class="col-md-6 offset-md-3">
							<span id="checkPwd1">&nbsp;</span>
						</div>
					</div>

					<!-- 비밀번호 확인 -->
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="pwd2"><img src="${contextPath}/resources/images/member/icon/pw.png" /></label>
						</div>
						<div class="col-md-6">
							<input type="password" class="form-control" id="pwd2"
								maxlength="20" placeholder="비밀번호 확인" required>
						</div>

						<div class="col-md-6 offset-md-3">
							<span id="checkPwd2">&nbsp;</span>
						</div>
					</div>
					<br>

					<!-- 전화번호 -->
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="phone1"><img src="${contextPath}/resources/images/member/icon/phone.png" /></label>
						</div>
						<!-- 전화번호1 -->
						<div class="col-md-3">
							<select class="custom-select" id="phone1" name="phone" required>
								<option>010</option>
								<option>011</option>
								<option>016</option>
								<option>017</option>
								<option>019</option>
							</select>
						</div>

						<!-- number타입의 input태그에는 maxlength를 설정할 수 없음 -->
						<!-- 전화번호2 -->
						<div class="col-md-3">
							<input type="number" class="form-control phone" id="phone2"
								name="phone" required>
						</div>

						<!-- 전화번호3 -->
						<div class="col-md-3">
							<input type="number" class="form-control phone" id="phone3"
								name="phone" required>
						</div>

						<div class="col-md-6 offset-md-3">
							<span id="checkPhone">&nbsp;</span>
						</div>
					</div>

					<!-- 이메일 -->
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="email"><img src="${contextPath}/resources/images/member/icon/email.png" /></label>
						</div>
						<div class="col-md-6">
							<input type="email" class="form-control" id="email" name="email"
								autocomplete="off" required>
						</div>

						<div class="col-md-6 offset-md-3">
							<span id="checkEmail">&nbsp;</span>
						</div>
					</div>
					<br>


					<div class="TOS_Title text-center">
					<h5>서비스 약관에 동의해주세요</h5>
					<hr>
					</div>
					
					<div class="TOS_Content">
					<table class="TOS_table">
						<tr>
							<td>
								<input type="checkbox" id="check_1" class="normal" /> 
								<label for="check_1">[필수]만 14세 이상 입니다</label>
							</td>
						</tr>
						<tr>
							<td>
								<input type="checkbox" id="check_2" class="normal" /> 
								<label for="check_2">[필수]야미 이용약관 동의 </label>
							</td>
						</tr>
						<tr>
							<td>
								<input type="checkbox" id="check_3" class="normal" /> 
								<label for="check_3">[필수]개인정보 수집 및 이용 동의</label>
							</td>
						</tr>
						<tr>
							<td>
								<input type="checkbox" id="check_4" class="normal" /> 
								<label for="check_4">[필수]개인정보 제공 동의</label>
							</td>
						</tr>
						<tr>
							<td>
								<input type="checkbox" id="check_all" /> 
								<label for="check_all">모두 동의합니다</label>
								<input type="hidden" name="grade" value="O"/> <!-- 회원등급 일반:G 점주:O -->
							</td>
						</tr>
					</table>
					</div>

						<hr class="mb-4">
						<button class="btn btn-primary btn-lg btn-block" id="btn_sign" type="submit">가입하기</button>
							
				</form>
			</div>
		</div>
		<br> <br>
		
  
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>


	<!-- Modal -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header"></div>
				<div class="modal-body">약관 내용2</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">확인</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header"></div>
				<div class="modal-body">약관 내용3</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">확인</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="myModal4" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header"></div>
				<div class="modal-body">약관 내용4</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">확인</button>
				</div>
			</div>
		</div>
	</div>
	
	
	<script>
	if ($("#check_all:checked").length == 0) {
		swal({
			"icon" : "info",
			"title" : "약관 동의를 체크해주세요."
		})
		return false;
	</script>

	<!-- 약관 내용 모달창 스크립트 -->
	<script>
		$('#check_1').on('change', function(e) {
			if (e.target.checked) {
				$('#myModal1').modal();
			}
		});
		
		$('#check_2').on('change', function(e) {
			if (e.target.checked) {
				$('#myModal2').modal();
			}
		});
		
		$('#check_3').on('change', function(e) {
			if (e.target.checked) {
				$('#myModal3').modal();
			}
		});
		
		$('#check_4').on('change', function(e) {
			if (e.target.checked) {
				$('#myModal4').modal();
			}
		});
	</script>

	<script src="${contextPath}/resources/js/member.js"></script>


</body>
</html>
