<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		String str= request.getParameter("id");
		String str1 = str.toUpperCase(); //널포인트 에러 발생
	
		/* String[] str={"a","b"};
		out.println(str[5]); */ //500 에러발생 
	%>

</body>
</html>