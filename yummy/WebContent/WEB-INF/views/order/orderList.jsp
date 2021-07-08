<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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


	<div class="container">

		<h2>주문 내역</h2>
		<br> <br>


				<c:forEach items="${orderList}" var="order" varStatus="vs">
					<div class="orderDetail1">
						<div class="orderPreview1">
							<div id="orderDate1">${order.orderDate}</div>
							<div id="brandImg1">${order.storeName }</div>
							<div id="location1">${order.storeAddress}</div>
							<div id="totalprice1">주문금액</div>

							<p>
								<a class="btn btn-primary btn" data-toggle="collapse"
									href="#collapseExample${vs.count}" role="button"
									aria-expanded="false"
									aria-controls="collapseExample${vs.count}"> + </a>
							</p>
						</div>
						<div class="collapse collapseExample-body"
							id="collapseExample${vs.count}">
							<div class="card card-body" id="detailOpen">
								<div class="form-group">
									<label for="orderList">주문내역</label>
									<table class="table table-bordered" id="orderList">
										<thead>
											<tr class="orderContent">
												<th class="col-6" scope="col">메뉴명</th>
												<th class="col-3" scope="col">수량</th>
												<th class="col-3" scope="col">가격</th>
												<th>
											</tr>
										</thead>

										<tbody>
											<c:set var="total" value="0" />
											<c:forEach items="${order.menuList}" var="menu">
												<tr>
													<td class="orderMenuName">${menu.menuName}</td>
													<td class="orderMenuAmount">${menu.menuAmount}</td>
													<td class="orderMenuPrice">${menu.menuPrice}</td>

													<c:set var="total"
														value="${total + (menu.menuPrice * menu.menuAmount) }" />
												</tr>
											</c:forEach>
										</tbody>

										<tfoot>
											<tr class="allPrice">
												<td colspan="2">총 결제 금액</td>
												<td>${total}</td>
											</tr>

										</tfoot>
									</table>


								</div>
							</div>

						</div>
						<hr>
					</div>
				</c:forEach>
	</div>
	<%---------------------- Pagination start----------------------%>
	<%--페이징 처리 시 주소를 쉽게 작성할 수 있도록 필요한 변수를 미리 선언-------%>


	<c:set var="prev" value="${pageURL}&cp=${pagination.prevPage}" />
	<c:set var="next" value="${pageURL}&cp=${pagination.nextPage}" />

	<div class="my-5">
		<ul class="pagination">

			<%-- 현재 페이지가 10페이지 초과인 경우 --%>
			<c:if test="${pagination.currentPage > pagination.pageSize}">
				<li><a class="page-link" href="${prev}">&lt;&lt;</a></li>
			</c:if>

			<%-- 현재 페이지가 2페이지 초과인 경우 --%>
			<c:if test="${pagination.currentPage > 2}">
				<li><a class="page-link"
					href="${pageURL}&cp=${pagination.currentPage - 1}">&lt;</a></li>
			</c:if>

			<%-- 페이지 번호 목록 --%>
			<c:forEach var="p" begin="${pagination.startPage}"
				end="${pagination.endPage}">

				<c:choose>
					<c:when test="${p==pagination.currentPage}">
						<li class="page-item active"><a class="page-link">${p}</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="${pageURL}&cp=${p}">${p}</a></li>
					</c:otherwise>
				</c:choose>


			</c:forEach>



			<%-- 현재 페이지가 마지막 페이지 미만인 경우 --%>
			<c:if test="${pagination.currentPage < pagination.maxPage }">
				<li><a class="page-link"
					href="${pageURL}&cp=${pagination.currentPage+1}${searchStr}">&gt;</a></li>
			</c:if>

			<%-- 현재 페이지가 마지막 페이지 미만인 경우 --%>
			<c:if test="${pagination.currentPage < pagination.maxPage }">
				<li><a class="page-link" href="${next}">&gt;&gt;</a></li>
			</c:if>

		</ul>
	</div>
	<%---------------------- Pagination end----------------------%>





	<jsp:include page="../common/footer.jsp" />


	<script>
		// 검색 내용이 있을 경우 검색창에 해당 내용을 작성해두는 기능
		(function() {
			var searchKey = "${param.sk}";
			// 파라미터 중 sk가 있을 경우   ex)  "abc"
			// 파라미터 중 sk가 없을 경우   ex)  ""
			var searchValue = "${param.sv}";

			// 검색창 select의 option을 반복 접근
			$("select[name=sk] > option").each(function(index, item) {
				// index : 현재 접근중인 요소의 인덱스
				// item : 현재 접근중인 요소
				// content            content
				if ($(item).val() == searchKey) {
					$(item).prop("selected", true);
				}
			});

			// 검색어 입력창에 searcValue 값 출력
			$("input[name=sv]").val(searchValue);
		})();
	</script>

</body>
</html>