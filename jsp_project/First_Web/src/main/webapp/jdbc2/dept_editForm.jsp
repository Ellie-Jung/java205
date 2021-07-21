<%@page import="java.sql.SQLException"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="dept.domain.Dept"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	// 사용자가 전달하는 부서번호 받기
	String deptno = request.getParameter("deptno");
	
	//전달 받은 부서번호로 부서정보를 가져온다. -> 처리 -> Dept -> 공유
	
	// 1.데이터베이스 드라이버 로드:서블릿클래스 Loader에서 드라이버 로드
	//Class.forName("com.mysql.cj.jdbc.Driver"); //mysql연결하기
	// 2. DB연결
	Connection conn = null; // 초기화. jsp코드는 서브릿의 메서드쪽으로들어감..
	DeptDao dao = null;
	
	
	try{
		conn = ConnectionProvider.getConnection();
		dao = DeptDao.getInstance();
		
		//부서 정보를 form_view.jsp로 전달(공유)한다.
		request.setAttribute("dept", dao.selectByDeptno(conn, Integer.parseInt(deptno)));
		
	}catch(SQLException e){
		e.printStackTrace();
	}
	
	
%>

<jsp:forward page = "form_view.jsp"/>














