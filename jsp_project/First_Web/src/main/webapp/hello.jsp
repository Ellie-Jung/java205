<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello JSP</title>
<style>
</style>
<script>
</script>
</head>
<body>
	<%
		String name = "SON";
	
	%>
	안녕하세요 <%= name %>
	<%= request.getContextPath() %> 
	<%--//request.getAttribute("test"); //내장객체 이런식으로 바로 사용가능함 --%>
</body>
</html>