<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>
<body>
	
	<%
		request.setAttribute("now", new java.util.Date());
	%>
	
	${now}<br>
	
	<%-- <fmt:timeZone value="HongKong">  전체 시간을 홍콩으로 바꿔줄수도 있다.--%>
	
	<h3>날짜</h3>
	<fmt:formatDate value="${now}"/><br>
	<fmt:formatDate value="${now}" type="date"/><br>
	<fmt:formatDate value="${now}" type="date" dateStyle="full"/><br>
	<fmt:formatDate value="${now}" type="date" dateStyle="short"/><br>
	
	<h3>시간</h3>
	<fmt:formatDate value="${now}" type="time"/><br>
	<fmt:formatDate value="${now}" type="time" timeStyle="full"/><br>
	<fmt:formatDate value="${now}" type="time" timeStyle="short"/><br>
	
	<h3>both</h3>
	<fmt:formatDate value="${now}" type="both"/><br>
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br>
	<fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short"/><br>
	
	
	
	
	<h3>패턴</h3>
	<fmt:formatDate value="${now}" pattern="z a h:mm"/><br> <!-- z는타임존 a는 오전오후 h시간 m분 -->
	<fmt:formatDate value="${now}" pattern="hh:mm:ss"/><br> <!-- 분표현은 소문자mm 월 표현은 대문자MM -->
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd h:mm"/><br>
	<fmt:formatDate value="${now}" pattern="yyyy.MM.dd. a h:mm"/><br>
	<fmt:formatDate value="${now}" pattern="yyyy.MM.dd. a h:mm" timeZone="HongKong"/><br>


	
	
	<%-- </fmt:timeZone> --%>
	
	
	
	
	
	
		
</body>
</html>