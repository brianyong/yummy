    var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption);

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('제주특별자치도 제주시 첨단로 242', function (result, status) {

    // 정상적으로 검색이 완료됐으면 
    if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:100%;height: 300px;text-align:center;padding:6px 0;">우리회사</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);

        var latlng = map.getCenter();

        map.relayout();
    }
});

/* 탭 메뉴 선택에 따라 div 영역 보이게하는 부분 */

$(document).ready(function () {
    $(".con1").css("display", "block");
    
    $(".con2").css("display", "none");
    $(".con3").css("display", "none");
});

$("#tab_01").on("click", function () {

    $(".con1").css("display", "block");

    $(".con2").css("display", "none");
    $(".con3").css("display", "none");

});

$("#tab_02").on("click", function () {

    $(".con2").css("display", "block");

    $(".con1").css("display", "none");
    $(".con3").css("display", "none");

});

$("#tab_03").on("click", function () {


    $(".con3").css("display", "block");

    $(".con1").css("display", "none");
    $(".con2").css("display", "none");

    map.relayout();

    map.setCenter(new kakao.maps.LatLng(33.450701, 126.570667));

});


$('.modal').on('hidden.bs.modal', function () {
  $(this).find('form')[0].reset()
});


function amountMinus(el){
	
	if($('input[name=amount]').val() <= 0){
		$("#minus").prop("disabled");
	}else{
		$("#minus").prop("disabled",false);
		let count = $(el).parent().children().eq(0).val();
		$(el).parent().children().eq(0).val(--count);
	}
}


function amountPlus(el){
		let count = $(el).parent().children().eq(0).val();
		$(el).parent().children().eq(0).val(++count);
	

}












