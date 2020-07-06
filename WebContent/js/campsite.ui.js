
var rodeX;
var rodeY;
/**
 * 지도의 포인트를 클릭했을 때 피쳐 정보창 불러옴
 * @param feature
 */
function FeatureInfoLoad (feature) {
	console.log(feature.get('cam_id'));
    var postdata = {
        'action': 'SelectPoint',
        'cam_id': feature.get('cam_id')
      
    };
    $.ajax({
        url: "DreamTree.do",
        cache: false,
        data: postdata,

    }).done(function(data) {
        $("#FeatureInfo").html(data);
        $("#FeatureInfo").show();
    });
    
    /**포인트 클릭시 해당 포인트 x y값  저장 */
    var x = feature.values_.coord_lat;
    var y = feature.values_.coord_lon;
    rodeX=x;
    rodeY=y;
    console.log(x);
    console.log(y);
    Storage();  
}
/**로드뷰에 쓸 x y 값 사용자 localStorage 에 저장 */
function Storage(){
	localStorage.setItem('x',rodeX);
	localStorage.setItem('y',rodeY);
	
}
function FeatureInfoWndClose() {
    $("#FeatureInfo").hide();
    $("#FeatureInfo h3").text("-");
    $("#FeatureInfo td").text("-");
}

/**테마선택*/
function selectTheme(themename){
	var postdata={'action':'SelectTheme','theme':themename};
	console.log(postdata)
	$.ajax({
	       url: "DreamTree.do",
	       cache: false,
	       dataType:"json",
	       data: postdata,
	
	   }).done(function(data) {
		   console.log(data);
		   var count = data.length;
		   var strTemp="";
		   for(var i =0;i<count;i++){
			   strTemp+=data[i];
			   strTemp+=(i<(count-1)?',':'');
		   }
		   console.log(strTemp);
		   
		   setGIDList(strTemp);
	   });
	
}

/**지역선택*/
function selectRegion(regionname){
	var postdata={'action':'SelectRegion','region':regionname};
	$.ajax({
	       url: "DreamTree.do",
	       cache: false,
	       dataType:"json",
	       data: postdata,
	
	   }).done(function(data) {
		   var count = data.length;
		   var strTemp="";
		   for(var i =0;i<count;i++){
			   strTemp+=data[i];
			   strTemp+=(i<(count-1)?',':'');
		   }
		   console.log(strTemp);   
		   setGIDList(strTemp);
	   });
	switch (regionname) {
    case "강남구":
    	zoom2(37.495482,127.055236);
        break;
    case "강동구":
        zoom2(37.550519, 127.145054);
        break;
    case "강북구":
    	zoom2(37.630808, 127.023788);
        break;
    case "관악구":
    	zoom2(37.468996, 126.942513);
        break;
    case "광진구":
    	zoom2(37.547363, 127.084756);
        break;
    case "구로구":
    	zoom2(37.495523, 126.850869);
        break;
    case "금천구":
    	zoom2(37.462493, 126.900779);
        break;
    case "노원구":
    	zoom2(37.651828, 127.073594);
        break;
    case "도봉구":
    	zoom2(37.665883, 127.034386);
        break;
    case "동대문구":
    	zoom2(37.581636, 127.054231);
        break;
    case "동작구":
    	zoom2(37.502150, 126.939400);
        break;
    case "마포구":
    	zoom2(37.559166, 126.904047);
        break;
    case "서초구":
    	zoom2(37.470801, 127.032926);
        break;
    case "성동구":
    	zoom2(37.550258, 127.041821);
        break;
    case "성북구":
    	zoom2(37.599608, 127.017968);
        break;
    case "송파구":
    	zoom2(37.504318, 127.116535);
        break;
    case "양천구":
    	zoom2(37.519371, 126.856099);
        break;
    case "영등포구":
    	zoom2(37.519421, 126.911761);
        break;
    case "용산구":
    	zoom2(37.530860, 126.980624);
        break;
    case "은평구":
    	zoom2(37.616561, 126.924039);
        break;
    case "종로구":
    	zoom2(37.589535, 126.971528);
        break;
    case "중구":
    	zoom2(37.559987, 126.992191);
        break;
    case "중량구":
    	zoom2(37.597547, 127.092652);
        break;
    default:
             
        break;
  }
	   
}

