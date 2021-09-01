<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mountain_all</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/css/mountain/mountain_all.css'/>">
    <script src="https://kit.fontawesome.com/cccee664d4.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="/WEB-INF/frame/default/header.jsp"%>
<div class="back">
    <div class="main">
        <div class="main_item  main_item_1 search">
            <div class="search_item_text">
                어디로 오를래
            </div>
            <div class="search_item_search">
                <input type="text" class="search_input"
                       placeholder="산 또는 지역명을 검색해주세요. ex)서울, 북한산"
                       onfocus="this.placeholder=''"
                       onblur="this.placeholder='산 또는 지역명을 검색해주세요. ex)서울, 북한산'">
                <a href="#"><span class="material-icons">search</span></a>
            </div>
        </div>

        <div class="main_item main_item_2">
            <img src="../images/mountain/map_color.png" width="700px" height="700px" usemap="#location">
            <map id="location" name="location">
                <area shape="poly" alt="" title=""
                      coords="342,15,319,47,168,60,186,83,246,103,239,135,280,146,263,195,385,215,468,201,418,105,376,47"
                      href="${pageContext.request.contextPath}/mountain/mountainLocInfo?locName=강원" target=""/>
                <area shape="poly" alt="" title=""
                      coords="283,344,218,299,232,277,214,237,204,225,265,193,366,212,335,239,285,265" href="충북"/>
                <area shape="poly" alt="" title=""
                      coords="142,105,167,60,187,87,244,105,246,137,277,146,265,190,204,227,130,201,114,132"
                      href="서울경기"/>
                <area shape="poly" alt="" title="" coords="63,246,125,195,216,237,233,280,197,331,125,346,81,302"
                      href="충남"/>
                <area shape="poly" alt="" title=""
                      coords="285,347,348,392,485,383,490,320,469,195,341,212,284,257,284,278"
                      href="경북">
                <area shape="poly" alt="" title="" coords="94,421,131,342,202,324,229,305,284,353,242,425" href="전북"/>
                <area shape="poly" alt="" title="" coords="107,556,79,426,244,427,273,503" href="전남"/>
                <area shape="poly" alt="" title=""
                      coords="359,509,271,489,244,422,284,357,355,389,474,389,453,458,426,479"
                      href="경남"/>
                <area shape="poly" alt="" title="" coords="56,672,136,628,177,650,130,674,71,693,51,682" href="제주"/>
            </map>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/frame/default/footer.jsp"%>
</body>
</html>