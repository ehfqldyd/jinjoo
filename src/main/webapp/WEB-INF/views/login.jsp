
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>GreenWay::login</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <style>
input[type=text] {
   padding: 8px;
   text-align: center;
   margin: 0px;
   width:350px;
}

input[type=password] {
   padding: 8px;
   text-align: center;
   margin: 0px;
   width:350px;
}
</style>
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

.centered { display: table; margin-left: auto; margin-right: auto; }
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
				<li><a href="board.do">��������</a>
					<ul class="sub">
		    			<li><a href="#">����޴�A</a></li>
						<li><a href="#">����޴�A</a></li>
						<li><a href="#">����޴�A</a></li>
					</ul>
				</li>
		 		
				<li><a href="congestion.do">����öȥ�⵵</a>
					<ul class="sub">
		    			<li><a href="#">����޴�B</a></li>
						<li><a href="#">����޴�B</a></li>
						<li><a href="#">����޴�B</a></li>
					</ul>
				</li>
				
				<li><a href="subway.do">�ǽð�����ö</a>
					<ul class="sub">
		    			<li><a href="#">����޴�C</a></li>
						<li><a href="#">����޴�C</a></li>
						<li><a href="#">����޴�C</a></li>
					</ul>
				</li>
				<li><a href="https://store.google.com/">�ٿ�ε�</a>
					<ul class="sub">
		    			<li><a href="#">����޴�D</a></li>
						<li><a href="#">����޴�D</a></li>
						<li><a href="#">����޴�D</a></li>
					</ul>
				</li>
				<%if(session == null && session.getAttribute("grade").equals("A")){ %>
				<li><a href="member_contr.do">ȸ������</a>
					<ul class="sub">
		    			<li><a href="#">����޴�A</a></li>
						<li><a href="#">����޴�A</a></li>
						<li><a href="#">����޴�A</a></li>
					</ul>
				</li>
		 		
				<li><a href="board_contr.do">�Խù�����</a>
					<ul class="sub">
		    			<li><a href="#">����޴�B</a></li>
						<li><a href="#">����޴�B</a></li>
						<li><a href="#">����޴�B</a></li>
					</ul>
				</li>
				
				<li><a href="blame_contr.do">�Ű����</a>
					<ul class="sub">
		    			<li><a href="#">����޴�C</a></li>
						<li><a href="#">����޴�C</a></li>
						<li><a href="#">����޴�C</a></li>
					</ul>
				</li>
				
				<%} %>
			</ul>
			<%if(session.getAttribute("userid") == null || session.getAttribute("grade") == null){ %>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="loginView.do">�α���</a></li>
				<li><a href="joinView.do">ȸ������</a></li>
			</ul>
			<%} %>
			<%if(session.getAttribute("userid") != null || session.getAttribute("grade") != null){ %>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="myInfoView.do">�� ������ȸ</a></li>
				<li><a href="logout.do">�α׾ƿ�</a></li>
			</ul>
			<%} %>
		</div>
	</div>
	</nav>

   <div class="container-fluid text-center">
      <div class="row content">
         <div class="col-sm-2 sidenav"></div>
         <div class="col-sm-8 centered" style="margin-top:5%;">


            <hr>
            <c:if test="${not empty message}">
               <h3>Message : ${message}</h3>
               <hr>
            </c:if>
            <h3><span style="color: green;text-shadow:#0f0; font-weight: bold;">GreenWay</span></h3>
            <form action="login.do" method="post">
               <table>
                  <tr>
                     <p>
                        <label for="userid">���̵�</label> <input id="userid" type="text"
                           name="userid" required autofocus
                           placeholder="������ҹ��ڼ��� �����ؼ� 6~12�ڸ� �̳��Է�"
                           style="margin-left: 43px;">
                        <!-- onkeyup="duplicationCheck()" -->
                        

                        <p>
                  <label for="userpw"> ��й�ȣ <input type="password"
                           name="userpw" placeholder="������ҹ���,����,Ư������ �����ؼ�8~12�ڸ� �̳��Է�"
                           required style="margin-left:30px;">

                  </label>
                  <!-- blank �� --><tr>
                     <td colspan="2">&nbsp;</td>
                  </tr>
   
   <tr>
   <td colspan="2" class="btnNormal">
      
   </td>
   </tr>
</table>
<div align="center"><input type="submit" value="�α���"></div>
</form>

<hr>
     <div style="text-decoration: none;margin-top:2%">
     <span style="color: green;text-shadow:#0f0; font-weight: bold;"><a href="" style="color: green;text-shadow:#0f0; margin-right:2%;">GreenWayȨ</a>   <a href="" style=" margin-right:2%;color: green;text-shadow:#0f0;">���̵�/��й�ȣã��</a>   <a href="" style=" margin-right:2%; color: green;text-shadow:#0f0;">ȸ������</a></span>
     </div>
     
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
	<p>www.greenway.com</p>
	</footer>

</body>
</html>
