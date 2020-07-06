# 아동급식카드(서울시 꿈나무카드) 가맹점 위치확인 지도

### 개요
1) 아동급식카드을 사용하기위해 가입된 가맹점을 찾기 힘듦
2) 기존 대형 편의점 같은 경우 카드사용 가능-> data제외  
3) 일반음식점은 아동급식카드를 사용하기위한 단말기설치를 해야함 -> 가입한 가맹점을 찾기힘듦
4) 편의점에 집중된 식단개선을 위해 웹페이지 제작


### 주요 기능
1) 구별 가맹점 확인
2) 음식별 가맹점 확인
3) 검색기능
4) 내위치 확인
5) 가맹점 기본정보 확인(주소,전화번호,이름,음식점종류,데이터갱신일)
6) 가맹점 위치 로드뷰 

### 홈페이지
![image](https://user-images.githubusercontent.com/64793712/86597566-e0952a00-bfd6-11ea-9127-6cae4e94a4e2.png)
![image](https://user-images.githubusercontent.com/64793712/86597698-091d2400-bfd7-11ea-924a-0decd8fb19d2.png)
![image](https://user-images.githubusercontent.com/64793712/86597777-29e57980-bfd7-11ea-8a6b-8b7c7c3077dd.png)
![image](https://user-images.githubusercontent.com/64793712/86597871-4aadcf00-bfd7-11ea-99eb-5959104fe7b4.png)

### 사용 DB: postgresql
지리정보를 위해 사용







### 사용 data : 공공데이터포털 가입된 가맹점 정보
(편의점 제외 총 1857개)csv파일 ->   Qgis이용 (포인트 기본 좌표설정) shp파일 생성 -> postgresql import
->geoserver 와 postgresql 연동




### 사용한 open api
geoserver, openlayers3, Kakao 로드뷰 API






### 테이블설계
![image](https://user-images.githubusercontent.com/64793712/86595411-a70eef80-bfd3-11ea-969a-84f24435f112.png)


### 포인트별 심볼설정
geoserver SLD 이용 tbl_coor 에  있는 테마별 분류 해당 테마에 맞는 심볼 이미지 추가. 





