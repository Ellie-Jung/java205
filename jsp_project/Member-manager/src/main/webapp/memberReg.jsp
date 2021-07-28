<%@page import="service.MemberRegService"%>
<%@page import="java.sql.SQLException"%>
<%@page import="util.ConnectionProvider"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int result=MemberRegService.getInstance().regMember(request);// 서비스에서 처리해주고 결과가지 저장해줄수있다. 
	//request.setAttribute("result", result);

%>
<%-- <jsp:useBean id="member" class="domain.Member" />
<jsp:setProperty property="*" name="member" /> 파일업로드에 멀티파트때문에 사용불가 --%>

<%-- <%
//	out.println(member);
	int result = 0;
//	Connection conn = null;
//	MemberDao dao = null;
/* 	try {
		conn = ConnectionProvider.getConnection();
		dao = MemberDao.getInstance();
		result = dao.insertMember(conn, member);
	} catch (SQLException e) {
		e.printStackTrace();
	} */
	//out.println(result);
	if (result > 0) {
%> --%>


<jsp:forward page="reg_view.jsp"/>

