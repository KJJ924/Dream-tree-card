<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>꿈나무 카드 가맹점 위치 공간정보시스템</title>
<link rel="stylesheet" href="css/ol.campsite.css"> 
<link rel="stylesheet" href="css/campsite_main.css">

<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/ol-debug.js"></script>

<script>

//geolocation 위도경도값 저장
$(function() {        
	

	
    // Geolocation API에 액세스할 수 있는지를 확인
    if (navigator.geolocation) {
        //위치 정보를 얻기
        navigator.geolocation.getCurrentPosition (function(pos) {
        	
            $('#latitude').html(pos.coords.latitude);     // 위도
            $('#longitude').html(pos.coords.longitude); // 경도
         
        });
    } else {
        alert("이 브라우저에서는 Geolocation이 지원되지 않습니다.")
    }
});

</script>
</head>

<body>

	<div class="warp">
		<div id="header">
			<div class="topDecal"></div>
			<a href="DreamTree.do"><div id="campsiteLogo"></div></a>
		</div>
		<div id ="nav">
				<div class="gnb">
					<ul>
					<a href="DreamTree.do"><li class="gnbicon icon1" onclick="gnbMenuSelect(1)"><span>가맹점위치</span></li></a>
					<li class="gnbicon icon2" onclick="gnbMenuSelect(2)"><span>구별</span></li>
					<li class="gnbicon icon3" onclick="gnbMenuSelect(3)"><span>음식별</span></li>
				    <li class="gnbicon icon4" onclick="gnbMenuSelect(4)"><span>검색</span></li>
					<li class="gnbicon icon5" onclick="gnbMenuSelect(5)"><span>내 위치</span></li>
					</ul>
					
				</div>
		</div>
		<div id="contents">
			<div id="left">	
				<div class="leftContents contents1">
					<h3>가맹점 지도</h3>
					<p>상단의 메뉴에서 구별/음식별 검색을 하실 수 있습니다.</p>
				</div>
				<div class="leftContents contents2">
					<h3>구별 검색</h3>
					<p>구별 검색을 하실 수 있습니다.</p>
					<div>
						<ul>
							<li class="menu">
					 			<a><img src="images/펼쳐보기.PNG" alt="펼처보기"/></a>
									<ul class="campsiteList">
										<li onclick="selectRegion('강남구');">강남구</li>
										<li onclick="selectRegion('강동구');">강동구</li>
										<li onclick="selectRegion('강북구');">강북구</li>
										<li onclick="selectRegion('관악구');">관악구</li>
										<li onclick="selectRegion('광진구');">광진구</li>
										<li onclick="selectRegion('구로구');">구로구</li>
										<li onclick="selectRegion('금천구');">금천구</li>
										<li onclick="selectRegion('노원구');">노원구</li>
										<li onclick="selectRegion('도봉구');">도봉구</li>
										<li onclick="selectRegion('동대문구');">동대문구</li>
										<li onclick="selectRegion('동작구');">동작구</li>
										<li onclick="selectRegion('마포구');">마포구</li>
										<li onclick="selectRegion('서초구');">서초구</li>
										<li onclick="selectRegion('성동구');">성동구</li>
										<li onclick="selectRegion('성북구');">성북구</li>
										<li onclick="selectRegion('송파구');">송파구</li>
										<li onclick="selectRegion('양천구');">양천구</li>
										<li onclick="selectRegion('영등포구');">영등포구</li>
										<li onclick="selectRegion('용산구');">용산구</li>
										<li onclick="selectRegion('은평구');">은평구</li>
										<li onclick="selectRegion('종로구');">종로구</li>
										<li onclick="selectRegion('중구');">중구</li>
										<li onclick="selectRegion('중량구');">중량구</li>
									</ul>		
							</li>
						</ul>
					</div>
				</div>
				<div class="leftContents contents3">
					<h3>음식별 검색</h3>
					<p>음식별 검색을 하실 수 있습니다.</p>
					<div>
					<ul>
						<li class="menu">
						<a><img src="images/펼쳐보기.PNG" alt="펼처보기"/></a>
						<ul class="campsiteList2">
							<li onclick="selectTheme('도시락');">도시락</li>
							<li onclick="selectTheme('디저트');">디저트</li>
							<li onclick="selectTheme('마트');">마트</li>
							<li onclick="selectTheme('분식점');">분식점</li>
							<li onclick="selectTheme('양식당');">양식당</li>
							<li onclick="selectTheme('일반음식점');">일반음식점</li>
							<li onclick="selectTheme('일식당');">일식당</li>
							<li onclick="selectTheme('제과점');">제과점</li>
							<li onclick="selectTheme('중식당');">중식당</li>
							<li onclick="selectTheme('패스트푸드');">패스트푸드</li>
							<li onclick="selectTheme('한식당');">한식당</li>
						</ul>
						</li>
					</ul>	
					</div>
				</div>
			
				<div class="leftContents contents4">
					<h3>검색</h3>
					<p>지점 명을 검색하실 수 있습니다.</p>
					<p>띄어쓰기 없이 입력해주세요</p>
					 <input class ="form-control" id="searchtitle"  type="text" size="20">
					 <button class ="btn btn primary" onclick="SearchSubmit();" type="button">검색</button>
					 
				</div>
			
	
				<div class="leftContents contents5">
					<h3>지금 나의  위치는 </h3>  
				 
				<b>위도:<span id="latitude"></span>
				<b>경도:<span id="longitude"></span>
				</div>
		    </div>
		</div><!-- //contents -->
		
			<div id="mapArea">
				<div id="map"></div>
			</div>
		<div id="footer">
			<span class="copyright">Copyright &copy; 2020 가맹점위치</span>
		</div><!-- //footer -->
		</div><!-- //wrap -->
	<div id="FeatureInfo">
		<h3>-</h3>
		<div class="btnClose"></div>
		<hr>
		<table>		
			<tr>
				<th>전화번호</th>
				<td class="phone"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td class="address"></td>
			</tr>
		
			<tr>
				<th>테마</th>
				<td class="themes"></td>
			</tr>
		
		</table>
	</div>
<script src="js/campsite.map.js"></script>
<script src="js/campsite.ui.js"></script>
</body>
</html>