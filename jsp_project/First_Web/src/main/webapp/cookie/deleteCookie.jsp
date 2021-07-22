<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//쿠키의 삭제 : 쿠키 유지시간을 0으로 설정
	//Cookie cookie = new Cookie("cname", "");
	//cookie.setMaxAge(60*60*24*7); // 60초 * 60분 *24시간 * 7일 하면 그동안 쿠키 유지
	//cookie.setMaxAge(0); //쿠키가 바로 소멸 -> (삭제된다.)
	//response.addCookie(cookie);

	
	response.addCookie(CookieBox.makeCookie("name", "","/web/cookie",0));
%>
    
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

	<h1> 쿠키가 삭제되었습니다.</h1>
	<a href="viewCookie.jsp">쿠키 보기</a>
	
</body>
</html>