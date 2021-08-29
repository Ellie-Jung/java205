<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>지역별산</title>
    <link rel="stylesheet" href="<c:url value='/css/mountain/local.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/default/default.css'/>">
</head>
<body>
    <%@ include file="/WEB-INF/frame/default/header.jsp"%>

    <!--중간 부분 전부-->
    <div class="main">
        <!--왼쪽 컨텐츠-->
        <div class="main_content">
            <span>300 개의 산</span>
            <h1>서울</h1>
            <div class="search">
                <div class="iconsearch"></div>
                <div class="input">
                    <input type="text" placeholder="산 이름을 검색하세요" id="mysearch">
                </div>
                <span id='clearIcon' class="clear" style="display:none;" onclick="document.getElementById('mysearch').value=''"></span>
            </div>

            <script>
            const iconsearch = document.querySelector('.iconsearch');
            const search = document.querySelector('.search');
            const clearIcon = document.getElementById("clearIcon");
            iconsearch.onclick = function () {
                search.classList.toggle('active')
                if(clearIcon.style.display=='none'){
                    clearIcon.style.display='block';
                }else{
                    clearIcon.style.display='none';
                }
            }


            </script>


            <div class="main_filters">
                <button class="outlined curved">이름순으로 보기</button>
                <button class="outlined curved">높이순으로 보기</button>
                <button class="outlined curved">인기순으로 보기</button>
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

            <div class="listings">
                <div class="listings_item">
                    <div class="listings_image">
                        <button>
                            <i class="fas fa-angle-left"></i>
                        </button>
                        <button>
                            <i class="fas fa-angle-right"></i>
                        </button>
                        <img src="/images/mountain/tj-k-4m9j8TrudRs-unsplash.jpg" alt="">
                    </div>
                    <div class="listings_content">
                        <div class="listings_title">
                            <div class="listings_text">
                                <span class="greyText">서울시 산 전체</span>
                                <h2>#북한산</h2>
                            </div>
                        </div>
                        <div class="separator"></div>
                        <div class="listings_description">
                            <span class="greyText">서울시 강북구 도봉구 은평구 성북구 종로구와 경기도 고양시 덕양구 양주시 의정부시 경계에 위치</span>
                            <span class="greyText">북한산 둘레길 코스가 개방</span>
                        </div>
                    
                    </div>
                </div>
            </div>

            <div class="listings">
                <div class="listings_item">
                    <div class="listings_image">
                        <button>
                            <i class="fas fa-angle-left"></i>
                        </button>
                        <button>
                            <i class="fas fa-angle-right"></i>
                        </button>
                        <img src="/images/mountain/tj-k-4m9j8TrudRs-unsplash.jpg" alt="">
                    </div>
                    <div class="listings_content">
                        <div class="listings_title">
                            <div class="listings_text">
                                <span class="greyText">서울시 산 전체</span>
                                <h2>#북한산</h2>
                            </div>
                            <div class="listings_title_icon">

                            </div>
                        </div>
                        <div class="separator"></div>
                        <div class="listings_description">
                            <span class="greyText">서울시 강북구 도봉구 은평구 성북구 종로구와 경기도 고양시 덕양구 양주시 의정부시 경계에 위치</span>
                            <span class="greyText">북한산 둘레길 코스가 개방</span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="listings">
                <div class="listings_item">
                    <div class="listings_image">
                        <button>
                            <i class="fas fa-angle-left"></i>
                        </button>
                        <button>
                            <i class="fas fa-angle-right"></i>
                        </button>
                        <img src="/images/mountain/tj-k-4m9j8TrudRs-unsplash.jpg" alt="">
                    </div>
                    <div class="listings_content">
                        <div class="listings_title">
                            <div class="listings_text">
                                <span class="greyText">서울시 산 전체</span>
                                <h2>#북한산</h2>
                            </div>
                            <div class="listings_title_icon">

                            </div>
                        </div>
                        <div class="separator"></div>
                        <div class="listings_description">
                            <span class="greyText">서울시 강북구 도봉구 은평구 성북구 종로구와 경기도 고양시 덕양구 양주시 의정부시 경계에 위치</span>
                            <span class="greyText">북한산 둘레길 코스가 개방</span>
                        </div>
                    </div>
                </div>
            </div>


            <div class="listings">
                <div class="listings_item">
                    <div class="listings_image">
                        <button>
                            <i class="fas fa-angle-left"></i>
                        </button>
                        <button>
                            <i class="fas fa-angle-right"></i>
                        </button>
                        <img src="/images/mountain/tj-k-4m9j8TrudRs-unsplash.jpg" alt="">
                    </div>
                    <div class="listings_content">
                        <div class="listings_title">
                            <div class="listings_text">
                                <span class="greyText">서울시 산 전체</span>
                                <h2>#북한산</h2>
                            </div>
                            <div class="listings_title_icon">

                            </div>
                        </div>
                        <div class="separator"></div>
                        <div class="listings_description">
                            <span class="greyText">서울시 강북구 도봉구 은평구 성북구 종로구와 경기도 고양시 덕양구 양주시 의정부시 경계에 위치</span>
                            <span class="greyText">북한산 둘레길 코스가 개방</span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="listings">
                <div class="listings_item">
                    <div class="listings_image">
                        <button>
                            <i class="fas fa-angle-left"></i>
                        </button>
                        <button>
                            <i class="fas fa-angle-right"></i>
                        </button>
                        <img src="/images/mountain/tj-k-4m9j8TrudRs-unsplash.jpg" alt="">
                    </div>
                    <div class="listings_content">
                        <div class="listings_title">
                            <div class="listings_text">
                                <span class="greyText">서울시 산 전체</span>
                                <h2>#북한산</h2>
                            </div>
                            <div class="listings_title_icon">

                            </div>
                        </div>
                        <div class="separator"></div>
                        <div class="listings_description">
                            <span class="greyText">서울시 강북구 도봉구 은평구 성북구 종로구와 경기도 고양시 덕양구 양주시 의정부시 경계에 위치</span>
                            <span class="greyText">북한산 둘레길 코스가 개방</span>
                        </div>
                    </div>
                </div>
            </div>


        </div>


        <!--오른쪽 지도-->
        <div class="main_map">
            <div class="main_kakaoMap">
                <div class="map" id='map'></div>
            </div>
        </div>
    </div>
        
          <%@ include file="/WEB-INF/frame/default/footer.jsp"%>

    <!--카카오 지도 스크립트 -->
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=35d3d05e2a1bb341d20b0d374beb2a05"></script>
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
