<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head >
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Blog</title>
    <!-- http://localhost:8080/First_Web/vlog/css/Myblog.css 절대경로넣어줌(포트뒤쪽으로오는경로) -->
    <link rel="stylesheet" href="First_Web/vlog/css/Myblog.css">
  
</head>
<body>
    
    <div id="main_wrap">

        <!-- header 시작 -->
        <%@ include file="include/header.jsp" %>
        <!--header 끝 -->


        <!-- navigation시작 -->
        <%@ include file="include/nav.jsp" %>
        <!-- navigation 끝 -->

        <!--컨텐츠 영역 시작 -->
        <div id="content_wrap">
           <%@ include file="include/section.jsp" %>
           <%@ include file="include/aside.jsp" %>
        </div>
        <!--컨텐츠 영역 끝 -->

        <!-- footer시작 -->
       <%@ include file="include/footer.jsp" %>
        <!-- footer끝 -->


    </div>

    
</body>
</html>