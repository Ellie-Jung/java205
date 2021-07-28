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
		
		$('#btn').click(function(){ //id=btn 클릭시 실행되는 함수
			$.ajax({
				url : 'parameter.jsp',
				type : 'post', //http method get, post, put, delete
				data : {
					pname : $('#pname').val(), //문자열 가져옴
					price : $('#price').val()
				},// 문자열 형식 ?name=test&price=1000,  아니면 객체{} 형식으로 정의
				success : function(data){
					//alert(data);
					$('#menu').append(data);
					
				}
			});
		});
		
		
		/* $.ajax({
			url : 'parameter.jsp',
			type : 'get', //http method get, post, put, delete
			data : {
				pname : '우유',
				price : 1000
			},// 문자열 형식 ?name=test&price=1000,  아니면 객체{} 형식으로 정의
			success : function(data){
				alert(data);
				$('body').html(data);
			}
		});
		 */
		 
	});
	

</script>
</head>
<body>
	
	<h1>제품 등록</h1>
	<hr>
	제품 이름 : <input type="text" id="pname"><br>
	제품 가격 : <input type="number" id="price"><br>
	<input id="btn" type="submit">
	<hr>
	<div id="menu">
		<h3>메뉴표</h3>
		<hr>
		
		
	</div>
	
	
	
</body>
</html>