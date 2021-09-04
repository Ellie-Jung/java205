<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>회원관리</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
  <link rel="stylesheet" href="<c:url value='/css/admin/admin.css'/>">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://kit.fontawesome.com/cccee664d4.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="/WEB-INF/frame/admin/header.jsp" %>


<div class="container">
  <h2>회원관리</h2>
  <p>Type something in the input field to search the table for first names, last names or emails:</p>  
  <input class="form-control" id="myInput" type="text" placeholder="Search..">
  <br>
  <table class="table table-bordered table-striped">
    <thead>
      <tr>
        <th>선택</th>
        <th>IDX</th>
        <th>아이디</th>
        <th>이름</th>
        <th>Email</th>
        <th>프로필사진</th>
        <th>닉네임</th>
        <th>가입일</th>
        <th>생일</th>
        <th>관리</th>
      </tr>
    </thead>
    <tbody id="myTable">
    <c:forEach items="${memberList}" var="list">
      <tr>
      	<td><input type="checkbox" name="select"></td>
        <td>${list.memberIdx}</td>
        <td>${list.memberId}</td>
        <td>${list.memberName}</td>
        <td>${list.memberEmail}</td>
        <td>${list.memberProfile}</td>
        <td>${list.memberNickname}</td>
        <td>${list.memberRegdate}</td>
        <td>${list.memberBirth}</td>
        <td>
            <a href="#">수정</a>
            <a href="#">삭제</a>
        </td>
      </tr>
      </c:forEach>
    
    </tbody>
  </table>
  
  <p>Note that we start the search in tbody, to prevent filtering the table headers.</p>
  
  
  

 <!--페이징-->
        <div class="delete pull-right">
       		<input class="btn btn-default" type="submit" value="일괄삭제">
        </div>
        <div class="pres">
            <h4 class="hidden">현재 페이지</h4>
            <div><span>1</span> / 1 pages</div>
        </div>


      <div class="text-center">
      <nav aria-label="Page navigation example">
		  <ul class="pagination  justify-content-center">
		    <li class="page-item disabled">
		      <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
		    </li>
		    <li class="page-item"><a class="page-link" href="#">1</a></li>
		    <li class="page-item"><a class="page-link" href="#">2</a></li>
		    <li class="page-item"><a class="page-link" href="#">3</a></li>
		    <li class="page-item">
		      <a class="page-link" href="#">Next</a>
		    </li>
		  </ul>
	</nav>
     </div>   
</div>





<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>

</body>
</html>