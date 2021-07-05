<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>placeOrder</title>
<link rel="stylesheet" href="${contextPath}/resources/css/order/placeOrder.css"
	type="text/css" />
</head>
<body>
	<!-- header.jsp 동적 include -->
	<jsp:include page="../common/header.jsp" />

	<!-- 주문하기  -->
	<div class="container">
		<div class="sub-top">
			<h3 class="page-title">주문하기</h3>
			<br>
			<hr>
		</div>
		<form class="orderForm">
			<div class="form-group">
				<label for="visitTime">방문 예정 시간</label> <input type="datetime-local"
					value="now" min="now" class="form-control" id="visitTime"
					placeholder="name@example.com">
			</div>
			<div class="form-group">
				<label for="orderPhone">주문자 휴대전화 번호</label> <input type="text"
					size="20" class="form-control" id="orderPhone"> </input>
			</div>
			<div class="form-group">
				<label for="orderRequest">주문시 요청사항</label>
				<textarea class="form-control" id="orderRequest" rows="5"></textarea>
			</div>
			<div class="form-group">
				<label for="orderStoreName">매장명</label> <input type="text" size="20"
					class="form-control" id="orderStoreName"></input>
				<div class="form-control" id="storeNumber">매장번호데이터</div>
			</div>
			<div class="form-group">
				<label for="orderStoreLocation">매장주소</label> <input type="text"
					class="form-control" id="orderStoreLocation"></input>
			</div>
			<div class="form-group">
				<label for="orderList">주문내역</label>
				<table class="table table-bordered" id="orderList">
					<thead>
						<tr class="orderContent">
							<th class="col-6" scope="col">메뉴명</th>
							<th class="col-3" scope="col">수량</th>
							<th class="col-3" scope="col">가격</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="orderMenuName">떡볶이</td>
							<td class="orderMenuAmount">2</td>
							<td class="orderMenuPrice">5000</td>
						</tr>
						<tr>
							<td class="orderMenuName">튀김</td>
							<td class="orderMenuAmount">2</td>
							<td class="orderMenuPrice">5000</td>
						</tr>
					</tbody>
					<tfoot>
						<tr class="allPrice">
							<td colspan="2">총 결제 금액</td>
							<td>10000</td>
						</tr>

					</tfoot>
				</table>
			</div>
			<div class="form-group warning">
				<p>※ 상품 수령 및 결제 유의사항 ※</p>
				<p>최소한의 프로세스로 최적의 가격에 양질의 음식의 제공하기 위해 방문 포장 서비스만을 제공하고 있습니다.</p>
				<p>제품의 수령을 위해서는 위에 적인 매장 주소로 방문 해주시기 바랍니다.</p>
			</div>
			<div class="btnGroup">
				<button class="btn btn-lg btn-light" id="orderBtn" type="submit">주문하기</button>
				<button class="btn btn-lg btn-danger" id="cancelBtn" type="reset">취소</button>
			</div>
		</form>
	</div>

		<jsp:include page="../common/footer.jsp"/>

</body>
</html>