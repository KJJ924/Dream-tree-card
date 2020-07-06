<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:if test="${info.name != null}">
<h3>${info.name}</h3>
		<div class="btnClose" onclick="FeatureInfoWndClose();"></div>
		<hr>
		<table>
			<tr>
				<th>주소</th>
				<td class="address">${info.address}</td>
			</tr>
			<tr>
			<tr>
				<th>전화번호</th>
				<td class="phone">${info.phone}</td>
			</tr>
		
		    <tr>
				<th>음식점종류</th>
				<td class="theme">${info.theme}</td>
			</tr>
			  <tr>
				<th>데이터 갱신일</th>
				<td class="data">${info.data}</td>
			</tr>
			<tr>
			    <th>로드뷰:</th>
			    <td><a href="#" 
			    	   onclick="window.open(
			    		'http://localhost:8080/ggnamucard/WEB-INF/NewFile.html',
			    		'_blank', 'width=800 height=400')"> 바로가기 </a>

			</tr>
		</table>
	</c:if>