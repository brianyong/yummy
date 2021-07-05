<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>faq 수정</title>
<link rel="stylesheet" href="${contextPath}/resources/css/faq/faqInsert.css" type="text/css"/>
</head>
<body>
	<!-- header.jsp 동적 include -->
	<jsp:include page="../common/header.jsp"/>
	
	<!-- search.jsp 동적 include -->
	<jsp:include page="../common/search.jsp"/>
	
	
	<div class="container">
	    <div class="content">
	      <div class="sub-top">
	          <h3 class="page-title"> 자주묻는질문 등록</h3>
	          <br>
	          <hr>
	      </div>
	      <form class="content-input" action="${contextPath}/faq2/updateFaq" method="POST" onsubmit="return faqValidate();">
	          <div class="mb-3">
	              <label for="faqTitleInput" class="form-label"> 제목</label>
	              <input type="text" class="form-control" name="faqTitle" id="faqTitleInput" value="${faq.faqTitle}" > 
	          </div>
	          <div class="mb-3">
	              <label for="faqContentInput" class="form-label"> 내용</label>
	              <textarea type="text" class="form-control" name="faqContent" id="faqContentInput" rows="15" >${faq.faqContent}</textarea>
	          </div>
	          <div class="content-btn">
	              <button type="submit" class="btn" id="register">등록</button>
	              <button type="button" class="btn btn-danger cancel"  onclick="location.href='${contextPath}/faq/list?cpage=1';">취소</button>
	          </div>
	          
	          	<input type="hidden" name="cpage" value="${param.cpage}">
				<input type="hidden" name="faqNo" value="${faq.faqNo}">
	      </form>
	    </div>
  	</div>    
	
	<!-- footer.jsp 동적 include -->
	<jsp:include page="../common/footer.jsp"/>

	<script>
	
	// 유효성 검사 
	function faqValidate() {
		if ($("#faqTitleInput").val().trim().length == 0) {
			alert("제목을 입력해 주세요.");
			$("#faqTitleInput").focus();
			return false;
		}

		if ($("#faqContentInput").val().trim().length == 0) {
			alert("내용을 입력해 주세요.");
			$("#faqContentInput").focus();
			return false;
		}
	}
	</script>
</body>
</html>