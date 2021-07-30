<%@page import="java.sql.SQLException"%>
<%@page import="util.ConnectionProvider"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="domain.Member"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	alert('아이디 또는 비밀번호가 일치하지 않습니다.');
	history.go(-1);
</script>	

