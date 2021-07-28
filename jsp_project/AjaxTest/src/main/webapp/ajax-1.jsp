<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
</style>
<script>
	
	$(document).ready(function(){
		//alert("ready"); 확인
		
		
		$.ajax('data.html',{
			success: function(data){ //data.html 파일이 정상적으로 실행되었을때 함수 실행
				$('body').append(data); // append(텍스트) : 선택한 요소의 내용의 끝에 새로운 컨텐츠 추가(컨텐츠를 선택된 요소 내부의 끝 부분에서 삽입)
			}
		});
		
		
		
	});
	

</script>
</head>
<body>
	ajax-1.jsp
</body>
</html>