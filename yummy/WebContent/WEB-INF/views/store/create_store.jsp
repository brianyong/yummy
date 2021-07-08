<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가게정보 등록하기</title>

<link rel="stylesheet" href="${contextPath}/resources/css/member/signUp.css" type="text/css"/>

<style>
::-webkit-file-upload-button, #postcodify_search_button{

  padding: 6px 25px;
  background-color:#F8B03A;
  border-radius: 4px;
  color: white;
  cursor: pointer;
  border: none;

}

::-webkit-file-upload-button:hover, #postcodify_search_button:hover{

	background-color: #263343;
	color: white;
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="container">

		<div class="py-5 text-center">
			<h2>가게정보등록</h2>
			<hr class="hr_Title1">
		</div>

		<div class="row">
			<div class="col-md-6 offset-md-3">

				<form method="POST" action="create_store" class="needs-validation" name="signUpForm" onsubmit="return validate();">
				
					<!-- 상호명 -->
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="b_name">가게명</label>
						</div>
						<div class="col-md-6">
							<input type="text" class="form-control" id="b_name" name="b_name" placeholder="가게명을 입력하세요" required>
						</div>
					</div>
					
					<!-- 사업자등록번호 -->
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="corp_num1">사업자 등록번호</label>
						</div>
						<!-- 사업자번호1 -->
						<div class="col-md-3">
							<input type="number" class="form-control phone" id="corp_num1" name="corp_num" maxlength="3" oninput="numberMaxLength(this);" required>
						</div>

						<!-- 사업자번호2 -->
						<div class="col-md-3">
							<input type="number" class="form-control phone" id="corp_num2" name="corp_num" maxlength="2" oninput="numberMaxLength(this);" required>
						</div>

						<!-- 사업자번호3 -->
						<div class="col-md-3">
							<input type="number" class="form-control phone" id="corp_num3" name="corp_num" maxlength="5" oninput="numberMaxLength(this);" required>
						</div>
					</div>

					<!-- 매장전화번호 -->
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="phone1">매장 번호</label>
						</div>
						<!-- 전화번호1 -->
						<div class="col-md-3">
							<select class="custom-select" id="phone1" name="b_phone" required>
								<option>02</option>
								<option>051</option>
								<option>053</option>
								<option>032</option>
								<option>062</option>
								<option>042</option>
								<option>052</option>
								<option>044</option>
								<option>031</option>
								<option>033</option>
								<option>043</option>
								<option>041</option>
								<option>063</option>
								<option>061</option>
								<option>054</option>
								<option>055</option>
								<option>064</option>
							</select>
						</div>

						<!-- 전화번호2 -->
						<div class="col-md-3">
							<input type="number" class="form-control phone" id="phone2" name="b_phone" required>
						</div>

						<!-- 전화번호3 -->
						<div class="col-md-3">
							<input type="number" class="form-control phone" id="phone3" name="b_phone" required>
						</div>
					</div>
					
					
					<!-- 가게 시간 설정 -->
					<div class="row mb-5 form-row">
						<div class="col-md-3">
							<label for="store_starttime">영업 시간</label>
						</div>
						<div class="col-md-6">
							<input type="text" class="form-control" name="store_starttime" id="store_time"
							maxlength="12" placeholder="오픈 시간 / ex>09:00" required>
							~
							<input type="text" class="form-control" name="store_endtime" id="store_time"
							maxlength="12" placeholder="마감 시간" required>
						</div>
					</div>


					<!-- 매장 소개 -->
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="store_intro">매장 소개</label>
						</div>
						<div class="col-md-6">
							<textarea class="form-control" id="store_intro" name="store_intro" style="resize: none"></textarea>
						</div>
					</div>
					
					<!-- 가게 카테고리 유형 -->
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="category_sel">카테고리</label>
						</div>
						<div class="col-md-6">
							<select class="custom-select" id="category_sel" name="category_sel" required>
								<option>한식</option>
								<option>양식</option>
								<option>중식</option>
								<option>일식</option>
								<option>치킨/피자</option>
								<option>야식</option>
								<option>카페/디저트</option>
							</select>
						</div>

					</div>
					
						
					<!-- 주소 -->
					<!-- 오픈소스 도로명 주소 API -->
					<!-- https://www.poesis.org/postcodify/ -->
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="postcodify_search_button">우편번호</label>
						</div>
						<div class="col-md-3">
							<input type="text" name="address" class="form-control postcodify_postcode5">
						</div>
						<div class="col-md-3">
							<button type="button" class="btn btn-primary" id="postcodify_search_button">검색</button>
						</div>
					</div>

					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="address1">도로명 주소</label>
						</div>
						<div class="col-md-9">
							<input type="text" class="form-control postcodify_address" name="address" id="address1">
						</div>
					</div>

					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="address2">상세주소</label>
						</div>
						<div class="col-md-9">
							<input type="text" class="form-control postcodify_details" name="address" id="address2">
						</div>
					</div>
					
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="storeImg" id="lab_storeImg">대표 이미지 등록</label>
						</div>
						<div class="col-md-6">
							<input type="file" id="storeImg" class="form-label storeImage" aria-label="file example" name="storeImg" />
						</div>
					</div>
						
					<!-- <div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="storeImg" id="file" name="file">사업자등록증 첨부</label>
						</div>
						<div class="col-md-6">
							<input type="file" id="corpImg" class="form-label storeImage" aria-label="file example" name="corpImg" />
						</div>
					</div>	 -->
					
						<hr class="mb-4">
						<button class="btn btn-primary btn-lg btn-block" id="btn_sign" type="submit">등록하기</button>
							
				</form>
			</div>
		</div>
		<br> <br>
		
  	<!-- 오픈소스 도로명 주소 검색 API -->
		<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
		<script>
			// 검색 단추를 누르면 팝업 레이어가 열리도록 설정한다.
			$(function () {
				$("#postcodify_search_button").postcodifyPopUp();
			});
		</script>


	<!-- 사업자등록번호 입력 글자수 제한 스크립트  -->
		<script>
			function numberMaxLength(e) {
				if (e.value.length > e.maxLength) {
					e.value = e.value.slice(0, e.maxLength);
				}
			}
		</script>

	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>

	

</body>
</html>
