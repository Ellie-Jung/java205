
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
</style>
<script>
	$(document).ready(function(){
		//alert("ready");
		$('#myform').submit(function(){ //폼에 액션이 없으면 자기자신으로 간다
			
			console.log($(this).serialize());
			console.log($(this).serializeArray());
			
			$.ajax({
				url : 'parameter.jsp',
				//data : $(this).serialize(),
				data : $(this).serializeArray(),
				success : function(data){
					$('#menu').append(data);
				}
			});
			
			
			return false; //액션으로 가는거 막아야하니깐 return false
		});
		
		
		
		
	});
</script>
</head>
<body>

	<h1>제품 등록</h1>
	<hr>
	<form id="myform">
		제품 이름 : <input type="text" id="pname" name="pname"> <br>
		제품 가격 : <input type="number" id="price" name="price"><br>
		<input id="btn" type="submit">
	</form>  
	<hr>
	<div id="menu">
		<h3>메뉴표</h3>
		<hr>
		
	</div>








</body>
</html>