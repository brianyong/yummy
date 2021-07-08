<%@page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cartegory Page</title>



<script src="${contextPath}/resources/js/category/category.js" defer></script>
<!-- defer키워드 넣는 이유: 모든 스크립트 파일을 받을때까지 html창이 표시되지 않음을 방지하기 위해 -->
<!-- 좋아요 아이콘 -->
<script src="https://kit.fontawesome.com/16af357d9c.js" crossorigin="anonymous"></script>

</head>

<body>

	<!-- header.jsp 동적 include -->
	<jsp:include page="../common/header.jsp" />

	<!-- 스타일시트 -->
	<link rel="stylesheet" href="${contextPath}/resources/css/category/category.css">

	<!-- search.jsp 동적 include -->
	<jsp:include page="../common/search.jsp" />

	<div class="Category_Menu">


		<input type="radio" name="tab" id="tab_00" value="0"
			onchange='getCategory(this);'> <label for="tab_00">전체보기</label>

		<input type="radio" name="tab" id="tab_01" value="1"
			onchange='getCategory(this);'> <label for="tab_01">한식</label>

		<input type="radio" name="tab" id="tab_02" value="2"
			onchange='getCategory(this);'> <label for="tab_02">양식</label>


		<input type="radio" name="tab" id="tab_03" value="3"
			onchange='getCategory(this);'> <label for="tab_03">중식</label>

		<input type="radio" name="tab" id="tab_04" value="4"
			onchange='getCategory(this);'> <label for="tab_04">일식</label>

		<input type="radio" name="tab" id="tab_05" value="5"
			onchange='getCategory(this);'> <label for="tab_05">치킨/피자</label> 
			<input type="radio" name="tab" id="tab_06" value="6"
			onchange='getCategory(this);'> <label for="tab_06">야식</label>

		<input type="radio" name="tab" id="tab_07" value="7"
			onchange='getCategory(this);'> <label for="tab_07">카페/디저트</label>

		<select id="Category_Menu_Small" onchange='getCategory(this);'>
			<!-- 작아졌을때 select 박스 -->
			<option value="0">전체보기</option>
			<option value="1">한식</option>
			<option value="2">양식</option>
			<option value="3">중식</option>
			<option value="4">일식</option>
			<option value="5">치킨/피자</option>
			<option value="6">야식</option>
			<option value="7">카페/디저트</option>
		</select>
		
		
		<div class="Category_box con0">


		</div>

		<div class="Category_box con1">


		</div>

		<div class="Category_box con2">


		</div>
		<div class="Category_box con3">

		</div>
		<div class="Category_box con4">

		</div>
		<div class="Category_box con5">

		</div>
		<div class="Category_box con6">

		</div>
		<div class="Category_box con7">
		</div>
		
		
		
	</div>
	

	<!-- footer.jsp 동적 include -->
	<jsp:include page="../common/footer.jsp" />
	
	
	<script>
		
		const t="${param.t}";
	
		$(function(){
			$("input[name='tab']").each(function(){
				if($(this).val()==t){
					$(this).click();
				}
				
			});
			
		})
	</script>

</body>

</html>