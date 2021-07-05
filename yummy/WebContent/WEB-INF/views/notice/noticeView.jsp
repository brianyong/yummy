<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <c:set var="contextPath" scope="application"
	value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세보기</title>
<link rel="stylesheet" href="${contextPath}/resources/css/notice/noticeView.css" type="text/css"/>
</head>
<body>
   <!-- header.jsp 동적 include -->
   <jsp:include page="../common/header.jsp"/>
   
   <!-- search.jsp 동적 include -->
   <jsp:include page="../common/search.jsp"/>
   
     <div class="container">
        <div class="content">

          <div class="sub-top">
            <h3 id="page-title"> 공지사항</h3>
            <br>
            <hr>
          </div>

          <table class="table table-bordered" id="notice-detail">
            <tbody>
              <tr>
                <th scope="col">제목</th>
                <td colspan="5">${notice.noticeTitle}</td>
              </tr>
              <tr>
                <th scope="col">작성일</th>
                <td colspan="5"><fmt:formatDate value="${notice.createDate}" pattern="yyyy년 MM월 dd일 HH:mm:ss"/></td>
              </tr>
              <tr>
                <th scope="col">내용</th>
                <td colspan="5">
                  <div class="textarea-area">
                    ${notice.noticeContent}
                  </div>
                </td>
              </tr>
            </tbody>
          </table>
          <div class="previous">
          	<c:if test="${!empty loginMember && loginMember.memberNo eq notice.memberNo}">
                 <button type="button" class="btn btn-secondary" id="update" onclick="fnRequest('updateForm');">수정</button>
                 <button type="button" class="btn btn-danger cancel" id="delete" onclick="fnRequest('delete');">삭제</button>
              </c:if>
            <a class="btn btn-ligth" id="pre-btn" href="noticeList?cp=${param.cp}">이전으로</a>
          </div>
          
        </div>
  </div>
  
  	<!-- footer.jsp 동적 include -->
	<jsp:include page="../common/footer.jsp"/>
	
	<form action="#" method="POST" name="requestForm">
		<input type="hidden" name="noticeNo" value="${notice.noticeNo}">
		<input type="hidden" name="cp" value="${param.cp}">
		<input type="hidden" name="type" value="${param.type}">
	</form>
	
	<script>
		function fnRequest(addr){
			document.requestForm.action = "../notice2/"+addr;
			document.requestForm.submit();
		}
	</script>
</body>
</html>