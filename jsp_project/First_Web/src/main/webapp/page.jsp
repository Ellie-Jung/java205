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
	<%@ include file="include/header.jsp" %>
	<%-- include file="WEB-INF/header.jsp" 여기경로설정해도 된다.근데 여기있는파일은 외부에서보이지않는다.연결은가능.여기넣어놓고 파일 사용해도된다.외부에서바로연결은 불가능--%>
	<hr>
	<%@ include file="include/nav.jsp" %>
	<div id="wrap">
	<%@ include file="include/news.jsp" %>
	<hr>
	<%@ include file="include/shopping.jsp" %>
	</div>
	
	<!-- 실행된 jsp -> html(text)결과를 가져온다 -->
	<jsp:include page="footer.jsp">
		<jsp:param name="email" value ="test@gmail.com"/>
		<jsp:param name="tel" value="010-0000-0000"/>
	</jsp:include>
</body>
</html>