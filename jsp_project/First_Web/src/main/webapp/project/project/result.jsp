<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%
    request.setCharacterEncoding("utf-8");
    
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String name = request.getParameter("name");
   
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
	<h1>회원 정보</h1>
	<hr>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>
				<%=id %>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<%=pw %>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<%=name %>
			</td>
		</tr>
	</table>
</body>
</html>