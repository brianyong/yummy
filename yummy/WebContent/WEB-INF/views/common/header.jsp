<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" scope="application"
	value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="${contextPath}/resources/css/common/header.css" type="text/css" />
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
	<div class="container">
		<form class="form-signin" method="POST"
			action="${contextPath}/member/login" on>
			<nav class="header navbar navbar-expand-lg navbar-light">
				<a class="navbar-brand" href="#"> <img
					src="${contextPath}/resources/images/logo.png" class="logo">
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon hambuger"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
				  <ul class="navbar-nav ml-auto" id="items">
					<li class="nav-item">
						<div class="dropdown">
							<button class="btn btn-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							더보기
							</button>
							<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item" href="#">공지사항</a>
							<a class="dropdown-item" href="#">자주묻는질문</a>
							<a class="dropdown-item" href="#">리뷰게시판</a>
							</div>
						</div>
					</li>
					
					<c:choose>
						<c:when test="${empty loginMember}">
							<li class="nav-item">
							  <a class="nav-link" href="${contextPath}/member/login">Login </a>
							</li>
							<li class="nav-item">
							  <a class="nav-link" href="#">회원가입</a>
							</li>
						</c:when>
						<c:otherwise>
								<!-- 등급이 O일 때 -->	
								<li class="nav-item active">
								<c:if test="${loginMember.memberGrade == 'O'}">
								<a class="nav-link" href="${contextPath}/member/ownerMyPage">마이페이지</a>
								</c:if>
								
								<!-- 등급이 G일 때 -->
								<c:if test="${loginMember.memberGrade == 'G'}">
								<a class="nav-link" href="${contextPath}/member/myPage">마이페이지</a>
								</c:if>
								
								
								
								
								</li>
								<li class="nav-item active"><a class="nav-link" href="#">주문내역</a></li>
								<li class="nav-item active"><a class="nav-link" href="${contextPath}/member/logout">Logout</a></li>
						</c:otherwise>
					</c:choose>
				  </ul>
				</div>
			</nav>
		</form>
	</div>
	
	 <%-- 로그인 실패와 같은 메세지가 서버로부터 전달되어 온 경우 출력 --%>
	<c:if test="${!empty title }">
		<script>
		
			swal({
				"icon" :"${icon}" ,
				"title":"${title}" ,
				"text" :"${text}"
			});
		</script>
		
		<%-- 변수 제거(특정 스코프에 있는 속성(변수)를 제거할 수 있음) --%>
		<%-- 서버로부터 전달 받은 메세지를 1회 출력 후 제거함 -> 반복 출력 되지 않음 --%>
		<c:remove var="icon"/>
		<c:remove var="title"/>
		<c:remove var="text"/>
	</c:if>
	
	
	

</body>
</html>