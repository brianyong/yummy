<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%-- fn 태그 : JSTL에서 문자열과 관련된 메소드를 제공하는 태그 
(주의)이름은 태그인데 사용은 EL식 내부에서만 사용할 수 있다.

   
 --%>
<!-- header.jsp 동적 include -->
	<jsp:include page="../common/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보</title>

<link rel="stylesheet"
	href="${contextPath}/resources/css/common/ownerMyPage.css" type="text/css" />
</head>
<body>

	

	<!-- search.jsp 동적 include -->
	<jsp:include page="../common/search.jsp" />


	<div class="container">
		 <c:set var="phone"  
            value="${fn:split( loginMember.memberPhone, '-' ) }"/>
            
            <c:set var="storePhone"  
            value="${fn:split( storeInfo.storePhone, '-' ) }"/>
            
             <c:set var="addr" 
            value="${fn:split( storeInfo.storeAddr, ',' ) }"/>
            
            






		<div class="row my-5">
			<div class="col-sm-8">
				<h3>My Page</h3>
				<hr>



				<div class="bg-white rounded  container p-3">



					<!-- 대표 이미지 -->
					<div class="row mb-2 form-row">
						<div class="col-md-0"></div>
						<div class="col-md-4" id="storelogo">
							<h5 id="name">
								<img src="" width="80%" height="80%">
														
							</h5>
						</div>
					</div>









					<form method="POST" action="ownerupdate"
						onsubmit="return memberUpdateValidate();" class="form-horizontal"
						role="form">
						<!-- 상호명 -->
						<div class="row mb-3 form-row">
							<div class="col-md-2">
								<h6>상호명</h6>
							</div>
							<div class="col-md-5">
								<h5 id="id">${storeInfo.storeName}</h5>
							</div>
						</div>

						<!-- 사업자 등록 번호 -->
						<div class="row mb-3 form-row">
							<div class="col-md-2">
								<h6>사업자 등록 번호</h6>
							</div>
							<div class="col-md-5">
								<h5 id="name">${storeInfo.corNo}</h5>
							</div>
						</div>

						

						<!-- 주소 -->
						<!-- 오픈소스 도로명 주소 API -->
						<!-- https://www.poesis.org/postcodify/ -->
						<div class="row mb-1 form-row">
							<div class="col-md-2">
								<label for="postcodify_search_button">매장주소</label>
							</div>
							<div class="col-md-4">
								<input type="text" name="storeAddr"
									class="form-control postcodify_postcode5" value="${addr[0]}">
							</div>
							<div class="col-md-2">
								<button type="button" class="btn btn-primary btn-search"
									id="postcodify_search_button">검색</button>
							</div>
						</div>

						<div class="row mb-3 form-row">
							<div class="col-md-2">
								<label for="address1"></label>
							</div>
							<div class="col-md-5">
								<input type="text" class="form-control postcodify_address"
									name="storeAddr" id="address1" value="${addr[1]}">
							</div>
						</div>

						<div class="row mb-3 form-row">
							<div class="col-md-2">
								<label for="address2"></label>
							</div>
							<div class="col-md-5">
								<input type="text" class="form-control postcodify_details"
									name="storeAddr" id="address2" value="${addr[2]}">
							</div>
						</div>


						<!-- 매장 전화번호 -->
						<div class="row mb-3 form-row">
							<div class="col-md-2">
								<label for="storePhone1">매장 전화번호</label>
							</div>
							<!-- 매장 전화번호 -->
							<div class="col-md-1">
								<select class="custom-select" id="storePhone1" name="storePhone">
									<option>02</option>
									<option>031</option>

								</select>
							</div>


							<!-- 매장 전화번호 -->
							<div class="col-md-2">
								<input type="number" class="form-control phone" id="storePhone2"
									name="storePhone" value="${storePhone[1]}">
							</div>

							<!-- 매장 전화번호 -->
							<div class="col-md-2">
								<input type="number" class="form-control phone" id="storePhone3"
									name="storePhone" value="${fn:trim(storePhone[2])}">
							</div>
						</div>
						
						
						<!-- 매장명 -->
						<div class="row mb-3 form-row">
							<div class="col-md-2">
								<h6>아이디</h6>
							</div>
							<div class="col-md-5">
								<h5 id="name">${loginMember.memberId}</h5>
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

						<!-- 대표자 전화번호 -->
						<div class="row mb-3 form-row">
							<div class="col-md-2">
								<label for="phone1">대표자 전화번호</label>
							</div>
							<!-- 대표자 전화번호1 -->
							<div class="col-md-1">
								<select class="custom-select" id="phone1" name="phone">
									<option>010</option>
									<option>011</option>
									<option>016</option>
									<option>017</option>
									<option>019</option>

								</select>
							</div>

							<!-- 대표자 전화번호2 -->
							<div class="col-md-2">
								<input type="number" class="form-control phone" id="phone2"
									name="phone" value="${phone[1]}">
							</div>

							<!-- 대표자 전화번호3 -->
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
							<div class="col-md-5">
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
			</div>
			<jsp:include page="ownerSideMenu.jsp" />
		</div>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	<script>
		// 검색 단추를 누르면 팝업 레이어가 열리도록 설정한다.
		$(function() {
			$("#postcodify_search_button").postcodifyPopUp();
		});
	</script>

	</div>
	</div>
	<jsp:include page="../common/footer.jsp" />

</body>
</html>