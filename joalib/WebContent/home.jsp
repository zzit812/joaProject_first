<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOA LIBRARY - HOME</title>

<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">

<style>
	* {
		font-family: 'Noto Sans KR', sans-serif;
		color: #41414f;
		background-color: #f5f5f5;
	}
	body {
		width: 1400px;
		margin: 25px auto;
	}
	#logo {
		width: 220px;
		margin: 10px auto;
	    display: block;
	    opacity: 0;
	}
	li {
		display : inline;
	} 
	a {
		text-decoration: none;
	}
	nav > ul {
		/* background: green; */
	    padding: 15px 0px;
	    padding-left: 30px;
	    margin: 0;
	    /* border-top: 1px solid; */
	    box-shadow: 0px 10px 15px rgba(0,0,0,10%);
	    border-radius: 20px;
	    margin-top: 15px;
	    /* 맨 앞으로 보내기 */
	    z-index: 5;
    	position: relative;
	}
	nav > ul > li > a {
		font-size : 22px;
		margin: 0 30px;
	}
	
	#Point_1 {
		height: 500px;
    	/* 화면 꽉 차기 하기 : 띠 */
	    
	}
	#str {
		margin: 0;
	    font-weight: 300;
	    font-size: 70px;
	    text-align: center;
	    padding-top: 200px;
	}
	#Point_2 {
		margin-top: 155px;
		height: 400px;
    	background-color: #6a197d;
    	/* 화면 꽉 차기 하기 : 띠 */
    	width: 100%;
	    position: absolute; 
	    left: 0; 	    
	}
	
	/* wave	 */	
	@import url(//fonts.googleapis.com/css?family=Lato:300:400);
	
	.waves {
	  position:absolute;
	  width: 100%;
	  height:15vh;
	  left:0;
	  margin-bottom:-7px; /*Fix for safari gap*/
	  min-height:100px;
	  max-height:350px;
	}

	/* Animation */	
	.parallax > use {
	  animation: move-forever 25s cubic-bezier(.55,.5,.45,.5)     infinite;
	}
	.parallax > use:nth-child(1) {
	  animation-delay: -2s;
	  animation-duration: 7s;
	}
	.parallax > use:nth-child(2) {
	  animation-delay: -3s;
	  animation-duration: 10s;
	}
	.parallax > use:nth-child(3) {
	  animation-delay: -4s;
	  animation-duration: 13s;
	}
	.parallax > use:nth-child(4) {
	  animation-delay: -5s;
	  animation-duration: 20s;
	}
	@keyframes move-forever {
	  0% {
	   transform: translate3d(-90px,0,0);
	  }
	  100% { 
	    transform: translate3d(85px,0,0);
	  }
	}
	/*Shrinking for mobile
	@media (max-width: 768px) {	
	  .waves {
	    height:40px;
	    min-height:40px;
	  }
	  .content {
	    height:30vh;
	  }
	  h1 {
	    font-size:24px;
	  }
	}
	*/
	  
</style>
</head>
<body>
<!-- 
https://www.h-point.co.kr/cu/main/index.nhd 
https://codberg.com/
http://www.efusioni.com/2019/index.jsp
http://design.samsung.com/kr/index.html
https://www.hancomm.co.kr/index.do
-->

<header>
	<img id="logo" src="img/icon_lib.png" />
	<nav>
		<ul>
			<li><a href="">자료검색</a></li> 	<!-- 자료검색 -->
			<li><a href="">도서마당</a></li>	<!-- 도서마당 -->
			<li><a href="">이용안내</a></li>	<!-- 이용안내 -->
			<li><a href="">커뮤니티</a></li>	<!-- 커뮤니티 -->
			<li><a href="">나의서재</a></li>	<!-- 나의서재 -->
			<!-- <li><a href="">a</a></li> -->
			<!-- 만약  -->
		</ul>
	</nav>		
</header> 
<section>
	<!-- 배너 -->
	<div id="Point_1">
		<div id="str"></div>
	</div>
	
	<!--Waves Container-->
	<div id = "wave">
	<svg class="waves" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
	viewBox="0 24 150 28" preserveAspectRatio="none" shape-rendering="auto">
	<defs>
	<path id="gentle-wave" d="M-160 44c30 0 58-18 88-18s 58 18 88 18 58-18 88-18 58 18 88 18 v44h-352z" />
	</defs>
	<g class="parallax">
	<use xlink:href="#gentle-wave" x="48" y="0" fill="rgba(255, 165, 176, 0.3" />
	<use xlink:href="#gentle-wave" x="48" y="3" fill="rgba(255, 165, 176,0.3)" />
	<use xlink:href="#gentle-wave" x="48" y="5" fill="rgba(255, 165, 176,0.2)" />
	<use xlink:href="#gentle-wave" x="48" y="7" fill="#6a197d" />
	</g>
	</svg>
	</div>
	<!--Waves end-->
	
	<div id="Point_2"></div>
	
</section>
<footer></footer>

</body>

	<script type="text/javascript">
	
		//타이핑 애니메이션
		var string = "HELLO, PEOPLE";
		var str = string.split("");	//split : 문자를 자르는 메서드, ""으로 되어있으니 한글자 한글자씩 자름
		var el = document.getElementById('str');		
		(function animate() {	//애니메이션
			str.length > 0 ? el.innerHTML += str.shift() : clearTimeout(running); 
			var running = setTimeout(animate, 150);	//커질수록 느려짐	
		}
		
		)();
		
	</script>

</html>


