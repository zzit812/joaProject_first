<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOA LIBRARY - HOME</title>

<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>


<style>
	* {
		font-family: 'Noto Sans KR', sans-serif;
		color: #41414f;
		
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
	#top_menu > li {
		float: left;
	    display: block;
	    margin: 5px 20px;	    
	}
	#top_menu > li > a{
		/*대메뉴*/
		font-size: 25px;		
    	font-weight: 400;
		margin: 0 30px;
	}
	#top_menu > li > ul {
		height: 200px;
		overflow: hidden;
		background-color: red;
		margin-top: 15px;
		position: absolute;
		transition: all 0.2s;
	}
	
	#top_menu > li > ul > li {
		clear: both;		
		font-size: 15px;
		display: block;
	}
	#top_menu > li > ul > li > a{
		/*소메뉴*/
		font-size: 20px;
	}
	
	a {
		text-decoration: none;
	}
	nav > ul { 
		background: #f5f5f5;
		padding: 10px 0;
	    padding-left: 30px;
	    margin: 0;
	    /* border-top: 1px solid; */
	    box-shadow: 0px 10px 15px rgba(0,0,0,10%);
	    border-radius: 20px;
	    margin-top: 15px;
	    /* 맨 앞으로 보내기 */
	    z-index: 5;
    	position: relative;
    	height: 45px;
	}
	
	#Point_1 {
		height: 650px;
	    
	}
	#str {
		margin: 0;
	    font-weight: 300;
	    font-size: 70px;
	    text-align: center;
	    padding-top: 200px;
	}
	#Point_2 {
		margin-top: 175px;
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
	
/*========================================================*/

	  
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
	
				<ul id="top_menu">			
					
					<li><a href="book_search.html">자료검색</a>
						<ul class ="sub_menu">
							<li><a href="book_search.html">도서 검색</a></li>
							<li><a href="">분야별 도서 조회</a></li>
						</ul>
					</li>
					
					<li><a href="#">도서마당</a>
						<ul>
							<li><a href="">신착 도서</a></li>
							<li><a href="">베스트 셀러</a></li>
							<li><a href="">희망도서</a></li>
						</ul>
					</li>
					
					<li><a href="#">이용안내</a>
						<ul>
							<li><a href="">시설안내</a></li>
							<li><a href="">자료 현황</a></li>
							<li><a href="">포인트</a></li>
							<li><a href="">도서 대여</a></li>
							<li><a href="">도서 예약</a></li>
						</ul>
					</li>	
								
					<li><a href="#">커뮤니티</a>
						<ul>
							<li><a href="">공지사항</a></li>
							<li><a href="">질문과 답변</a></li>
							<li><a href="board.jsp">자유게시판</a></li>
							<li><a href="">불량도서 신고</a></li>
							<li><a href="">중고도서 나눔</a></li>
						</ul>
					</li>
					
					<li><a href="mypage_main.jsp">나의서재</a>
						<ul>
							<li><a href="mypage_main.jsp">나의 서재</a></li>
							<li><a href="">서비스 이용 내역</a></li>
							<li><a href="">내가 쓴 글</a></li>
							<li><a href="">포인트</a></li>
							<li><a href="">정보 수정/ 탈퇴</a></li>
						</ul>
					</li>
					<li>로그인</li>
					<li>회원가입</li>
				</ul>
				
				<script type="text/javascript">
					$(function(){
						$('#top_menu > li').hover(function(){
							$('#top_menu > li > ul').css("height","150px");
						},function(){
							$('#top_menu > li > ul').css("height","0px");
						})
					})
					
					$(function() {
					    $('.book_hover .book_add').hide();
					    $('.book_hover').hover(function() {
					      $(this).children('img').css("opacity","0.2")
					      $(this).children('.book_add').show();
					    },function(){
					      $(this).children('img').css("opacity","1")
					      $(this).children('.book_add').hide();
					    })
					  })

				</script>
				
				<div id="window_menu"></div>
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
			var running = setTimeout(animate, 80);	//커질수록 느려짐	
		}
		
		)();
		

		
	</script>

</html>


