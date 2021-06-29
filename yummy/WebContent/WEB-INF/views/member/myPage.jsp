<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%-- fn 태그 : JSTL에서 문자열과 관련된 메소드를 제공하는 태그 
(주의)이름은 태그인데 사용은 EL식 내부에서만 사용할 수 있다.

   
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보</title>
<style>
input[type="number"]::-webkit-outer-spin-button, input[type="number"]::-webkit-inner-spin-button
	{
	-webkit-appearance: none;
	margin: 0;
}
</style>
<link rel="stylesheet" href="${contextPath}/resources/css/common/myPage.css"
	type="text/css" />
</head>
<body>

	<!-- header.jsp 동적 include -->
	<jsp:include page="../common/header.jsp" />

	<!-- search.jsp 동적 include -->
	<jsp:include page="../common/search.jsp" />


	<div class="container">
	
	<c:set var="phone" value="${fn:split(loginMember.memberPhone, '-') }" />
		<div class="row my-5">
			<div class="col-sm-8">
				<h3>My Page</h3>
				<hr>
				<div class="bg-white rounded  container p-3">
					<form method="POST" action="update"
						onsubmit="return memberUpdateValidate();" class="form-horizontal"
						role="form">
						<!-- 아이디 -->
						<div class="row mb-3 form-row">
							<div class="col-md-2">
								<h6>아이디</h6>
							</div>
							<div class="col-md-5">
								<h5 id="id">${loginMember.memberId}</h5>
							</div>
						</div>

						<!-- 이름 -->
						<div class="row mb-3 form-row">
							<div class="col-md-2">
								<h6>이름</h6>
							</div>
							<div class="col-md-5">
								<h5 id="name">${loginMember.memberName}</h5>
							</div>
						</div>

						<!-- 전화번호 -->
						<div class="row mb-3 form-row">
							<div class="col-md-2">
								<label for="phone1">전화번호</label>
							</div>
							<!-- 전화번호1 -->
							<div class="col-md-2">
								<select class="custom-select" id="phone1" name="phone">
									<option>010</option>
									<option>011</option>
									<option>016</option>
									<option>017</option>
									<option>019</option>
								</select>
							</div>


							<!-- 전화번호2 -->
							<div class="col-md-2">
								<input type="number" class="form-control phone" id="phone2"
									name="phone" value="${phone[1]}">
							</div>

							<!-- 전화번호3 -->
							<div class="col-md-2">
								<input type="number" class="form-control phone" id="phone3"
									name="phone" value="${phone[2]}">
							</div>
						</div>

						<!-- 이메일 -->
						<div class="row mb-3 form-row">
							<div class="col-md-2">
								<label for="memberEmail">Email</label>
							</div>
							<div class="col-md-6">
								<input type="email" class="form-control" id="email" name="email"
									value="${loginMember.memberEmail}">
							</div>
						</div>
						<br>
						<div class="row4">
							<button class="btn btn-primary btn-lg" type="submit"
								style="width: 300px;">수정</button>
						</div>

					</form>

				</div>
			</div><jsp:include page="sideMenu.jsp" />
			
			
		</div>
		<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	<script>
		// 검색 단추를 누르면 팝업 레이어가 열리도록 설정한다.
		$(function() {
			$("#postcodify_search_button").postcodifyPopUp();
		});
	</script>
	</div>
	
	<!-- footer.jsp 동적 include -->
	<jsp:include page="../common/footer.jsp" />
</body>
</html>