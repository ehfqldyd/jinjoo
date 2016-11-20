
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <style>
input[type=text] {
   padding: 8px;
   text-align: center;
   margin: 0px;
   width:250px;
}

input[type=password] {
   padding: 8px;
   text-align: center;
   margin: 0px;
   width:320px;
}
input[type=email] {
   padding: 8px;
   text-align: center;
   margin: 0px;
   width:350px;
}

input[type=date] {
   padding: 8px;
   text-align: center;
   margin: 0px;
   width:350px;
}
input[type=tel] {
   padding: 8px;
   text-align: center;
   margin: 0px;
   width:350px;
}
.kim_margin_bottom {
   margin-bottom:10%;
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
<script type="text/javascript">
/* 회원가입 데이터 입력 검증 및 요청 메서드*/
function registerCheck() {
   
   var userId = document.inputForm.userId.value;
   var userPw = document.inputForm.userPw.value;

   if (userId.trim().length == 0 || userPw.trim().length == 0) {
      // 입력데이터 검증 오류
      alert("아이디와 비밀번호 정보를 올바르게 입력하시기 바랍니다.");
      return false;
   } else {
      // 입력데이터 검증 성공 => 로그인 요청 전송
      //alert('회원가입 성공');
      document.inputForm.submit();
   }
}

function reset() {
   document.inputForm.reset();
}

function duplicationCheck() {
   window.location='Controller?action=join&userId='+document.inputForm.userId.value;
   var userId = document.getElementById("userId").value;      
}


$(document).ready(function(){
    $('#userId').keyup(function(){
        if ( $('#userId').val().length > 2) {
           alert($('#userId').val());
            var id = $(this).val();
            // ajax 실행
            $.ajax({
                type : 'POST',
                url : '/Controller/join',
                data:
                {
                    userId: id
                },
                success : function(result) {
                    //console.log(result);
                    if (result == "ok") {
                        $("#result_id_msg").html("사용 가능한 아이디 입니다.");
                    } else {
                        $("#result_id_msg").html("사용 불가능한 아이디 입니다.");
                    }
                }
            }); // end ajax
        }
    }); // end keyup
});
</script>
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
				<li><a href="https://store.google.com/">다운로드</a>
					<ul class="sub">
		    			<li><a href="#">서브메뉴D</a></li>
						<li><a href="#">서브메뉴D</a></li>
						<li><a href="#">서브메뉴D</a></li>
					</ul>
				</li>
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
    <div class="col-sm-2 sidenav">
      
    </div>
    <div class="col-sm-8 text-left">
    
     <c:if test="${not empty message}">
   <h3>Message : ${message}</h3>
   <hr>
   </c:if>

<section class="kim_margin_bottom">
      <hr>
      <h3 style="margin-left:250px;">회원가입</h3>
      <article>
         <form name="inputForm" method="post" action="join.do">
            <fieldset style="width:50%; margin-left:250px;">
               <legend>필수사항</legend>
               <%if(request.getAttribute("message") != null){ %>
               Error Message : <span style="color:red;font-size:12px;font-weight:bold;"><%= request.getAttribute("message") %></span>
               <%} %>
               
               <p>
                  <label for="userid">아이디</label> <input id="userid" type="text"
                     name="userid" required autofocus
                     placeholder="영문대소문자숫자 조합해서 6~12자리 이내입력" style="margin-left:30px;" value=<%if(request.getAttribute("textUserId")!= null){%> 
                     <%= request.getAttribute("textUserId")%>
                     <%}%>> <!-- onkeyup="duplicationCheck()" --><input type="button" value="중복 체크" onclick="return duplicationCheck()">
                     <span style="color:red;font-size:12px;font-weight:bold;">
                     <%if(request.getAttribute("checkData")!= null){%> 
                     <%= request.getAttribute("checkData")%>
                     <%}%></span>
                     <span id="result_id_msg"></span>
               <p>
                  <label for="userpw"> 비밀번호 <input type="password" name="userpw"
                     placeholder="영문대소문자,숫자,특수문자 조합해서8~12자리 이내입력" required
                     style="margin-left:45px;">

                  </label>
               <p>
                  <label for="userpw2"> 비밀번호 재입력 <input type="password" name="userpw2"
                     placeholder="비밀번호 재입력해 주세요" required>

                  </label>
               <p>
                  <label for="name">이름</label> <input id="name" type="text"
                     name="name" required autofocus
                     placeholder="영문대소문자숫자 조합해서 6~12자리 이내입력" style="margin-left:45px;width:350px">
               
               <p>
                  <label for="mobile">연락처</label> <input id="mobile" type="tel"
                     name="mobile" size="50px" required autofocus
                     placeholder="(예)010-0000-0000" style="margin-left:30px;">
               
               <p>
                  <label for="email">이메일</label> <input id="email" type="email"
                     name="email" size="50px" required autofocus
                     placeholder="(예)greenway@syu.ac.kr" style="margin-left:30px;">
               
               <p>
                  <label for="gender">성별</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 여<input type="radio" id="gender" name="gender" value="F" checked>&nbsp;&nbsp;
                  남  <input type="radio" id="gender1" name="gender" value="M">
               <p>
                  <label for="birth">생년월일</label> <input id="birth" type="date"
                     name="birth" size="50px" required autofocus
                     placeholder="(예)1993" style="margin-left:20px;">   
               
               <p>
                  <input type="hidden"
                     name="manager" size="50px"
                     style="margin-left:20px;" value="해당없음">
            </fieldset>
            
            <input type="image" src="images/registerOk.png" onclick="return registerCheck()" style="margin-left:250px;">
            <input type="image" src="images/cancel.png" onclick="history.back()" style="margin-left:250px;">
         </form>
      </article>
   </section>
     
     
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
	<p>www.greenway.com</p>
	</footer>

</body>
</html>
