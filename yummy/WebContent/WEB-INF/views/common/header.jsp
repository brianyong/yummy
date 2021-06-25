<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" scope="application"
      value = "${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
<link rel="stylesheet" href="${contextPath}/resources/css/common/header.css" type="text/css"/>
</head>
<body>
   <div class="container">
      <nav class="header navbar navbar-expand-lg navbar-light">
         <a class="navbar-brand" href="#">
            <img src="${contextPath}/resources/images/logo.png" class="logo">
         </a>
         <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
           <span class="navbar-toggler-icon hambuger"></span>
         </button>
         
         <div class="collapse navbar-collapse" id="navbarSupportedContent">
           <ul class="navbar-nav ml-auto" id="items">
            <li class="nav-item">
              <a class="nav-link" href="#">공지사항 </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">리뷰게시판 </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">자주묻는질문 </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${contextPath}/member/login">Login </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">회원가입</a>
            </li>
           </ul>
         </div>
      </nav>
   </div>

</body>
</html>