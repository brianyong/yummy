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
						<li class="nav-item"><a class="nav-link" href="#">공지사항 </a></li>
						<li class="nav-item"><a class="nav-link" href="#">리뷰게시판 </a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#">자주묻는질문
						</a></li>


						<%-- 로그인을 했는지 안했는지 구분하는 방법 == session에 loginMember 유무 확인 --%>

						<c:choose>
							<%-- 로그인이 되어있지 않을 때
							empty: 비어있거나 null인 경우 true
							loginMember: 별도의 scope 설정이 없을 경우 
								page -> request -> session -> application
								순서대로 검색하며 loginMember를 찾음
						 --%>
							<c:when test="${empty loginMember}">
								<%-- 로그인 버튼 --%>
								<%-- Modal 동작 버튼은 data-toggle="modal" 속성과 href 속성값으로 보여질 Modal 영역 id를 작성하면된다. --%>
								<li class="nav-item"><a class="nav-link"
									href="${contextPath}/member/login">로그인</a></li>
								<li class="nav-item"><a class="nav-link" href="#">회원가입</a>
								</li>

							</c:when>

							<%-- 로그인 되어있을 때 --%>
							<c:otherwise>
								<li class="nav-item"><a class="nav-link"
									href="${contextPath}/member/myPage">${loginMember.memberName}</a>
								</li>
								<li class="nav-item"><a class="nav-link"
									href="${contextPath}/member/logout">로그아웃</a></li>

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