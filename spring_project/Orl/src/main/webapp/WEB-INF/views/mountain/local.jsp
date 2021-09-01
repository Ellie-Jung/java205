<%@ page import="com.bitcamp.orl.mountain.domain.MountainLocInfo" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>지역별산</title>
    <link rel="stylesheet" href="<c:url value='/css/mountain/local.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
    
    
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script>
    
    	$(document).ready(function(){
    		
    		/* 이름순으로 정렬하기 */
    		$('#namelist').click(function(){
    			
   			 $.ajax({
   				url:'<c:url value="/mountain/height2"/>',
   				type:'GET',
   				data:{ loc:'${loc}'	},
   				success:function(data){
   				 	var html='<div id="listings" class="listings">'; 
   				 	
   					$.each(data,function(index,item){
							html+=' <div class="listings_item">';
   						html+=' <div class="listings_image">';
   						html+=' <img src="https://www.forest.go.kr/images/data/down/mountain/'+item.img+'" alt="">';
   						html+='</div>';
   						html+=' <div class="listings_content">';
   						html+=' <div class="listings_title">';
   						html+=' <div class="listings_text">';
   						html+='   <span class="greyText">${loc} 산 전체</span>';
   						html+=' <h2>#'+item.mountainName+'</h2>';
   						html+='</div>';
   						html+='</div>';
   						html+='<div class="listings_description">';
   						html+='   <span >'+item.mountainAddress+'</span>';
   						html+=' <span class="greyText">'+item.mountainInfo+'</span>';
   						html+='  </div>';
   						html+='</div>';
   						html+='</div>';
   						html+='</div>';
   						
   						$('#mlist').html(html); 
   					})
   				}
   			}); 
   		})
    	
      		/* 높이순으로 정렬하기 */
    		$('#heightlist').click(function(){
    			
    			 $.ajax({
    				url:'<c:url value="/mountain/height"/>',
    				type:'GET',
    				data:{ loc:'${loc}'	},
    				success:function(data){
    				 	var html='<div id="listings" class="listings">'; 
    				 	
    					$.each(data,function(index,item){
							html+=' <div class="listings_item">';
    						html+=' <div class="listings_image">';
    						html+=' <img src="https://www.forest.go.kr/images/data/down/mountain/'+item.img+'" alt="">';
    						html+='</div>';
    						html+=' <div class="listings_content">';
    						html+=' <div class="listings_title">';
    						html+=' <div class="listings_text">';
    						html+='   <span class="greyText">${loc} 산 전체</span>';
    						html+=' <h2>#'+item.mountainName+'</h2>';
    						html+='</div>';
    						html+='</div>';
    						html+='<div class="listings_description">';
    						html+='   <span >'+item.mountainAddress+'</span>';
    						html+=' <span class="greyText">'+item.mountainInfo+'</span>';
    						html+='  </div>';
    						html+='</div>';
    						html+='</div>';
    						html+='</div>';
    						
    						$('#mlist').html(html); 
    					})
    				}
    			}); 
    		})
    	})
    	
    	
    </script>
    
</head>
<body>
<%@ include file="/WEB-INF/frame/default/header.jsp" %>

<!--중간 부분 전부-->
<div class="main">
    <!--왼쪽 컨텐츠-->
    <div class="main_content">
        <span>${countLoc}개의 산</span>
        <h1>${loc}</h1>
        <div class="search">
            <div class="iconsearch"></div>
            <div class="input">
                <input type="text" placeholder="산 이름을 검색하세요" id="mysearch">
            </div>
            <span id='clearIcon' class="clear" style="display:none;"
                  onclick="document.getElementById('mysearch').value=''"></span>
        </div>

        <script>
            const iconsearch = document.querySelector('.iconsearch');
            const search = document.querySelector('.search');
            const clearIcon = document.getElementById("clearIcon");
            iconsearch.onclick = function () {
                search.classList.toggle('active')
                if (clearIcon.style.display == 'none') {
                    clearIcon.style.display = 'block';
                } else {
                    clearIcon.style.display = 'none';
                }
            }
        </script>


        <div class="main_filters">
            <button class="outlined curved" id="namelist">이름순으로 보기</button>
            <button class="outlined curved" id="heightlist">높이순으로 보기</button>
           <!--  <button class="outlined curved">인기순으로 보기</button> -->
        </div>


        <div class="main_scarcity">
            <img src="" alt="">
            <span>
                    <span>

                        산 이름을 입력하시면 해당 산에 대한 정보를 확인할 수 있습니다.
                    </span>
                검색하기 전에 지도로 주변 산들을  둘러보세요.
                </span>
        </div>
        
        <div id="mlist">
		<c:forEach items="${mountainLocInfoList}" var="list">
	        <div class="listings">
	        
	            <div class="listings_item">
	                <div class="listings_image">
	                    <img src="https://www.forest.go.kr/images/data/down/mountain/${list.img}" alt="">
	                </div>
	                <div class="listings_content">
	                    <div class="listings_title">
	                        <div class="listings_text">
	                            <span class="greyText">${loc} 산 전체</span>
	                            <h2>#${list.mountainName}</h2>
	                        </div>
	                    </div>
	                    <div class="listings_description">
	                        <span >${list.mountainAddress}</span>
	                        <span class="greyText">${list.mountainInfo}</span>
	                    </div>
	                </div>
	            </div>
	        </div>
		</c:forEach>
		</div>
    </div>


    <!--오른쪽 지도-->
    <div class="main_map">
        <div class="main_kakaoMap">
            <div class="map" id='map'></div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/frame/default/footer.jsp" %>

<!--카카오 지도 스크립트 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a5188ac15584cefe54aea3746f43ba94"></script>
<script>
    var container = document.getElementById('map');
    var options = {
        center: new kakao.maps.LatLng(37.65947494926604, 126.97759875364473),
        level: 6
    };
    var map = new kakao.maps.Map(container, options);
</script>


</body>


</html>