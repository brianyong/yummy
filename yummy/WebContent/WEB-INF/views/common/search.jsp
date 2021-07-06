<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search</title>
<link rel="stylesheet" href="${contextPath}/resources/css/common/search.css" type="text/css"/>
<style>
   #search{
      background-image: url(${contextPath}/resources/images/banner.jpg)
   }
</style>
</head>
<body>
    <div class="container">
        <div id="search"">
            <div class="input-group input-box">
              <span class="input-group-btn">
                <a class="btn btn-default" id="gps" type="button" href="${contextPath}/gps/list">
                  <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
                  <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z"/>
                  </svg>
                </a>  
              </span>
              <form class="input-group" id="input-search" action="${contextPath}/gps/searchView" method="POST" >
                <input type="search" class="form-control" aria-describedby="button-addon" name="searchGps" id="searchGps" placeholder="예시)서울특별시 노원구 ">
                <button class="btn" type="submit" id="button-addon">검색</button>
              </form>
            </div>
          </div>
    </div>
    

</body>
</html>