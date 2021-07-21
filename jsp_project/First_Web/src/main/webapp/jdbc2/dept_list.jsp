<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//사용자의 요청이 들어오면 dao 요청하고 요청 결과를 속성에다 정의해주는 역할. 뷰를 지정해주는 역할. (컨트롤러의 역할을 한다)//

	//dept_list.jsp -> 요청을 받고 처리. (나중에는 요청받고 처리하는걸 분리.) => 결과 데이터를 객체 속성에 저장 (공유하기위한 목적) => view 지정

	// 1.데이터베이스 드라이버 로드:서블릿클래스 Loader에서 드라이버 로드
	//Class.forName("com.mysql.cj.jdbc.Driver"); //mysql연결하기
	
	// 2. DB연결
	Connection conn = null; // 초기화. jsp코드는 서브릿의 메서드쪽으로들어감..
	DeptDao dao = DeptDao.getInstance(); //인스턴스 바로 생성못함. (싱글톤처리) 요롷게 가져온다. 
	
	try{
		
	//jdbcUrl
	conn=ConnectionProvider.getConnection();
		
	// 6. 결과 데이터를 request의 속성에 저장. -> 데이터를 공유(전달) 
	request.setAttribute("result", dao.getDeptList(conn));
	
	}catch(SQLException e){
		e.printStackTrace();
	
	}catch(Exception e){ //6번에서(dao.getDeptList(conn)) 널포인트 뜰수도 있기때문에 예외처리 해준다.
		e.printStackTrace();
		
	}finally{
		JdbcUtil.close(conn);
		
	}
	
	
	
%>

<jsp:forward page = "list_view.jsp"/> <!-- list_view.jsp : view의 역할만 한다!!! -->