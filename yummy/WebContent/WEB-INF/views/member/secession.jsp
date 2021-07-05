<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보</title>
</head>
<style>
#content-main {
	height: 830px;
}

#btn{
	border:2px solid #263343;
    border-radius: 15px;
    background-color: #F8B03A;
}

#btn:hover {
    background-color: #263343;
    color: white;
}
</style>
<body>
	<div class="container" id="content-main">
		<jsp:include page="../common/header.jsp"></jsp:include>

		<div class="row my-5">
			<%-- <jsp:include page="sideMenu.jsp"></jsp:include> --%>

			<div class="py-5 text-center">
				<h2>회원 탈퇴</h2>
				<hr style="width: 30%">
			<div class="col-sm-offset-2 col-sm-8">
			</div>
				<div class="bg-white rounded shadow-sm container p-3">
					<form method="POST" action="secession" onsubmit="return secessionValidate();" 
						class="form-horizontal" role="form">
						<!-- 아이디 -->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<h6>아이디</h6>
							</div>
							<div class="col-md-6">
								<h5 id="id">${loginMember.memberId }</h5>
							</div>
						</div>

						<!-- 비밀번호 -->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<h6>비밀번호</h6>
							</div>
							<div class="col-md-6">
								<input type="password" class="form-control" id="currentPwd"
									name="currentPwd">
							</div>
						</div>

						<hr>
						<div class="panel panel-default">

							<div class="panel-body">
								<div class="form-group pull-left">
									<label class="control-label" style="color: red; font-size: 20px; font-weight: bold;"> 유의 사항 동의 </label>
									<div class="col-xs-12">
										<textarea class="form-control" readonly rows="10" cols="100">
제1조
· 사용하고 계신 아이디는 탈퇴할 경우 재사용 및 복구가 불가능합니다.

탈퇴한 아이디는 본인과 타인 모두 재사용 및 복구가 
불가하오니 신중하게 선택하시기 바랍니다.


제2조
· 회원탈퇴 후 회원정보 및 사이트 이용기록은 모두 삭제됩니다.

회원정보 및 사이트 이용기록은 최대 1개월 보관 후 
모두 삭제되며 삭제된 데이터는 복구되지 않습니다.
</textarea>
									</div>
									<div class="checkbox pull-right">
										<div class="custom-checkbox">
											<div class="form-check">
												<input type="checkbox" name="agree" id="agree"
													class="form-check-input custom-control-input"> <br>
												<label class="form-check-label custom-control-label"
													for="agree">모두 동의합니다.</label>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<hr class="mb-4">
						<button class="btn btn-primary btn-lg btn-block" id="btn"
							type="submit">탈퇴 진행하기</button>
					</form>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="../common/footer.jsp"></jsp:include>

	<script>
		// 약관 동의가 체크 되었을 때에만 탈퇴 진행
		function secessionValidate(){
			
			if( $("#agree:checked").length == 0){
				swal({"icon" : "info", "title" : "약관 동의를 체크해주세요."})
				return false;
			}
		}
	</script>
	
	
	
	

</body>
</html>