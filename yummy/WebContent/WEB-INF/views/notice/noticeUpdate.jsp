<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
<link rel="stylesheet" href="${contextPath}/resources/css/notice/noticeInsert.css" type="text/css"/>
</head>
<body>


   <!-- header.jsp 동적 include -->
   <jsp:include page="../common/header.jsp"/>
   
   <!-- search.jsp 동적 include -->
   <jsp:include page="../common/search.jsp"/>
   
  <div class="container">
        <div class="content">
            <div class="sub-top">
                <h3 class="page-title">공지사항 수정</h3> <!-- 수정버튼을 클릭했을 때 보이는 화면 -->
                <br>
                <hr>
            </div>
            <form class="content-input" action="${contextPath}/notice2/update" method="post"
            role="form" onsubmit="return noticeValidate();">
            <div class="mb-3">
                <label for="noticeTitleInput" class="form-label"> 제목</label>
                <input type="text" class="form-control" id="noticeContent" name="noticeTitle" value="${notice.noticeTitle}">
            </div>
            <div class="mb-3">
                <label for="noticeContentInput" class="form-label"> 내용</label>
                <textarea type="text" class="form-control" id="noticeContent" name="noticeContent" rows="20">${notice.noticeContent}</textarea>
            </div>
            <div class="content-btn">
                <button type="submit" class="btn register">수정</button>
                <button type="reset" class="btn btn-danger cancel" onclick="location.href='${contextPath}/notice/noticeList';">취소</button>
            </div>
            
            <input type="hidden" name="cp" value="${param.cp}">
            <input type="hidden" name="noticeNo" value="${notice.noticeNo}">
            
            </form>
        </div>
  </div>
  
    	<!-- footer.jsp 동적 include -->
	<jsp:include page="../common/footer.jsp"/>
	
	
	<script>
	
	// 유효성검사
			function noticeValidate() {
			if ($("#noticeContent").val().trim().length == 0) {
				alert("제목을 입력해 주세요.");
				$("#title").focus();
				return false;
			}

			if ($("#noticeContent").val().trim().length == 0) {
				alert("내용을 입력해 주세요.");
				$("#content").focus();
				return false;
			}
		}
	
	</script>
</body>
</html>