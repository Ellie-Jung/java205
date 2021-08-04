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
	
	<h1>Login Request Data</h1>
	<hr>
		<table>
			<tr>
				<td>아이디</td>
				<%-- <td>${id}, ${uid}, ${loginRequest.id}</td> --%><!-- 파라미터데이터 모델에담아, 리쿼스트에 담은데이터. 사용자가 가져온데이터를 코맨드 객체타입으로바을떄 LoginRequest객체에 getId -->
				<td>${id}, ${uid}, ${loginReq.id}</td><!-- 파라미터데이터 모델에담아, 리쿼스트에 담은데이터. 사용자가 가져온데이터를 코맨드 객체타입으로바을떄 LoginRequest객체에 getId  d이름을 지정해줫을떄-->
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>${pw}, ${upw}, ${loginReq.pw}</td>
			</tr>
		</table>
</body>
</html>