<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="${contextPath}/resources/css/common/ownerSideMenu.css"
	type="text/css" />
</head>
<body>

	<div class="col-sm-4 mt-5">
		<div class="login-status">
			<div class="login-status2">
				${loginMember.memberName} 점주님 <br> 환영합니다.
			</div>
		</div>

		<ul class="list-group">
			<li class="list-group-item list-group-item-action"><a
				href="${contextPath}/menu/menuList">메뉴 관리</a></li>
      <li class="list-group-item list-group-item-action"><a
         href="${contextPath}/menu/insertForm">메뉴 등록</a></li>
			<li class="list-group-item list-group-item-action"><a
				href="changePwd">비밀번호 변경</a></li>
			<li class="list-group-item list-group-item-action"><a
				href="secession">회원 탈퇴</a></li>
		</ul>
	</div>
	</div>

</body>
</html>