<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>faq</title>
<link rel="stylesheet" href="${contextPath}/resources/css/faq/faqList.css" type="text/css"/>
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
	      <table class="table table-hover" id="tbl-box">
	        <thead>
	          <tr>
	            <th class="col-2 tb-num"scope="col">글번호</th>
	            <th class="col-5 tb-title"scope="col">제목</th>
	            <th class="col-3 tb-date"scope="col">작성일</th>
	            <th class="col-2 tb-name"scope="col">작성자</th>
	          </tr>
	        </thead>
	        <tbody>
	        	<c:choose>
	        		<c:when test="${empty faqList}">
	        			<tr>
	        				<td class="tb-title" colspan="12">게시글이 존재하지 않습니다.</td>
	        			</tr>
	        		</c:when>
	        		<c:otherwise>
	        			<c:forEach items="${faqList}" var="faq">
	        				
		        				<tr>
		        					<%-- 글번호 --%>
		        					<td class="tb-num">${faq.faqNo} </td>
		        					
		        					<%-- 제목 --%>
		        					<td class="tb-title">
			        					<a href="detail?no=${faq.faqNo}&cpage=${pagination.currentPage}">
		        							${faq.faqTitle} 
		        						</a>
		        					</td>
		        					
		        					<%-- 작성일 --%>
		        					<td class="tb-date">
										<fmt:formatDate var="createDate" value="${faq.createDate}"  pattern="yyyy-MM-dd"/>                          
		                                <fmt:formatDate var="today" value="<%= new java.util.Date() %>"  pattern="yyyy-MM-dd"/>                          
		                                 
		                                 <c:choose>
		                                    <%-- 글 작성일이 오늘이 아닐 경우 --%>
		                                    <c:when test="${createDate != today}">
		                                       ${createDate}
		                                    </c:when>
		                                    
		                                    <%-- 글 작성일이 오늘일 경우 --%>
		                                    <c:otherwise>
		                                       <fmt:formatDate value="${faq.createDate}"  pattern="HH:mm"/>                          
		                                    </c:otherwise>
		                                 </c:choose>
									</td>
		        					<%-- 작성자 --%>
		        					<td class="tb-name">${faq.memberName} </td>
		        				</tr>
	        			</c:forEach>
	        		
	        		</c:otherwise>
	        	
	        	</c:choose>
	        
	      
	         
	        </tbody>
	      </table>
	      <c:if test="${ loginMember.memberGrade eq 'A' }">
		      <div class="content-btn">
	            <button class="btn" id="btn-register">
	            	<a href="${contextPath}/faq2/viewFaq">작성하기</a>
	            </button>
	          </div>
          </c:if>
	
			<%---------------------- Pagination start----------------------%>
			<%-- 페이징 처리 시 주소를 쉽게 작성할 수 있도록 필요한 변수를 미리 선언 --%>
			<c:set var="pageURL" value="list?" />
			
			<c:set var="prev" value="${pageURL}&cpage=${pagination.prevPage}" />
			<c:set var="next" value="${pageURL}&cpage=${pagination.nextPage}" />
			
			<div class="my-5">
				<ul class="pagination">
					<%-- 현재 페이지가 5페이지 초과인 경우 --%>
					<c:if test="${pagination.currentPage > pagination.pageSize}">
						<li>
							<a class="page-link" href="${prev}">&lt;&lt;</a>
						</li>
					</c:if>
					
					<%-- 현재 페이지가 1페이지 초과인 경우 --%>
					<c:if test="${pagination.currentPage > 1}">
						<li>
							<a class="page-link" href="${pageURL}&cpage=${pagination.currentPage - 1}">&lt;</a>
						</li>
					</c:if>
					
					<%-- 페이지 번호 목록 --%>
					<c:forEach var="p" begin="${pagination.startPage}"  end="${pagination.endPage}">
							<c:choose>
								<c:when test="${p == pagination.currentPage}">
									<li class="page-item active"><a class="page-link">${p}</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link" href="${pageURL}&cpage=${p}">${p}</a></li>
								</c:otherwise>							
							</c:choose>
					</c:forEach>
					
					<%-- 현재 페이지가 마지막 페이지 미만인 경우 --%>
					<c:if test="${pagination.currentPage < pagination.maxPage }">
						<li>
							<a class="page-link" href="${pageURL}&cpage=${pagination.currentPage+1}">&gt;</a>
						</li>
					</c:if>
					
					<%-- 현재 페이지가 마지막 페이지 미만인 경우 --%>
					<c:if test="${pagination.currentPage - pagination.maxPage + pagination.pageSize < 0 }">
						<li>
							<a class="page-link" href="${next}">&gt;&gt;</a>
						</li>
					</c:if>

				</ul>
			</div>
			<%---------------------- Pagination end----------------------%>
	    </div>
  </div>
	
	
	
	
	<!-- footer.jsp 동적 include -->
	<jsp:include page="../common/footer.jsp"/>

</body>
</html>