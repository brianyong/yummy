<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자주묻는질문 상세보기</title>
<link rel="stylesheet" href="${contextPath}/resources/css/faq/faqDetail.css" type="text/css"/>
</head>
<body>
	<!-- header.jsp 동적 include -->
	<jsp:include page="../common/header.jsp"/>
	
	<!-- search.jsp 동적 include -->
	<jsp:include page="../common/search.jsp"/>
	
	
	<div class="container">
	    <div class="content">
	    
	      <div class="sub-top">
	        <h3 class="page-title"> 자주 묻는 질문</h3>
	        <br>
	        <hr>
	      </div>
		      <table class="table table-bordered faq-detail">
		        <tbody>
		          <tr>
		            <th scope="col">제목</th>
		            <td colspan="5">${faq.faqTitle}</td>
		          </tr>
		          <tr>
		            <th scope="col">작성일</th>
		            <td colspan="5">${faq.createDate}</td>
		          </tr>
		          <tr>
		            <th scope="col">작성자</th>
		            <td colspan="5">${faq.memberName}</td>
		          </tr>
		          <tr>
		            <th scope="col">내용</th>
		            <td colspan="5">
		              <div class="textarea-area">
		                ${faq.faqContent}
		              </div>
		            </td>
		          </tr>
		        </tbody>
		      </table>
		      <div class="previous">
		      	<c:if test="${!empty loginMember && loginMember.memberNo eq faq.memberNo}">
			        <button type="button" class="btn btn-secondary" id="update" onClick="fnRequest('updateView');">수정</button>
			        <button type="button" class="btn btn-danger cancel" id="delete" onclick="location.href='${contextPath}/faq2/deleteFaq?no=${param.no}';">
			        	삭제
			        </button>
		        </c:if>
		        <a class="btn btn-light" id="pre-btn" href="list?cpage=${param.cpage}">이전으로</a>
		      </div>
	    </div>
  	</div>
	
	<!-- footer.jsp 동적 include -->
	<jsp:include page="../common/footer.jsp"/>
	
	<form action="#" method = "POST" name = "requestForm">
		<input type="hidden" name="faqNo" value="${faq.faqNo}">
		<input type="hidden" name="cpage" value="${param.cpage}">
	</form>
	
	<script>
	function fnRequest(addr){
		
		document.requestForm.action = "../faq2/" + addr ;
		
		document.requestForm.submit();
	}
	
	</script>

</body>
</html>