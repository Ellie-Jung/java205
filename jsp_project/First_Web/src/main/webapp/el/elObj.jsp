<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	
	request.setAttribute("name", "손흥민");
	session.setAttribute("name", "이강인");
	application.setAttribute("name", "메시");
	
	Member member = new Member();
	member.setId("cool");
	member.setName("COOL");
	member.setPw("1234");
	session.setAttribute("member", member);
	
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
	
	표현식 : <span><%= request.getAttribute("name") %></span><br>
	
	표현언어 1 :<span>${requestScope.name}</span> <br><br>
	
	내장 객체의 표현식이 생력되었을때 규칙 <br>
	1. pageScope 의 속성을 찾는다 -> 2. requestScope의 속성 찾는다 -> 3. sessionScope -> 4. applicationScope 
	<br><br>
	표현언어 2 :<span>${name}</span> <br><br>
	<!-- 위의 두개 다 손흥민 출력. -->
	표현언어 3 :<span>${sessionScope.name}</span><br><br> 
	표현언어 4 :<span>${applicationScope.name}</span><br> 
	
	<hr>
	param.code : <%= request.getParameter("code") %><br>
	param.code : ${param.code}
	
	
	<hr>
	pageContext : <%= pageContext.getRequest().getServletContext().getContextPath() %>
	<br>
	${pageContext.request.requestURL}<br>
	${pageContext.request.requestURI}<br>
	${pageContext.request.contextPath}<br>
	<%= request.getContextPath() %>
	
	<br><hr>
	${true} / ${false} / ${100} / ${'손흥민'} / ${null }
	
	<br><hr>
	
					<!-- member.getId() 호출해야할때 -->
	${member} / 		${member.id}
	<br> 
	<%= member %><br>
	<%= session.getAttribute("member")%>  /  <%= ((Member) session.getAttribute("member")).getId() %>
	<br>
	
	
	
	
	
	
	
</body>
</html>