<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" scope="application" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴관리</title>
</head>
<body>
	<!-- header.jsp 동적 include -->
	<jsp:include page="../common/header.jsp" />
	<link rel="stylesheet" href="${contextPath}/resources/css/menu/menuUpdate.css" type="text/css" />

	<!-- search.jsp 동적 include -->
	<jsp:include page="../common/search.jsp" />

	<div class="container">
		<div class="content">
			<div class="sub-top">
				<h3 class="page-title">메뉴관리</h3>
				<br>
				<hr>
			</div> 
			<table class="table table-hover" id="tbl-box">
				<thead>
					<tr>
						<th class="col-3 tb-num" scope="col">메뉴번호</th>
						<th class="col-4 tb-title" scope="col">메뉴명</th>
						<th class="col-3 tb-price" scope="col">판매가격</th>
						<th class="col-2 icon" scope="col"></th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${menuList}" var="menu">
						<tr>
							<th class="tb-num" scope="row">${menu.menuNo}</th>
							<td class="tb-nm">${menu.menuName}</td>
							<td class="tb-price" id="tb-price"><fmt:parseNumber var="price" integerOnly="true" value="${menu.menuPrice-menu.menuPrice*(menu.menuSalePercent/100)}"/>${price}</td>
							<td class="tb-btn">
								<button type="button" class="btn plus">+</button>
								<button type="button" class="btn minus">-</button>
							</td>
						</tr>

						<tr>
							<td colspan="12" class="menu-datail">
								<form class="addForm" action="${contextPath}/menu/menuUpdate" method="post">
												<input type="hidden" name="menuNo" value="${menu.menuNo}">
									<div class="row g-3 menu" id="emptyMenu">
										<div class="col-md-12">
											<label for="menuName" class="form-label">메뉴이름</label> <input type="text" class="form-control" id="menuName" name="menuName" value="${menu.menuName}">
										</div>
										<div class="col-md-6">
											<label for="menuPrice" class="form-label">원가</label> <input type="text" class="form-control" id="menuPrice" name="menuPrice" value="${menu.menuPrice}">
										</div>
										<div class="col-md-6">
											<label for="menuSalePercent" class="form-label">할인율</label> <input type="text" class="form-control" id="menuSalePercent" name="menuSalePercent" value="${menu.menuSalePercent}">
										</div>
										<div class="col-md-4">
											<input type="file" class="form-label menuImage" aria-label="file example" name="menuImg">
										</div>
										<div class="col-md-8" id="update">
											<button type="submit" class="btn updateBtn">수정</button>
											<button type="button" class="btn deleteBtn" onclick="fnRequest('menuDelete', ${menu.menuNo});">삭제</button>
										</div>
									</div>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="menu-register">
				<button type="button" class="btn registerBtn" id="registerBtn" onclick="location.href='${contextPath}/member/ownerMyPage'">확인</button>
			</div>
		</div>
	</div>

	<!-- footer.jsp 동적 include -->
	<jsp:include page="../common/footer.jsp" />

 <form action="#" method="POST" name="requestForm">
	<input type="hidden" name="menuNo" id="deleteMenuNo">
</form>  

	<script>
		$(".plus").on("click", function() {	
			$(".menu-datail").eq($(this).index(".plus")).slideDown(400);
		});
		
		
		$(".minus").on("click", function() {
			$(".menu-datail").eq($(this).index(".minus")).slideUp(100);
		});
		
	function fnRequest(addr, menuNo){
		document.requestForm.action = "../menu/"+addr;
		$("#deleteMenuNo").val(menuNo);
		document.requestForm.submit();
	}
		
		
	</script>
</body>
</html>