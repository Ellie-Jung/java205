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
	
		$.getJSON('data.json',function(data){
			$.each(data, function(index, value){ //배열을 받기위해 .. 배열의 인덱스와 밸류 가졍ㅇ옴
				var html= '<h3>이름 : '+value.name+' , 가격 : '+value.price+'</h3>';
				$('body').append(html);//파싱 -> 다른형식의 데이터를 또다른 형식의 데이터로 만들어서 처리 (json형식의 데이터를받아서 html로 처리해줌. )
			});
		});
		
		
	});
	

</script>
</head>
<body>
	
	
	
	
</body>
</html>