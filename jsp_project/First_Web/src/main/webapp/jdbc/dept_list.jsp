<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="dept.domain.Dept"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//dept_list.jsp -> 요청을 받고 처리. (나중에는 요청받고 처리하는걸 분리.)

	// 1.드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver"); //mysql연결하기
	// 2. DB연결
	Connection conn = null; // 초기화. jsp코드는 서브릿의 메서드쪽으로들어감..
	Statement stmt=null;
	ResultSet rs = null;
	
	//예외처리를 여기서 해주어야한다.
	//jdbcUrl
	conn=ConnectionProvider.getConnection();
	
	// 3. Statement 객체 만들기
	stmt = conn.createStatement();
	
	//sql
	String sqlSelect = "select * from dept";
	
	
	// 4. ResultSet
	rs= stmt.executeQuery(sqlSelect);
	
	// 5. List<Dept>   <- 결과 
	List<Dept> deptList = new ArrayList<Dept>();
	
	
	while(rs.next()){
		//List에 객체 추가
		deptList.add(new Dept(rs.getInt("deptno"), rs.getString("dname"),rs.getString("loc")));
		
	}
	
	out.println(deptList);
	
	
	// 6. 결과 데이터를 request의 속성에 저장. -> 데이터를 공유(전달) 
	request.setAttribute("result", deptList);
	
%>

<jsp:forward page = "list_view.jsp"/> <!-- view의 역할만 한다!!! -->