<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- <script type="text/javascript">
var confirm = confirm('정말 탈퇴하시겠습니까?');

if(confirm){
	
}else{
	
}
</script> -->

<c:if test="${result==1}">
	<script>
		alert('탈퇴되었습니다.'');
		location.href='<c:url value="/index.jsp"/>';
	</script>
</c:if>
<c:if test="${result==0}">
	<script>
		alert('오류 발생으로 탈퇴되지 않았습니다.');
		window.history.go(-1);
	</script>
</c:if>