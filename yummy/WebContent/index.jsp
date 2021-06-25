<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" scope="application"
	value="${pageContext.servletContext.contextPath}" />
	
	
<jsp:forward page="main" />


<%-- main 이라는 요청을 받는 Servlet으로 요청 위임  --%>
