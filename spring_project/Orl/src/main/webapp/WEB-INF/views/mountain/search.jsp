<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>검색결과보기</title>
    <link rel="stylesheet" href="<c:url value='/css/mountain/search.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
    
</head>



<body>
     <%@ include file="/WEB-INF/frame/default/header.jsp"%>

    <div id="container">
        <div id="contents">
            <div class="titleArea">
                <h2>SEARCH</h2>
            </div>

            <div class="boxContainer">
                <table class="elementsContainer">
                    <tr>
                        <td>
                            <input type="text" placeholder="검색하실 내용을 입력해주세요. " class="search">
                        </td>
                        <td>
                             <a href="#">
                              <i class="fas fa-search"></i>
                              </a>
                        </td>
                    </tr>
                </table>
            </div>
            <div id="selectList">
                <div class="item">
                    <a><img class="img" src="/images/mountain/tj-k-4m9j8TrudRs-unsplash.jpg" ></a>
                    <span>북한산</span>
                </div>
                <div class="item">
                    <a><img class="img" src="/images/mountain/tj-k-4m9j8TrudRs-unsplash.jpg" ></a>
                    <span>북한산</span>
                </div>
                <div class="item">
                    <a><img class="img" src="/images/mountain/tj-k-4m9j8TrudRs-unsplash.jpg" ></a>
                    <span>북한산</span>
                </div>
                <div class="item">
                    <a><img class="img" src="/images/mountain/tj-k-4m9j8TrudRs-unsplash.jpg" ></a>
                    <span>북한산</span>
                </div>
                <div class="item">
                    <a><img class="img" src="/images/mountain/tj-k-4m9j8TrudRs-unsplash.jpg" ></a>
                    <span>북한산</span>
                </div>
                <div class="item">
                    <a><img class="img" src="/images/mountain/tj-k-4m9j8TrudRs-unsplash.jpg" ></a>
                    <span>북한산</span>
                </div>
                <div class="item">
                    <a><img class="img" src="/images/mountain/tj-k-4m9j8TrudRs-unsplash.jpg" ></a>
                    <span>북한산</span>
                </div>

    
                </div>
    

            </div>
        </div>
    </div>



      <%@ include file="/WEB-INF/frame/default/footer.jsp"%>


</body>
</html>