/**검색*/
function SearchSubmit()
{
	var x = document.getElementById("searchtitle").value;
	var postdata={'action':'Search','title':x};
	console.log(postdata)
	$.ajax({
	       url: "DreamTree.do",
	       cache: false,
	       dataType:"json",
	       data: postdata,
	   }).done(function(data) {
		   console.log(data);
		   var count = data.length;
		   var strTemp="";
		   for(var i =0;i<count;i++){
			   strTemp+=data[i];
			   strTemp+=(i<(count-1)?',':'');
		   }
		   console.log(strTemp);
		   
		   setGIDList(strTemp);
	   });
}


/**
 * geolocation  컴퓨터 에서 사용 시 위치정보가 정확하지 않음 (오차범위 +-50m 이내)
 */
function getLocation() {
	  if (navigator.geolocation) {
	    navigator.geolocation.getCurrentPosition(showPosition);
	  } else { 
	    x.innerHTML = "이 브라우저에서는 Geolocation이 지원되지 않습니다.";
	  }
	}

	function showPosition(position) {
	  var x = position.coords.latitude;
	  var y = position.coords.longitude;
	   
	    
	  var marker = new ol.Overlay
	 
		({
			 position:ol.proj.transform([y,x],'EPSG:4326','EPSG:3857'),
			 offset:[-10,-10],
			 element: $('<img src="images/gps.png" alt="사람" width="90" height="90">'),	 
			 stopEvent: false
		});
		 
		map.addOverlay(marker);
		
		 
	     //지도확대
		 var markerCoordinate = ol.proj.transform([y,x],'EPSG:4326','EPSG:3857');
		 var view = map.getView();
	     view.setCenter (markerCoordinate);
	     view.setZoom(17);
  	

	}
	
	//서울전체지역확대 
	function zoom(){ 
		 var markerCoordinate = ol.proj.transform([127.039361,37.551226],'EPSG:4326','EPSG:3857');
		 var view = map.getView();
	     view.setCenter (markerCoordinate);
	     view.setZoom(12);
		
	}
	//구별확대 x y값 받아서 확대
	function zoom2(x,y){ 
		 var markerCoordinate = ol.proj.transform([y,x],'EPSG:4326','EPSG:3857');
		 var view = map.getView();
	     view.setCenter (markerCoordinate);
	     view.setZoom(14);
		
	}
/**
 * 좌측 GNB 메뉴를 선택했을 때의 처리
 * @param gnbid
 */
function gnbMenuSelect(gnbid) {
    $(".leftContents.contents1").hide();
    $(".leftContents.contents2").hide();
    $(".leftContents.contents3").hide();
    $(".leftContents.contents4").hide();
    $(".leftContents.contents5").hide();

    $("li.icon1").removeClass("selected");
    $("li.icon2").removeClass("selected");
    $("li.icon3").removeClass("selected");
    $("li.icon4").removeClass("selected");
    $("li.icon5").removeClass("selected");
    switch (gnbid) {
        case 1:
            $(".leftContents.contents1").show();
            $("li.icon1").addClass("selected");
            zoom(); 
            break;
        case 2:
            $(".leftContents.contents2").show();
            $("li.icon2").addClass("selected");
            zoom();
            break;
        case 3:
            $(".leftContents.contents3").show();
            $("li.icon3").addClass("selected");
            break;
        case 4:
            $(".leftContents.contents4").show();
            $("li.icon4").addClass("selected");
            break;
        case 5:
            $(".leftContents.contents5").show();
            $("li.icon5").addClass("selected");
            getLocation();
            break;
        default:
            $(".leftContents.contents1").show();
            $("li.icon1").addClass("selected");      
            break;
    }
}

$(document).ready(function(){
	gnbMenuSelect(1); //페이지 로드시 1번 표시	
});


/**
 테이블 펴고 접기
 */

$(document).ready(function(){
 
    $(".menu>a").click(function(){
        var submenu = $(this).next("ul");

        if( submenu.is(":visible") ){
            submenu.slideUp();
        }else{
            submenu.slideDown();
        }
    });
});






