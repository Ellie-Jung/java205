<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>naverlogin</title>
    <link rel="stylesheet" href="naverlogin.css">
</head>
<body>
    <div id="main_wrap">
        <!-- 헤더시작 -->
        <header>
            <img src="../images/01 NAVER Logo_Green.png" alt="naverLogo" width="200px">
        </header>
        <!-- 헤더끝 -->
        <!-- 컨테이너시직 -->
        <container>
        <form action="login_result.jsp" method="post">
         <div>
                <input type="text" name="id" placeholder="아이디">
                <input type="password" name="pw" placeholder="비밀번호">
                <input class="login" type="submit" value="로그인" >
            </div>
        </form>
           
        </container>
       <!-- 컨테이너끝 -->
    </div>
</body>
</html>