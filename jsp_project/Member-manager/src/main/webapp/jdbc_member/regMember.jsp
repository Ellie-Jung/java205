<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="member.dto.Member"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");	
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	//Timestamp joinDate = new Timestamp(new Date().getTime());
			
	int resultCnt =0;

	Connection conn = null;
	MemberDao dao = MemberDao.getInstance();
	
	try{
		
		conn = ConnectionProvider.getConnection();
	//	resultCnt = dao.insertMember(conn, new Member(0, id, pw, name,joinDate));
		resultCnt = dao.insertMember(conn, new Member(id, pw, name));
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
	if(resultCnt>0){
		%>
		<script>
			alert('등록되었습니다.');
			location.href = 'member_list.jsp';
		</script>
		<%
	}else{
		%>
		<script>
			alert('오류 발생으로 등록되지 않았습니다.\n 입력페이지로 돌아갑니다.');
			window.history.go(-1); //바로 이전 페이지로 돌아가기(사용자가 입력한 값 그대로 나옴)
		</script>
		<%
	}	
	

%>