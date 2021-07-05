<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" scope="application" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴등록</title>
</head>
<body>
	<!-- header.jsp 동적 include -->
	<jsp:include page="../common/header.jsp" />
	<link rel="stylesheet" href="${contextPath}/resources/css/menu/menuInsert.css" type="text/css" />

	<!-- search.jsp 동적 include -->
	<jsp:include page="../common/search.jsp" />

    <div class="container">
        <div class="sub-top">
            <h3 class="page-title">메뉴등록</h3>
            <br>
            <hr>
        </div>
        <form class="addForm" action="${contextPath}/menu/menuInsert" method="post">
            <div class="row g-3 menu" id="emptyMenu">
                <div class="col-md-12">
                <label for="menuName" class="form-label">메뉴이름</label>
                <input type="text" class="form-control" id="menuName" name="menuName">
                </div>
                <div class="col-md-12">
                <label for="menuPrice" class="form-label">가격</label>
                <input type="text" class="form-control" id="menuPrice" name="menuPrice">
                </div>
                <div class="col-md-12">
                    <label for="menuSalePercent" class="form-label">할인율</label>
                    <input type="text" class="form-control" id="menuSalePercent" name="menuSalePercent">
                </div>
                <div class="col-md-4">
                    <input type="file" class="form-label menuImage" aria-label="file example" name="menuImg">
                </div>
                <div class="col-md-8" id="menu-register">
                    <button type="submit" class="btn registerBtn">등록</button>
                </div>
            </div>
      </form>
    </div>


	<!-- footer.jsp 동적 include -->
	<jsp:include page="../common/footer.jsp" />


</body>
</html>