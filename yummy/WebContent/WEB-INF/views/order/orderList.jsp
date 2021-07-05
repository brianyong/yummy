<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역</title>

<link rel="stylesheet"
	href="${contextPath}/resources/css/order/orderList.css" type="text/css" />
</head>
<body>


	<!-- header.jsp 동적 include -->
	<jsp:include page="../common/header.jsp" />

	<!-- search.jsp 동적 include -->
	<jsp:include page="../common/search.jsp" />


	<div class="container1">
		<h3>주문 내역</h3>
		<br> <br>

		<c:choose>

			<c:when test="${empty orderList}">

				<tr>
					<td colspan="6">게시글이 존재하지 않습니다.</td>
				</tr>
			</c:when>

			<c:otherwise>
				<c:forEach items="${orderList}" var="order">

					<div class="orderDetail1">
						<div class="orderPreview1">
							<div id="orderDate1">${orderInfo.orderDate}</div>
							<div id="brandImg1">가게 브랜드 사진</div>
							<div id="location1">위치</div>
							<div id="totalprice1">주문금액</div>

							<p>
								<b class="btn btn-primary btn" data-toggle="collapse"
									href="#collapseExample" role="button" aria-expanded="false"
									aria-controls="collapseExample"> + </b>

							</p>
						</div>
						<div class="collapse collapseExample-body" id="collapseExample">
							<div class="card card-body" id="detailOpen">
								<div id="orderListText">상세 주문 내역</div>
								<c:forEach items="${orderListDetail} " var="orderListDetail">
									<div class="menuList1">
										<div class="menuDetail1">
											<div class="menuDetail1-1">메뉴상세</div>
											<div class="menuDetail1-2">수량</div>
										</div>
								</c:forEach>
								<div class="menuPrice1">금액상세</div>
							</div>
							<div class="lastPrice1">
								<div id="lastPriceText1">총 결제 금액</div>
								<div id="lastTotalPrice1">최종 결제금액</div>
							</div>


						</div>
					</div>

					<hr>

				</c:forEach>
			</c:otherwise>
		</c:choose>





		<jsp:include page="../common/footer.jsp" />
</body>
</html>