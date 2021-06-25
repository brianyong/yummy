<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="${contextPath}/resources/css/member/login.css" type="text/css"/>
</head>
<body>
	<!-- header.jsp 동적 include -->
	<jsp:include page="../common/header.jsp"/>
	
	<div class="container">
	    <ul class="Login_body">
	        <form action="" method="POST">
	            <li>
	                <div class="Login_Title">
	                    LOGIN
	                </div>
	            </li>
	            <li>
	                <div class="Login_box">
	                    <ul class="Login_box_li">
	                        <li>
	                            <input type="text" placeholder="ID">
	                        </li>
	                        <li>
	                            <div class="guide_text">ID를 입력해주세요</div>
	                        </li>
	                        <li>
	                            <input type="password" placeholder="PASSWORD">
	                        </li>
	                        <li>
	                            <div class="guide_text">비밀번호를 입력해주세요</div>
	                        </li>
	                        <li><input type="radio" name="Login_type" id="Normal" checked>
	                            <label for="Normal">일반회원</label>
	                            <input type="radio" name="Login_type" id="Business">
	                            <label for="Business">사업자</label>
	                        </li>
	                        <li>
	                            <button type="submit">로그인</button>
	                        </li>
	                        <li>
	                            <div class="lost_text">
	                                기억나지 않으신가요? <a href="">아이디/비밀번호 찾기</a>
	                            </div>
	                        </li>
	                    </ul>
	                </div>
	            </li>
	        </form>
	    </ul>
	</div>
	
	
	
	<!-- footer.jsp 동적 include -->
	<jsp:include page="../common/footer.jsp"/>

</body>
</html>