<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<link rel="stylesheet" href="${contextPath}/resources/css/main.css" type="text/css"/>
</head>
<body>
	<!-- header.jsp 동적 include -->
	<jsp:include page="common/header.jsp"/>
	
	<!-- search.jsp 동적 include -->
	<jsp:include page="common/search.jsp"/>

    <!-- 오늘의 할인  -->
    <div class="container">  
        <div class="sale-list">
            <div class="sale-title">
                	오늘의 할인
            </div>
            <div class="row">
                <div class="col-sm-6 col-md-3">
                    <a href="" class="sale-item">
                        <img src="${contextPath}/resources/images/sale.jpg">
                    </a>
                </div>
                <div class="col-sm-6 col-md-3">
                    <a href="" class="sale-item">
                        <img src="${contextPath}/resources/images/sale.jpg">
                    </a>
                </div>
                <div class="col-sm-6 col-md-3">
                    <a href="" class="sale-item">
                        <img src="${contextPath}/resources/images/sale.jpg">
                    </a>
                </div> 
                <div class="col-sm-6 col-md-3">
                    <a href="" class="sale-item">
                        <img src="${contextPath}/resources/images/sale.jpg">
                    </a>
                </div>  
            </div>
            <hr>
        </div>
        <!-- 카테고리 부분 -->
        <div class="category">
            <div class="row">
                <div class="col-xs-6 col-sm-4 col-md-3">
                    <a href="" class="category-list">
                        <img src="${contextPath}/resources/images/cate.jpg">
                    </a>
                </div>

                <div class="col-xs-6 col-sm-4 col-md-3">
                    <a href="" class="category-list">
                        <img src="${contextPath}/resources/images/cate.jpg">
                    </a>
                </div>

                <div class="col-xs-6 col-sm-4 col-md-3">
                    <a href="" class="category-list">
                        <img src="${contextPath}/resources/images/cate.jpg">
                    </a>
                </div>

                <div class="col-xs-6 col-sm-4 col-md-3">
                    <a href="" class="category-list">
                        <img src="${contextPath}/resources/images/cate.jpg">
                    </a>
                </div>

                <div class="col-xs-6 col-sm-4 col-md-3">
                    <a href="" class="category-list">
                        <img src="${contextPath}/resources/images/cate.jpg">
                    </a>
                </div>

                <div class="col-xs-6 col-sm-4 col-md-3">
                    <a href="" class="category-list">
                        <img src="${contextPath}/resources/images/cate.jpg">
                    </a>
                </div>

                <div class="col-xs-6 col-sm-4 col-md-3">
                    <a href="" class="category-list">
                        <img src="${contextPath}/resources/images/cate.jpg">
                    </a>
                </div>

                <div class="col-xs-6 col-sm-4 col-md-3">
                    <a href="" class="category-list">
                        <img src="${contextPath}/resources/images/cate.jpg">
                    </a>
                </div>
            </div>
        </div>
    </div>
    
   	<!-- footer.jsp 동적 include -->
	<jsp:include page="common/footer.jsp"/>
</body>
</html>