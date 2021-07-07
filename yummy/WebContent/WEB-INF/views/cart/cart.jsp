<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" href="${contextPath}/resources/css/cart/cart.css" type="text/css"/>
</head>
<body>
   <!-- header.jsp 동적 include -->
   <jsp:include page="../common/header.jsp"/>
   
   <!-- search.jsp 동적 include -->
   <jsp:include page="../common/search.jsp"/>


   <div class="container">
        <div class="content">
          <div class="sub-top">
            <h1 class="page-title" id="store-name">${storeName}</h1>
            <br>
          </div>
          <c:set var="total" value="0"/>
					<c:forEach items="${cartList}" var="cart">
          <div class="row row-title" id="box">
            <div class="col box1"><p>${cart.menuName}</p>
              <ul>
                <li>가격 : ${cart.menuSaleCost}원</li>
                <li>수량 : <input type="number" value="${cart.menuAmount}"></li>
              </ul>
              <p class="totalPrice" name="menuTotal">총 금액 <strong>${cart.menuSaleCost * cart.menuAmount}</strong></p>
            </div>
         
            
            <div class="col box2">
                <button class="delete-btn" onclick="fnRequest('deleteCart', ${cart.menuNo});"><b>삭제</b></button>
            </div>
          </div>
					<c:set var="total" value="${total +(cart.menuSaleCost * cart.menuAmount)}"/>
    		</c:forEach>
          <div class="row-title box3" id="box">
            <button type="button" class="btn btn-warning" onclick="location.href='${contextPath}/store/store?storeNo=${param.storeNo}'">+</button>더 담으러 가기
          </div>

          <div class="row row-title box4" id="box">
            <div class="col-md-6" id="realTotal">
              <b>총 주문금액</b>
            </div>

            <div class="col-md-6" id="realTotalPrice">
            <b>${total}원</b>
            </div>
          </div>
          <div class="previous">
          <button type=submit class="btn btn-warning" id="gogo" onclick="location.href='${contextPath}/cart/orderCart'">주문하러 가기</button>
        </div>
        </div>
  </div>
  
   <jsp:include page="../common/footer.jsp"/>
   
<form action="#" method="POST" name="requestForm">
	<input type="hidden" name="menuNo" id="deleteMenuNo">
</form>  



<script>
function fnRequest(addr, menuNo){
	document.requestForm.action = "${contextPath}/cart/"+addr;
	$("#deleteMenuNo").val(menuNo);
	document.requestForm.submit();
}

</script>
</body>
</html>