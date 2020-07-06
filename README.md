# 아동급식카드(서울시 꿈나무카드) 가맹점 위치확인 지도

### 개요
1) 아동급식카드을 사용하기위해 가입된 가맹점을 찾기 힘듦
2) 기존 대형 편의점 같은 경우 카드사용 가능-> data제외  
3) 일반음식점은 아동급식카드를 사용하기위한 단말기설치를 해야함 -> 가입한 가맹점을 찾기힘듦
4) 편의점에 집중된 식단개선을 위해 웹페이지 제작



### 사용 DB: postgresql
지리정보를 위해 사용







### 사용 data : 공공데이터포털 가입된 가맹점 정보
(편의점 제외 총 1857개)csv파일 ->   Qgis이용 shp파일 생성 -> postgresql import




### 사용한 open api
geoserver, openlayers3






### 테이블설계
![image](https://user-images.githubusercontent.com/64793712/86595411-a70eef80-bfd3-11ea-969a-84f24435f112.png)





