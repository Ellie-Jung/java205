<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원관리 프로그램</title>
    <link rel="stylesheet" href = "default.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
    <script src = "manager.js"></script>


</head>

<body>
    
    <!-- 헤더 시작 -->
    <header>
        <h1 class="title_font">Member Manager</h1>
    </header>
    <!-- 헤더 끝 -->

<!-- 회원 등록 폼 시작 -->
    <div id="regFormArea">
        <h2 class="title_font">회원 정보 등록</h2>
        <form id="regForm" action="result.jsp" method="post">
        <table>
            <tr>
                <td>
                    <label for="userID">아이디</label> <!--아이디글씨 누르면 박스에 포커씽, for pw하게되면 아이디 눌렀을때 비번칸에 포커싱된다.-->
                    <input type="text" id="userID" name="id" placeholder="아이디를 입력해주세요." >
                    <div class="msg"></div>
                </td>
                <td>
                    <label for="pw">비밀번호</label>
                    <input type="password" id="pw" name="pw" placeholder="비밀번호를 입력해주세요.">
                    <div class="msg"></div>
                </td>
                <td>
                    <label for="repw">비밀번호확인</label>
                    <input type="password" id="repw" placeholder="다시한번 입력해주세요.">
                    <div class="msg"></div>
                </td>
                <td>
                    <label for="userName">이름</label>
                    <input type="text" id="userName" name="name" placeholder="이름을 입력해주세요.">
                    <div class="msg"></div>
                </td>
                <td>
                    <input type="submit" value="등록">
                </td>
            </tr>
        </table>
    </form>
    </div>
    <!-- 회원 등록폼 끝 -->

    <!-- 회원리스트 시작 -->
    <div id="listArea">
        <h2  class="title_font">회원 리스트</h2>
        <table>
            <tbody id="list">
            <tr>
                <th>순번(index)</th>
                <th>아이디</th>
                <th>비밀번호</th>
                <th>이름</th>
                <th>관리</th>
            </tr>
        </tbody>

        </table>
    </div>
    <!-- 회원 리스트 끝 -->

    <!-- 회원정보 수정 시작 -->
    <div id="editFormArea">
        
        <div id="div_header">
            <h2 class="title_font">회원 정보 수정</h2>
            <div><a href="javascript:editMemberClose()">닫기</a></div>
        </div>

        <form id="editForm">

            <table>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" id="editId" disabled>
                        <input type="hidden" id="index">
                    </td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" id="editPw" required></td>
                </tr>
                <tr>
                    <td>비밀번호확인</td>
                    <td><input type="password" id="editRePw" required></td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td><input type="text" id="editName" required></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="수정">
                    </td>
                </tr>
            </table>

        </form>

    </div>

</body>
</html>