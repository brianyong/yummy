<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 등록</title>
<link rel="stylesheet" href="${contextPath}/resources/css/notice/noticeRegister.css" type="text/css"/>
</head>
<body>
   <!-- header.jsp 동적 include -->
   <jsp:include page="../common/header.jsp"/>
   
   <!-- search.jsp 동적 include -->
   <jsp:include page="../common/search.jsp"/>
   
  <div class="container">
        <div class="content">
            <div class="sub-top">
                <h3 class="page-title"> 공지사항 등록</h3>
                <br>
                <hr>
            </div>
            <form class="content-input">
            <div class="mb-3">
                <label for="noticeTitleInput" class="form-label"> 제목</label>
                <input type="text" class="form-control" id="noticeTitleInput" placeholder="제목 입력">
            </div>
            <div class="mb-3">
                <label for="noticeContentInput" class="form-label"> 내용</label>
                <textarea type="text" class="form-control" id="noticeContentInput" placeholder="내용 입력" rows="20"></textarea>
            </div>
            <div class="content-btn">
                <button type="submit" class="btn register" onclick="history.back()">등록</button>
                <button type="reset" class="btn btn-danger cancel">취소</button>
            </div>
            </form>
        </div>
  </div>
  
    	<!-- footer.jsp 동적 include -->
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>