<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<link rel="stylesheet"
	href="${contextPath}/resources/css/common/sideMenu.css" type="text/css" />

<div class="col-sm-4 mt-5">
	<div class="login-status">
		<div class="login-status2">
			${loginMember.memberName}님 <br> 환영합니다.
		</div>
	</div>


	<ul class="list-group">
		<li class="list-group-item list-group-item-action"><a
			href="myPage">내 정보 조회</a></li>
		<li class="list-group-item list-group-item-action"><a
			href="changePwd">비밀번호 변경</a></li>
		<li class="list-group-item list-group-item-action"><a
			href="secession">회원 탈퇴</a></li>
	</ul>
		</div>