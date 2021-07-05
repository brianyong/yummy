<%@page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>가게 상세보기</title>
<!-- css -->
<link rel="stylesheet" href="${contextPath}/resources/css/store/store.css" type="text/css"/>


<!-- 지도 api -->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f19da4b9e291fb61ab3caf09858c50a9&libraries=services"></script>

<!-- js파일 추가 -->
<script src="${contextPath}/resources/js/store/store.js" defer></script>



</head>

<body>

	<!-- header.jsp 동적 include -->
	<jsp:include page="../common/header.jsp" />

	<ul class="all_body">

		<li>
			<div class="banner_img">
				<img src="#">
			</div>
		</li>

		<li>

			<div class="store_container">

				<div class="store">가게 이름</div>

				<div class="store_name">00분식</div>

				<div class="time">영업 시간</div>

				<div class="store_time">11:00~21:00</div>

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

					<div class="category_box con1">

						<div class="menu_conbox" data-toggle="modal" data-target="#exampleModal">
							<div class="Menu_name_content">까르보나라로제떡볶이</div>

							<div class="Menu_basiccost_content">10,000원</div>

							<div class="Menu_salecost_content">7,000원</div>
							<div class="Menu_img">
								<img src="#">
							</div>
						</div>

						<div class="menu_conbox" data-toggle="modal" data-target="#exampleModal">
							<div class="Menu_name_content">튀김</div>

							<div class="Menu_basiccost_content">10,000원</div>

							<div class="Menu_salecost_content">8,000원</div>
							<div class="Menu_img">
								<img src="#">
							</div>
						</div>

						<div class="menu_conbox" data-toggle="modal" data-target="#exampleModal">
							<div class="Menu_name_content">순대</div>

							<div class="Menu_basiccost_content">10,000원</div>

							<div class="Menu_salecost_content">5,000원</div>
							<div class="Menu_img">
								<img src="#">
							</div>
						</div>

					</div>

					<div class="category_box con2">

						<div class="information_container">

							<div class="store_info_title">가게 소개</div>
							<textarea id="store_info_text" name="store_info_text" readonly>asdfasdf</textarea>

							<div class="sales_info_title">영업 정보</div>
							<textarea id="sales_info_text" name="salse_info_text" readonly>asdfasdf</textarea>

							<div class="master_info_title">사업자 정보</div>
							<textarea id="master_info_text" name="master_info_text" readonly>asdfadsfadsfadsfasdf</textarea>

						</div>

					</div>

					<div class="category_box con3">

						<div class="location_container">

							<div class="map_title">제주특별자치도 제주시 첨단로 242</div>
							<div id="map"></div>

						</div>

					</div>

				</div>

			</div>

		</li>


	</ul>

	<!-- Modal -->
	<div class="modal fade"
		id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="menuName">메뉴 이름</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container-fluid">

						<div class="menu_img">
							<img src="#">
						</div>

						<div class="amount">
							<div class="amount_text">수량</div>

							<form>
								<input type="number" name="amount" min="0" value="0">
								<button type="button" class="btn btn-warning" value="증가"
									onClick="javascript:this.form.amount.value++;">+</button>
								<button type="button" class="btn btn-warning" id="minus" value="감소"
									onClick="amountMinus(this)">-</button>
							</form>

						</div>

					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-warning" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-warning" onclick='amountPlus()'>장바구니에 담기</button>
				</div>
			</div>
		</div>
	</div>


	<button type="button" class="btn btn-warning cart" onclick="location='../cart/cart'">
		장바구니 <span class="badge badge-light cartNo">0</span>
	</button>


	<!-- footer.jsp 동적 include -->
	<jsp:include page="../common/footer.jsp" />

</body>

</html>