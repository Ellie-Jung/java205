<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String pwchk = request.getParameter("pwchk");
    String name = request.getParameter("name");
    String yy = request.getParameter("yy");
    String mm = request.getParameter("mm");
    String dd = request.getParameter("dd");
    String gender = request.getParameter("gender");
    String email = request.getParameter("email");
    String countrycode = request.getParameter("countrycode");
    String phonenum = request.getParameter("phonenum");
   
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

	<h1>회원 정보</h1>
	<hr>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>
				<%=id %>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<%=pw %>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<%=name %>
			</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>
				<%=yy %>/<%=mm %>/<%=dd %>
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<%=gender %>
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<%=email %>
			</td>
		</tr>
		<tr>
			<td>휴대전화</td>
			<td>
				<%=name %>
			</td>
			
		</tr>
		
		
	
	</table>

</body>
</html>