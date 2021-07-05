<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <c:set var="contextPath" scope="application"
	value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 전체보기</title>
<link rel="stylesheet" href="${contextPath}/resources/css/notice/noticeList.css" type="text/css"/>
</head>
<body>

   <!-- header.jsp 동적 include -->
  <jsp:include page="../common/header.jsp"/>
   <!-- search.jsp 동적 include -->
   <jsp:include page="../common/search.jsp"/>
         <div class="container">
        <div class="content">
          <div class="sub-top">
            <h3 id="page-title">공지사항</h3>
            ${notice.noticeTitle}
            <hr>
          </div>

        <table class="table" id="tbl-box">
          <thead>
            <tr>
              <th class="col-2 tb-num">글번호</th>
              <th class="col-7 tb-title">제목</th>
              <th class="col-3 tb-date">작성일</th>
            </tr>
          </thead>

		  <%-- 게시글 목록 출력 --%>
          <tbody>
          
          	<c:choose>
          	<%-- 조회된 게시글 목록이 없는 경우 --%>
          	<c:when test="${empty noticeList }">
				<tr>
					<td colspan="6">게시글이 존재하지 않습니다.</td>
				</tr>
			</c:when>

				<%-- 조회된 게시글 목록이 있을 경우 --%>
				<c:otherwise>
	
					<c:forEach items="${noticeList}" var="notice">
	          
			            <tr> <%-- 글번호 --%>
			              <th class="tb-num">${notice.noticeNo}</th>
			              
			              <%-- 글제목 --%>
			              <td><a class="notice-title" href="view?no=${notice.noticeNo}&cp=${pagination.currentPage}">${notice.noticeTitle}</a></td>
			              
			              <%-- 작성일 --%>
			              <td class="tb-date">
			              
			              <fmt:formatDate var="createDate" value="${notice.createDate}"  pattern="yyyy-MM-dd"/>                          
							<fmt:formatDate var="today" value="<%= new java.util.Date() %>"  pattern="yyyy-MM-dd"/>  
							
							<c:choose>
								<%-- 글 작성일이 오늘이 아닐 경우 --%>
								<c:when test="${createDate != today}">
									${createDate}
								</c:when>
								
								<%-- 글 작성일이 오늘일 경우 --%>
								<c:otherwise>
									<fmt:formatDate value="${notice.createDate}"  pattern="HH:mm"/>                          
								</c:otherwise>
							</c:choose>
			              </td>
			            </tr>
	            	</c:forEach>
				</c:otherwise>
          	</c:choose>
          </tbody>

        </table>
        
        <%-- 로그인이 되어있고 관리자인 경우에만 글쓰기 버튼 노출 --%>
        <c:if test="${!empty loginMember && loginMember.memberGrade eq 'A'}">
          <div class="content-btn">
            <button class="btn" id="btn-register" onclick="location.href='${contextPath}/notice2/insertForm';">작성하기</button>
          </div>
        </c:if> 
        
       
        <%---------------------- Pagination start---------------------%>
        <%-- 페이징 처리 시 주소를 쉽게 작성할 수 있도록 필요한 변수를 미리 선언 --%>
        
        <c:set var="pageURL" value="noticeList"/>
        
        <c:set var="prev" value="${pageURL}?cp=${pagination.prevPage}"/>
        <c:set var="next" value="${pageURL}?cp=${pagination.nextPage}"/>
        
         	
        <div class="paging-area">
          <nav class="paging">
            <ul class="pagination">
            <%-- 현재 페이지가 5페이지 초과인 경우 --%>
            <c:if test="${pagination.currentPage > pagination.pageSize}">
            	<li><a class="page-link" href="${prev}">&lt;&lt;</a></li>
            </c:if>
            
            <%-- 현재 페이지가 2페이지 초과인 경우 --%>
			<c:if test="${pagination.currentPage > 2}">
				<li><a class="page-link" href="${pageURL}?cp=${pagination.currentPage - 1}">&lt;</a></li>
			</c:if>
			
			<%-- 페이지 목록 --%>
			<c:forEach var="p" begin="${pagination.startPage}" end="${pagination.endPage}">
				<c:choose>
					<c:when test="${p == pagination.currentPage}">
						<li class="page-item active"><a class="page-link">${p}</a></li>
					</c:when>
					<c:otherwise>
						<li><a class="page-link" href="${pageURL}?cp=${p}">${p}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<%-- 현재 페이지가 마지막페이지 미만인 경우 --%>
			<c:if test="${pagination.currentPage < pagination.maxPage}">
				<li><a class="page-link" href="${pageURL}?cp=${pagination.currentPage + 1}">&gt;</a></li>
			</c:if>
			
			<%-- 현재 페이지가 마지막페이지 미만인 경우 --%>
			<c:if test="${pagination.currentPage - pagination.maxPage + pagination.pageSize < 0}">
				<li><a class="page-link" href="${next}">&gt;&gt;</a></li>
			</c:if>
			
            </ul>
          </nav>
       </div> 
          <%---------------------- Pagination end----------------------%>

		
        </div>


      </div>
   
   
   <jsp:include page="../common/footer.jsp"/>

</body>
</html>