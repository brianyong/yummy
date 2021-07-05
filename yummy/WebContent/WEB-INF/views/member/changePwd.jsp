<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보</title>
</head>
<style>
	#content-main{
	height: 830px;}
	
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
				<h2>비밀번호 변경하기</h2>
				<hr style="width: 30%">
			<div class="col-sm-8">
			</div>
				<div class="bg-white rounded shadow-sm container p-3">
					<form method="POST" action="changePwd" onsubmit="return pwdValidate();" class="form-horizontal" role="form">
						<!-- 아이디 -->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<h6>아이디</h6>
							</div>
							<div class="col-md-6">
								<h5 id="id">${loginMember.memberId }</h5>
							</div>
						</div>

						<hr>
						<!-- 현재 비밀번호 -->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<h6>현재 비밀번호</h6>
							</div>
							<div class="col-md-6">
								<input type="password" class="form-control" id="currentPwd" name="currentPwd">
							</div>
						</div>

						<!-- 새 비밀번호 -->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<h6>새 비밀번호</h6>
							</div>
							<div class="col-md-6">
								<input type="password" class="form-control" id="newPwd1" name="newPwd1">
							</div>
						</div>

						<!-- 새 비밀번호 확인-->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<h6>새 비밀번호 확인</h6>
							</div>
							<div class="col-md-6">
								<input type="password" class="form-control" id="newPwd2" name="newPwd2">
							</div>
						</div>
						
						<hr class="mb-4">
						<button class="btn btn-primary btn-lg btn-block" id="btn" type="submit">변경하기</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>


	<script>
		// 비밀번호 유효성 검사
		function pwdValidate(){
			const regExp = /^[a-zA-Z0-9\#\-\_]{6,20}$/;
			
			const newPwd1 = $("#newPwd1").val().trim();
			const newPwd2 = $("#newPwd2").val().trim();
			
			// 새비밀번호가 유효하지 않거나
			// 새비밀번호, 새비밀번호 확인이 같지 않은 경우
			if( !regExp.test(newPwd1)  || ( newPwd1 != newPwd2 )  ){
				swal({ 
					"icon" : "error",
					"title" : "부적절한 비밀번호 입니다!",
					"text" : "비밀번호를 다시 설정해주세요."
				});
				
				return false;
			}
		}
	
	</script>


</body>
</html>