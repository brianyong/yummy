
// raido 버튼 클릭 시 select도 같은 값을 선택하게 하기
const tabArr = document.querySelectorAll('input[name="tab"]');
for (const tab of tabArr) {
   tab.addEventListener("change", function () {
      const tabId = this.getAttribute("id");

      const optionArr = document.querySelectorAll("#Category_Menu_Small > option");

      for (const opt of optionArr) {
         if (opt.value == tabId) {
            opt.setAttribute("selected", true);
         } else {
            opt.removeAttribute("selected");
         }
      }

   });
}

// select 값 변경 시 radio 도 같은 값을 선택하게 하기
const categoryBox = document.querySelector('#Category_Menu_Small');
categoryBox.addEventListener("change", function () {
   const tabArr = document.querySelectorAll('input[name="tab"]');
   //console.log(categoryBox.value)

   for (const tab of tabArr) {
      if (categoryBox.value == tab.id) {
         tab.click();
      }
   }

});


var contextPath = getContextPath();

function getContextPath() {
    var hostIndex = location.href.indexOf( location.host ) + location.host.length;
    return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
}


var categoryNo = "";

function getCategory(el){
	categoryNo = $(el).val(); //선택된 값을 얻어옴
   	//console.log(categoryNo);
   	console.log(contextPath);

	var url = contextPath+"/category/category";
	
   	console.log(categoryNo);
	
	$.ajax({
		url : url,
		data : {"categoryNo" : categoryNo } ,
		type : "POST",
		dataType : "JSON",
		success : function(list){
			
			console.log(list);   
			   

				
			//var store = contextPath + "store/store?type="+item.storeNo;
			// 화면 초기화 
			$(".Category_box").html("");
			
			$.each(list, function(index, item){
				
				var li = $("<li>").addClass("storeli");
												
			/*	var div = $("<div>").addClass("big").attr("onclick", "storeView("+item.storeNo+")");
				var lImg = $("<div>").addClass("dimg");
				var Img = $("<img>").addClass("img").attr("src",contextPath+item.storeImg);
				var lName = $("<div>").addClass("storeName").text(item.storeName);
				var like = $("<i>").addClass("fas").addClass("fa-heart");
				var lGood = $("<div>").addClass("storeGood").text(item.goodCount);
				
				// div 태그에 다 붙여줌.					
				div.append(lImg).append(Img).append(lName).append(like).insertBefore(lGood);
				
				li.append(div);*/
				
				var big = $("<div>").addClass("big").attr("onclick", "storeView("+item.storeNo+")");
				var dimg = $("<div>").addClass("img");
				var img = $("<img>").attr("src",contextPath+item.storeImg);
				var content = $("<div>").addClass("content");
				var storeName = $("<div>").addClass("storeName").text(item.storeName);
				var storeGood = $("<div>").addClass("storeGood");
				var storeheart = $("<div>").addClass("storeheart");
				var good = $("<div>").addClass("good").text(item.goodCount);
				var heart = $("<i>").addClass("fas").addClass("fa-heart");
				
				dimg.append(img);
				
				
				storeheart.append(heart);
				
				storeGood.append(storeheart).append(good);

				content.append(storeName).append(storeGood);
				
				big.append(dimg).append(content);
				
				li.append(big);
				
				$(".Category_box").append(li);
			});
				
			
		},
		error : function(){
			console.log("실패");
		}
	});
}





function storeView(storeNo){
	
	console.log(storeNo);
	console.log(contextPath);

	var url = contextPath+"/store/store?storeNo="+storeNo;
	location.href = url;

	
}




