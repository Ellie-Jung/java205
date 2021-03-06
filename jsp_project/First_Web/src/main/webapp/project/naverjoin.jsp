<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>naver Join</title>
    <link rel="stylesheet" href="naverjoin.css">
</head>
<body>
    <div id="main_wrap">
        <!-- 헤더시작 -->
        <header>
            <h1>
                <img src="../images/01 NAVER Logo_Green.png" alt="naverLogo" width="240px">
            </h1>
        </header>
        <!-- 헤더끝 -->

        <!-- 폼시작 -->
        <form action="join_result.jsp" method="post">
                <div id="id" class="div_margin">
                    <div id="id2">
                        <h3>아이디</h3>
                        <input type="text" name="id" >
                        <span class="emailset">@naver.com</span>

                    <div>
                </div>
                <div class="div_margin">
                    <h3>비밀번호</h3>
                    <input type="password" name="pw">
                </div>
                <div class="div_margin">
                    <h3>비밀번호 재확인</h3>
                    <input type="password" name="pwchk">
                </div>
                <div class="div_margin">
                    <h3>이름</h3>
                    <input type="text" name="name">
                </div>
                <div id="birthday" class="div_margin">
                    <h3>생년월일</h3>
                    <div>
                        <input type="text" name="yy" placeholder="년(4자)" >
                        <select name="mm" >
                            <option value>월</option>
                            <option value="01">1</option>
                            <option value="02">2</option>
                            <option value="03">3</option>
                            <option value="04">4</option>
                            <option value="05">5</option>
                            <option value="06">6</option>
                            <option value="07">7</option>
                            <option value="08">8</option>
                            <option value="09">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>
                        <input type="text" name="dd" placeholder="일" >
                    </div>
                </div>
                <div id="sex" class="div_margin">
                    <h3>성별</h3>
                    <select class="selectbox_set" name="gender">
                        <option>성별</option>
                        <option value="남자">남자</option>
                        <option value="여자">여자</option>
                        <option value="선택안함">선택 안함</option>
                    </select> 
                </div>
                <div id="email" class="div_margin">
                    <h3>본인 확인 이메일</h3>
                    <span>(선택)</span>
                    <input type="text" name="email" placeholder="선택입력">
                </div>
                <div id="phonenumber" class="div_margin">
                    <h3>휴대전화</h3>
                    <select class="selectbox_set" name="countrycode">
                        <option>대한민국 +82</option>
                        <option>미국/캐나다 +1</option>
                    </select>
                        <input id="phon1" type="text" name="phonenum" placeholder="전화번호 입력">
                        <input type="button" value="인증번호 받기">
                    <input type="text" placeholder="인증번호 입력하세요">
                </div>
                <div id="joinbtn" class="div_margin">
                    <input type="submit" value="가입하기">
                </div>
        </form>
        <!-- 폼끝 -->

        <!-- 푸터시작 -->
        <footer>
            <ul>
                <li class="border_right"><a href="#">이용약관</a></li>
                <li class="border_right"><a href="#"><b>개인정보처리방침</b></a></li>
                <li class="border_right"><a href="#">책임의 한계와 법적 고지</a></li>
                <li><a href="#">회원정보 고객센터</a></li>
            </ul>
            <div class="div_margin">
                <img src="../images/01 NAVER Logo_Green.png" alt="naverLogo" width="80px">
                Copyright <b>NAVER Corp.</b> All Rights Reserved.
            </div>
        </footer>
        <!-- 푸터끝 -->
    </div>
</body>
</html>