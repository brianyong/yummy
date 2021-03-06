<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<link rel="stylesheet" href="${contextPath}/resources/css/main.css"
	type="text/css" />
</head>
<body>
	<!-- header.jsp 동적 include -->
	<jsp:include page="common/header.jsp" />

	<!-- search.jsp 동적 include -->
	<jsp:include page="common/search.jsp" />

	<!-- 오늘의 할인  -->
	<div class="container">
		<div class="sale-list">
			<div class="sale-title">오늘의 할인</div>
			<div class="row">
				<div class="col-sm-6 col-md-3">
					<a href="" class="sale-item"> <img
						src="${contextPath}/resources/images/main/guljack.jpg">
					</a>
				</div>
				<div class="col-sm-6 col-md-3">
					<a href="" class="sale-item"> <img
						src="${contextPath}/resources/images/main/angel.jpg">
					</a>
				</div>
				<div class="col-sm-6 col-md-3">
					<a href="" class="sale-item"> <img
						src="${contextPath}/resources/images/main/domino.jpg">
					</a>
				</div>
				<div class="col-sm-6 col-md-3">
					<a href="" class="sale-item"> <img
						src="${contextPath}/resources/images/main/ddorae.jpg">
					</a>
				</div>
			</div>
			<hr>
		</div>
		<!-- 카테고리 부분 -->
		<div class="category">
			<div class="row">
				<div class="col-xs-6 col-sm-4 col-md-3">
					<a href="${contextPath}/category/category?t=0" class="category-list">
						<img src="${contextPath}/resources/images/main/mainTotal.png">
					</a>
				</div>

				<div class="col-xs-6 col-sm-4 col-md-3">
					<a href="${contextPath}/category/category?t=1" class="category-list">
						<img src="${contextPath}/resources/images/main/mainHansick.png">
					</a>
				</div>

				<div class="col-xs-6 col-sm-4 col-md-3">
					<a href="${contextPath}/category/category?t=2" class="category-list">
						<img src="${contextPath}/resources/images/main/mainEnglish.png">
					</a>
				</div>

				<div class="col-xs-6 col-sm-4 col-md-3">
					<a href="${contextPath}/category/category?t=3" class="category-list">
						<img src="${contextPath}/resources/images/main/mainChina.png">
					</a>
				</div>

				<div class="col-xs-6 col-sm-4 col-md-3">
					<a href="${contextPath}/category/category?t=4" class="category-list">
						<img src="${contextPath}/resources/images/main/mainJapan.png">
					</a>
				</div>

				<div class="col-xs-6 col-sm-4 col-md-3">
					<a href="${contextPath}/category/category?t=5" class="category-list">
						<img src="${contextPath}/resources/images/main/mainChicken.png">
					</a>
				</div>

				<div class="col-xs-6 col-sm-4 col-md-3">
					<a href="${contextPath}/category/category?t=6" class="category-list">
						<img src="${contextPath}/resources/images/main/mainNight.png">
					</a>
				</div>

				<div class="col-xs-6 col-sm-4 col-md-3">
					<a href="${contextPath}/category/category?t=7" class="category-list">
						<img src="${contextPath}/resources/images/main/mainCafe.png">
					</a>
				</div>
			</div>
		</div>
	</div>

	<!-- footer.jsp 동적 include -->
	<jsp:include page="common/footer.jsp" />
	
	
</body>
</html>