<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
	<h1>회원가입</h1>
	<hr> 
			<table>
				<tr>
					<td>아이디</td>
					<td>${regReq.memberid}</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>${regReq.password}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${regReq.membername}</td>
				</tr>
				<tr>
					<td>사진</td>
					<td>${regReq.photo}</td>
				</tr>
			</table>
	
</body>
</html>