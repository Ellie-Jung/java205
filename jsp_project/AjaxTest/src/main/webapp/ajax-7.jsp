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
	
		$.ajax({
			url : 'data.xml',
			success : function (data){
				
				$(data).find('product').each(function(){
					//변수를 선언
					var pname = $(this).find('name').text();
					var price = $(this).find('price').text();
					var html = '<h3>이름 : '+pname+', 가격 :  '+price+'</h3>';
					$('body').append(html); //body에다 넣는다.
				});
			}
		});
		
		
	});
	

</script>
</head>
<body>
	
	
	
</body>
</html>