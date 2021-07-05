<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				
				<button class="btn btn-primary btn-lg btn-block" id="btn_sign" type="button" onclick="location.href = '${contextPath}/member/signUp'">
				일반회원으로 가입하기
				</button> <br>
				
				<button class="btn btn-primary btn-lg btn-block" id="btn_sign" type="button" onclick="location.href = '${contextPath}/member/busi_signUp'">
				비즈니스회원으로 가입하기
				</button>
			</div>
		</div>
		<br> <br>
		
  
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>


</body>
</html>
