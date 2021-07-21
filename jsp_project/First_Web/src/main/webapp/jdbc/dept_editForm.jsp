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
	//out.println(deptno);
	
	
	//전달 받은 부서번호로 부서정보를 가져온다.
	// 1.데이터베이스 드라이버 로드:서블릿클래스 Loader에서 드라이버 로드
	//Class.forName("com.mysql.cj.jdbc.Driver"); //mysql연결하기
	// 2. DB연결
	Connection conn = null; // 초기화. jsp코드는 서브릿의 메서드쪽으로들어감..
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	
	
	conn = ConnectionProvider.getConnection();
	
	Dept dept = null;
	
	
	String sqlSelect = "select*from dept where deptno=?";
	pstmt = conn.prepareStatement(sqlSelect);
	pstmt.setInt(1, Integer.parseInt(deptno));
	
	rs = pstmt.executeQuery(); 
	
	//반복할 필요 없음. 컬럼이 pk이기때문에 결과가 1또는 0이나온다. 
	if(rs.next()){ //참일때 객체가 만들어진다. (rs.next가 있으면)
		dept = new Dept();
		dept.setDeptno(rs.getInt("deptno"));
		dept.setDname(rs.getString("dname"));
		dept.setLoc(rs.getString("loc"));
	}
	
	out.println(dept); //확인
	
	
	
	
	
	//부서 정보를 form_view.jsp로 전달(공유)한다.
	request.setAttribute("dept", dept);


%>

<jsp:forward page = "form_view.jsp"/>














