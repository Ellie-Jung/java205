<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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

	<h3>
	
	<c:url value="index.jsp" var="urlIndex" />  <!-- 상대경로 -->
	<c:url value="/index.jsp" var="urlIndex" /> <!-- 절대경로 -->
	${urlIndex}
	<br>	
	<c:url value="index.jsp"  /> <!-- 상대경로, 변수 속성 없으면 그대로 출력된다. -->
	<br>
	<a href="<c:url value="/index.jsp"  />">홈으로 가기</a>
	
	<br>
	
	<c:url value="/index.jsp" var="homeUrl">
		<c:param name ="type">main</c:param>
	<%-- 	<c:param name ="type" value="main"/>  위에꺼랑 이거랑 똑같다. --%>
		<c:param name ="index">1</c:param>
	</c:url> 

	<a href="${homeUrl}">
		${homeUrl}
	</a>
	
	
	
	</h3>



</body>
</html>