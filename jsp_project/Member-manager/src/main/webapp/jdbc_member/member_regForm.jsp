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
	<h1>멤버 정보 등록</h1>
	<hr>
	
	<form action="regMember.jsp" method="post">
	
		<table>
			
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" required></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pw" required></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" required></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="등록">
				</td>
			</tr>
		</table>
	
	</form>
	
</body>
</html>