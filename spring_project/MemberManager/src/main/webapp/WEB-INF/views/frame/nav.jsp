<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Object loginObj = session.getAttribute("loginInfo");
	
%>
    
	<nav>
		<ul>
			<% if(loginObj == null) { %>
			<li><a href="<c:url value='/member/regform'/>">회원가입</a></li>
			<li><a href="<c:url value="/member/login"/>">로그인</a></li>
			<%}  else {%>
			<li><a href="<%= request.getContextPath() %>/logout.do">로그아웃</a></li>
			<li><a href="<%= request.getContextPath()%>/memberlist.do">회원리스트</a></li>
		<%-- 	<li><a href="<%= request.getContextPath()%>/deleteMember.do" onclick="if(!confirm('탈퇴 하시겠습니까?'))">회원탈퇴</a></li> --%>
			
			<%} %>
			<li><a href="<c:url value='/member/mypage'/>">MyPage</a></li>
		</ul>
	</nav>
	
