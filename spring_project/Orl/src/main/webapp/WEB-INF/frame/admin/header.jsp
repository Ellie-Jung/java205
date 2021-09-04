<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



</head>
<body>
  <!--헤더시작 -->
 
   <nav class="navbar ">
       <div class="navbar__logo">
        <i class="fas fa-mountain"></i>
            <a href="#">오를래</a>
       </div>

       <ul class="navbar__menu">
            <li><a href="">MEMBER</a></li>
            <li><a href="">MOUATAIN</a></li>
            <li><a href="">CREW</a></li>
            <li><a href="">FEED</a></li>


       </ul>

       <ul class="navbar__icons">
           <li><a href="#">로그아웃</a></li>
       </ul>

       <a href="#" class="navbar__toogleBtn">
        <i class="fas fa-bars"></i>
       </a>

   </nav>
   
   
<!--헤더끝-->

<script>
        const toggleBtn = document.querySelector('.navbar__toogleBtn');
        const menu = document.querySelector('.navbar__menu');
        const icons = document.querySelector('.navbar__icons');
    
        toggleBtn.addEventListener('click', ()=>{
            menu.classList.toggle('active');
            icons.classList.toggle('active');
        });
</script>


</body>
</html>