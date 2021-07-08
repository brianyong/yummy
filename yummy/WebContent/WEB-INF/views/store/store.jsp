<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>가게 상세보기</title>

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f19da4b9e291fb61ab3caf09858c50a9&libraries=services,clusterer,drawing"></script>

<!-- js파일 추가 -->
<script src="${contextPath}/resources/js/store/store.js" defer></script>



</head>

<body>

	<!-- header.jsp 동적 include -->
	<jsp:include page="../common/header.jsp" />
<!-- css -->
<link rel="stylesheet"
	href="${contextPath}/resources/css/store/store.css" type="text/css" />

	<div class="container">



		<ul class="all_body">

		<%-- 	<li>
				<div class="banner_img">
					<img src="${contextPath}/resources/images/banner.jpg">
				</div>
			</li> --%>

			<li>

				<div class="store_container">

					<div class="store">가게 이름</div>

					<div class="store_name">${store.storeName}</div>

					<div class="time">영업 시간</div>

					<div class="store_time">${store.storeOpen}~${store.storeClose}</div>

				</div>

			</li>

			<li>

				<div class="tab_container">

					<div class="category_menu">

						<input type="radio" name="tab" id="tab_01" value="tab_01" checked>
						<label for="tab_01">메뉴</label> <input type="radio" name="tab"
							value="tab_02" id="tab_02"> <label for="tab_02">가게
							정보</label> <input type="radio" name="tab" value="tab_03" id="tab_03">
						<label for="tab_03">위치</label>

						<div class="menu_box con1">


							<c:forEach items="${list}" var="item" varStatus="vs">



								<div class="menu_conbox" data-toggle="modal"
									data-target="#exampleModal">
									<div class="Menu_name_content temp">${item.menuName}</div>

									<div class="Menu_basiccost_content">${item.menuPrice}</div>

									<div class="Menu_salecost_content">
										<fmt:parseNumber var="price" integerOnly="true"
											value="${item.menuPrice-item.menuPrice*(item.menuSalePercent/100)}" />${price}</div>
									<input class="temp" type="hidden" value="${item.menuNo}">
									<input class="temp" type="hidden" value="${price}">
									<div class="Menu_img">
										<img src="${contextPath}/${item.menuImg}">
									</div>
								</div>


      

							</c:forEach>

						</div>

						<div class="menu_box con2">

							<div class="information_container">

								<div class="store_info_title">가게 소개</div>
								<textarea id="store_info_text" name="store_info_text" readonly>${store.storeStory}</textarea>

								<div class="sales_info_title">영업 정보</div>
								<textarea id="sales_info_text" name="salse_info_text" readonly>여는시간 : ${store.storeOpen }                                                                                                              닫는시간 : ${store.storeClose }  </textarea>

								<div class="master_info_title">사업자 정보</div>
								<textarea id="master_info_text" name="master_info_text" readonly>사업자 등록번호 : ${store.corNo}                                                                                  상호명 : ${store.storeName }                                                                                                          전화번호 : ${store.storePhone}</textarea>

							</div>

						</div>

						<div class="menu_box con3">

							<div class="location_container">

								<div class="map_title">${store.storeAddr}</div>
								<div id="map"></div>

							</div>

						</div>

					</div>

				</div>

			</li>


		</ul>

	</div>


	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="menuName">메뉴 이름 : ${item.menuName}</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container-fluid">
						<div class="amount">
							<div id="menePrice">할인 가격 :</div>
							<form>
								<span class="amount_text">수량</span> <input type="number"
									name="amount" id="amount" min="0" value="0">
								<button type="button" class="btn btn-warning" value="증가"
									onClick="javascript:this.form.amount.value++;">+</button>
								<button type="button" class="btn btn-warning" id="minus"
									value="감소" onClick="amountMinus(this)">-</button>
							</form>

						</div>

					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-warning" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-warning"
						onclick="fnRequest('cart', ${vs.count});">장바구니에 담기</button>
				</div>
			</div>
		</div>
	</div>


	<form action="#" method="POST" name="requestForm">
		<input type="hidden" name="menuName" id="menuName"> <input
			type="hidden" name="menuNo" id="menuNo"> <input type="hidden"
			name="menuSaleCost" id="menuSaleCost"> <input type="hidden"
			name="menuAmount" id="menuAmount"> <input type="hidden"
			name="storeNo" id="storeNo" value="${param.storeNo}"> <input
			type="hidden" name="storeName" id="storeName"
			value="${store.storeName}">
	</form>


	<script>
		function fnRequest(addr){
			
			// 현재 문서 내부에 name 속성값이 requestForm인 요소의 action 속성 값을 변경
			document.requestForm.action = "../cart/" + addr ;
			
			var amount = $("#amount").val();
			$("#menuAmount").val(amount);
			// 현재 문서 내부에 name 속성 값이 requestForm인 요소를 제출해라
			
			document.requestForm.submit();
			
		}	
	
		// 메뉴 클릭 시 모달창, requestForm 값 변경
		$(".menu_conbox").on("click", function(){
			console.log( $(this).children(".temp"));
			
			$("form[name='requestForm']").children().eq(0).val( $(this).children(".temp").eq(0).text() );
			$("form[name='requestForm']").children().eq(1).val( $(this).children(".temp").eq(1).val() );
			$("form[name='requestForm']").children().eq(2).val( $(this).children(".temp").eq(2).val() );
			
			$("#menuName").text($(this).children(".temp").eq(0).text());
			
			const price = $(this).children(".temp").eq(2).val().toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");

			
			$("#menePrice").text(price + "원");
			
		});
		
		
		
	</script>



	<!-- footer.jsp 동적 include -->
	<jsp:include page="../common/footer.jsp" />

</body>

</html>