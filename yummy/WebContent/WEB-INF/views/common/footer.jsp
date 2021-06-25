<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" scope="application"
      value = "${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>footer</title>
<link rel="stylesheet" href="${contextPath}/resources/css/common/footer.css" type="text/css"/>
</head>
<body>
    <div class="container">
        <div class="footer">
            <div class="info">
            <br>
            <p><strong>(주) 야식에 미치다 야미</strong>
              <span class="bar">|</span>
              <strong>고객센터 1577-9999</strong>
            <br>
            서울특별시 중구 남대문로 120 대일빌딩 2F, 3F <span class="bar">|</span>
            대표자 : 이웃집 개발자 <span class="bar">|</span>
            사업자등록번호 : 111-80-9999 <span class="bar">|</span>
            통신판매업신고:제 2021-서울중구-1000호 <span class="bar">|</span>
            개인정보담당자 : privacy@yummy.co.kr <span class="bar">|</span>
            제휴문의 : partnership@yummy.co.kr <span class="bar">|</span>
            고객만족센터 : support@yummy.co.kr 
            </p>
            </div>
            <div class="guide">
              <p>(주) 야식에 미치다 야미는 통신판매중개자이며 통신판매의 당사자가 아닙니다. 
                  따라서 상품/ 거래정보 및 거래와 관련하여 야미에 등록된 판매자의 고의 또는 과실로 소비자에게 발생하는 손해에 대해
                  (주) 야식에 미치다 야미는 책임을 지지 않습니다. 
                  상품 및 거래에 관하여 보다 정확한 정보는 해당 판매자에게 직접 확인하여 주시기 바랍니다. 
                  <br>
                  Copyright YUMMY. All Rights Reserved.</p>
            </div>
        </div>
    </div>

</body>
</html>