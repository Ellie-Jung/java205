<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 쿠키 : 문자열 데이터를 사용자의 브라우저에 저장
	//쿠키 생성 -> response.add(c);
	//Cookie 클래스 이용
	Cookie cookie = new Cookie("cname","test");
	//쿠키를 브라우저로 전달 (응답) : 쿠키 굽는다!! 
	//response.addCookie(cookie); // 앞에서 만든 쿠키객체로 쿠키를 생성
	response.addCookie(CookieBox.makeCookie("name", "손흥민", "/",5));
//	response.addCookie(new Cookie("number", "7"));
	response.addCookie(CookieBox.makeCookie("number1", "7" ));
	
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

	<h1>쿠키 저장</h1>
	
	<a href="viewCookie.jsp">쿠키 보기</a>
	


</body>
</html>