<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지도</title>
<!-- 오픈API -->
<script type="text/javaScript" src="http://www.nsdi.go.kr/lxportal/zcms/nsdi/platform/sdkGeoView.js.html?authkey=	dba776c1d85047318dc2053d7e2acf2a"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>  
</head>
<body>
<div id="sampleMap" style="height: 800px; width:100%;border: solid 1px;"></div>
<script>
 
// 지도생성
var map = new pf.GeoView("sampleMap","vworld",true,true);   
    

  
</script>
</body>
</html>