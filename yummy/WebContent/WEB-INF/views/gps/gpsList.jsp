<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>.
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gps</title>
</head>
<body>
	<!-- header.jsp 동적 include -->
	<jsp:include page="../common/header.jsp"/>
	
	<link rel="stylesheet" href="${contextPath}/resources/css/gps/gpsList.css" type="text/css"/>
     <div class="container">
          <div class="sub-top">
            <h3 class="page-title"> 위치 검색</h3>
            <br>
            <hr>
          </div>
          <div id="map"></div>
          <input type="hidden" id="searchGps" value="${searchGps}" >
    </div>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f19da4b9e291fb61ab3caf09858c50a9&libraries=services,clusterer,drawing"></script>
   	<script>
   	  var searchGps = $("#searchGps").val();
       
      var geocoder = new kakao.maps.services.Geocoder();
      var marker = new kakao.maps.Marker()
       
      if(searchGps == "current"){
       	  
       	// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
       	if (navigator.geolocation) {
       		currentAddr(selectStoreList);
       	    
       	}else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
       	    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
       	        message = 'geolocation을 사용할수 없어요..'
       	}
     }else{
    	 selectStoreList(searchGps);
     }
         
          
     function currentAddr(fn){
     	
     	// GeoLocation을 이용해서 접속 위치를 얻어옵니다
 	    navigator.geolocation.getCurrentPosition(function(position) {
 	        
	        var lat = position.coords.latitude, // 위도
	            lon = position.coords.longitude; // 경도
	    	         
	 	    getAddr(lat,lon);
	            
	       	function getAddr(lat,lon){
	           let geocoder = new kakao.maps.services.Geocoder();
	
	           let coord = new kakao.maps.LatLng(lat, lon);
		           
	           let callback = function(result, status) {
	               if (status === kakao.maps.services.Status.OK) {
	                   searchGps = result[0].address.address_name;
	                   //console.log(searchGps);
	                   fn(searchGps);
	               }
	           };
	           geocoder.coord2Address(coord.La, coord.Ma, callback);
	       }
 	            
 	            
      });
     	
     	
    }
        
    function selectStoreList(searchGps){
         $.ajax({
              url :"${contextPath}/gps/search", 
              type : "POST",
              data : {"searchGps" : searchGps},
	      	  type : "POST",
	          dataType : "JSON", 
              success : function(sList){
                 if(sList != null){ 
                 	createMap(sList);
                 	console.log(sList);
                 }
              },
              error : function(){
                 console.log("위치 검색 실패");
              }
                 
           });
      }
          
          
     function createMap(sList) {

   	    var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
   	        mapOption = {
   	          center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
   	          level: 6 // 지도의 확대 레벨
   	       };
   	    // 지도를 생성합니다    
   	    var map = new kakao.maps.Map(mapContainer, mapOption);
   	 
   	    // 주소-좌표 변환 객체를 생성합니다
   	    for (var i = 0; i < sList.length; i++) {
   	       //console.log(sList[i].storeName);
   	       //console.log(sList[i].storeAddr);
   	 
   	       getLocation(function (latlng, storeName) {
   	          // console.log(latlng);
   	 
   	          // 결과값으로 받은 위치를 마커로 표시합니다
   	          marker = new kakao.maps.Marker({
   	             map: map,
   	             position: latlng,
   	             title: storeName
   	          });
   	 
   	          // 인포윈도우로 장소에 대한 설명을 표시합니다
   	          var infowindow = new kakao.maps.InfoWindow({
   	             content: '<div style="width:150px;text-align:center;padding:6px 0;">' + storeName + '</div>'
   	          });
   	          infowindow.open(map, marker);
   	 
   	          // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
   	          map.setCenter(latlng);
   	 
   	       }, sList[i].storeAddr, sList[i].storeName);
   	 
   	    }
   	 }
        	 
        	 
   	 // 주소를 가지고 좌료 얻어오기
   	 function getLocation(callbackFn, storeAddr, storeName) {
   	 
   	    // 주소로 좌표를 검색합니다
   	    geocoder.addressSearch(storeAddr, function (result, status) {
   	 
   	       // 정상적으로 검색이 완료됐으면 
   	       if (status === kakao.maps.services.Status.OK) {
   	 
   	          var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
   	 
   	          callbackFn(coords, storeName);
   	       }
   	    });
   	 }
     
</script>

	
	<!-- footer.jsp 동적 include -->
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>