<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>메인화면</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("ul.sub").hide();
	$("ul.menu li").hover(function(){
	$("ul:not(:animated)",this).slideDown("slow");
	},
	function(){
		$("ul",this).slideUp("slow");
	});
});	
</script>

  <style type="text/css">
      *{
	     margin: 0;
		 padding: 0;
		 list-style-type: none;}
      ul.menu li{ 
	     float: left;
		 width: 179px;
		 height: 48px;
		 background-color: #194ca0;
		 position: relative;
		 }
      ul.menu li a{
	     display: block;
		 width: 100%;
		 height: 100%;
		 line-height: 27px;
		 text-indent: 30px;
		 font-weight: bold;
		 color: #eee;
		 text-decoration: none;
		 }
      ul.menu li a:hover{
	     background-color: #333;
		 }
      ul.menu li ul.sub{
	     position: absolute;
	     z-index: 5;
		 }
      ul.menu{
	     zoom: 1;
		 }
      ul.menu:after{
	     height: 0;
		 visibility: hidden;
		 content: ".";
		 display: block;
		 clear: both;
		 }

/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 595px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home.do">GREEN WAY</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav menu">
				<li><a href="board.do">공지사항</a>
					<ul class="sub">
		    			<li><a href="#">서브메뉴A</a></li>
						<li><a href="#">서브메뉴A</a></li>
						<li><a href="#">서브메뉴A</a></li>
					</ul>
				</li>
		 		
				<li><a href="congestion.do">지하철혼잡도</a>
					<ul class="sub">
		    			<li><a href="#">서브메뉴B</a></li>
						<li><a href="#">서브메뉴B</a></li>
						<li><a href="#">서브메뉴B</a></li>
					</ul>
				</li>
				
				<li><a href="subway.do">실시간지하철</a>
					<ul class="sub">
		    			<li><a href="#">서브메뉴C</a></li>
						<li><a href="#">서브메뉴C</a></li>
						<li><a href="#">서브메뉴C</a></li>
					</ul>
				</li>
				<li><a href="https://store.google.com/">다운로드</a>
					<ul class="sub">
		    			<li><a href="#">서브메뉴D</a></li>
						<li><a href="#">서브메뉴D</a></li>
						<li><a href="#">서브메뉴D</a></li>
					</ul>
				</li>
				<%if(session != null &&session.getAttribute("grade").equals("A")){ %>

				<li><a href="member_contr.do">회원관리</a>
					<ul class="sub">
		    			<li><a href="#">서브메뉴A</a></li>
						<li><a href="#">서브메뉴A</a></li>
						<li><a href="#">서브메뉴A</a></li>
					</ul>
				</li>
		 		
				<li><a href="board_contr.do">게시물관리</a>
					<ul class="sub">
		    			<li><a href="#">서브메뉴B</a></li>
						<li><a href="#">서브메뉴B</a></li>
						<li><a href="#">서브메뉴B</a></li>
					</ul>
				</li>
				
				<li><a href="blame_contr.do">신고관리</a>
					<ul class="sub">
		    			<li><a href="#">서브메뉴C</a></li>
						<li><a href="#">서브메뉴C</a></li>
						<li><a href="#">서브메뉴C</a></li>
					</ul>
				</li>
				<%} %>
			</ul>
			<%if(session != null && session.getAttribute("userid") != null && session.getAttribute("grade") != null){ %>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="myInfoView.do">내 정보조회</a></li>
				<li><a href="logout.do">로그아웃</a></li>
			</ul>
			<%} else{ %>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="loginView.do">로그인</a></li>
				<li><a href="joinView.do">회원가입</a></li>
			</ul>
			<%} %>
		</div>
	</div>
	</nav>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav"></div>
			<div class="col-sm-8 text-left">
				<h3>User : ${userid}님 [ ${grade} ]</h3>
				<hr>
			</div>
			<div class="col-sm-2 sidenav"></div>
		</div>
	</div>
	<footer class="container-fluid text-center">
	<p>www.greenway.com</p>
	</footer>
</body>
</html>