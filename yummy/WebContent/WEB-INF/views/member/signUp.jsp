<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

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
			<h2>회원 가입</h2>
			<hr class="hr_Title1">
		</div>

		<div class="row">
			<div class="col-md-6 offset-md-3">

				<!--<form method="POST" action="signUp" class="needs-validation" name="signUpForm" onsubmit="return TOSvalidate();"> 
				error였던 지점(TOSvalidate()) : 다른함수도 이름 다른지 확인해 볼 것-->
				<form method="POST" action="signUp" class="needs-validation" name="signUpForm" onsubmit="return validate();">
				
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
								<input type="hidden" name="grade" value="G"/> <!-- 회원등급 일반:G 점주:O -->
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
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header"></div>
				<div class="modal-body">[ 쿠팡 이용 약관 ]
제1장 총칙

제 1 조 (목적)
이 약관은 쿠팡 주식회사(이하 “회사”)가 운영하는 사이버몰에서 제공하는 서비스와 이를 이용하는 회원의 권리·의무 및 책임사항을 규정함을 목적으로 합니다.

제 2 조 (용어의 정의)
이 약관에서 사용하는 용어의 정의는 다음과 같습니다. 그리고 여기에서 정의되지 않은 이 약관상의 용어의 의미는 일반적인 거래관행에 따릅니다.
1. “사이버몰”이란 회사가 상품 또는 용역 등(일정한 시설을 이용하거나 용역을 제공받을 수 있는 권리를 포함하며, 이하 “상품 등”)을 회원에게 제공하기 위하여 컴퓨터 등 정보통신설비를 이용하여 상품 등을 거래할 수 있도록 설정한 가상의 영업장(http://www.coupang.com 등 회사가 운영하는 웹사이트 및 모바일 웹, 앱 등을 모두 포함)을 의미합니다.
2. “회원”이라 함은 사이버몰에 회원등록을 한 자로서, 계속적으로 사이버몰에서 제공하는 서비스를 이용할 수 있는 자를 말합니다.
3. “아이디(ID)”라 함은 회원의 식별과 서비스 이용을 위하여 회원이 설정하고 회사가 승인하여 등록된 전자우편주소를 말합니다.
4. “비밀번호(Password)”라 함은 회원의 동일성 확인과 회원의 권익 및 비밀보호를 위하여 회원 스스로가 설정하여 사이버몰에 등록한 문자와 숫자 등의 조합을 말합니다.
5. “마켓플레이스 서비스(MarketPlace Service)”라 함은 회사가 사이버몰을 통하여 제공하는 통신판매중개 서비스 및 관련 부가서비스 일체를 말합니다.
6. “판매자”라 함은 “쿠팡 서비스 이용 약관-사업자용”을 승인하고 회사와 마켓플레이스 서비스(MarketPlace Service) 이용계약을 체결한 자 또는 마켓플레이스 서비스(MarketPlace Service)를 이용하여 실제로 상품을 판매하는 자를 말합니다.
</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">확인</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">내용 2</div>
				<div class="modal-body">
				
				</div>
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
