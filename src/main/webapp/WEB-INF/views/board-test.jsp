
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Bootstrap Example</title>
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
  <link rel="stylesheet" href="http://www.w3schools.com/lib/w3-theme-green.css">
  
  <script type="text/javascript">
 /*
  window.onload = start;
  function start() {
     var allTable = document.getElementsByTagName('table');
     for (i = 0; i < allTable.length; i++) {
        allTable[i].style.display = "none";
     }
  }
  */
 
  function insertBoard(){
	  console.log("insertBoard");
	  var userid = "user01";
	  var title = document.getElementById("title").value;
	  var contents= document.getElementById("contents").value;
	  
	  if(title != null && contents !=null)
		
	  {
		  console.log("========================");
	     
	
 	 	$.ajax({
		 		type:'POST',
		 		url:'insertBoard.do',
		 		data: {
					"userid" : userid,
					"title": title,
					"contents":contents
				},
		 		dataType : "json",
		 		success:function(data){
		 			console.log('success data', data);
		 			
		 			var table = document.getElementById('tbody');
		 			for (var i = 0; i < data.length; i++) {
                        var _html = '<tr>';
                        _html += '      <td><input type="text" style="vertical-align:middle;"   value="' +  data[i].title + '"/></td>';
                        _html += '      <td><input type="text"  value="' + data[i].contents + '"></textarea></td>';
                        _html += '   </tr>';
                        $('#boardBody').append(_html);
                    }
		           
		          
		 			
		 		},
		 		fail: function(error) {
		 			
		 			console.log(error);
		 			
	                 
		           }
		 	}) ;
		 }
	  else {
		  console.log("else====================");
		  console.log(title);
		  console.log(contents);
		  alert("title,contents: null"); 
		  }
	  console.log("finish====================");
  }
</script>
</head>
<body>
 <!-- Page Container -->
   <div class="w3-container w3-content" style="max-width: 1400px; margin-top: 80px">
      <!-- The Grid -->
      <div class="w3-row">
         <!-- Left Column -->
        

         <!-- Middle Column -->
         <div class="w3-col m6">

			<div class="w3-row-padding">
               <div class="w3-col m12">
                  <div class="w3-card-2 w3-round w3-white">
                     <div class="w3-container w3-padding">
                        <h6 class="w3-opacity">글쓰기</h6>
                        <form>
                           <input name="boardtitle"  id="title" class="w3-input w3-border w3-padding w3-round-large w3-margin-bottom" placeholder="예)o호선 oo역 열차지연 ">
                           <textarea class="form-control" rows="5" id="contents"></textarea>
                           <button type="button" class="w3-btn w3-theme" id="sumnit-btn" onclick="javascript:insertBoard()">
                              등록
                           </button>
                           
                        </form>
                     </div>
                  </div>
               </div>
            </div>
 			<br><br><br>
			<table class="w3-table-all w3-margin-bottom" id="detailTable" style="">
                  <thead style="max-width:100%">
                  <tr>
                  	<td>hello test</td>
                  	<td>hello test</td>
                  	<td>hello test</td>
                  </tr>
                  </thead>
                  <tbody id="boardBody"  style="max-width:100%">
                     <tr>
                       <td>
                        </td>
                        <form  id="insertComment">
                        <td><input class="w3-input" id="commentId" placeholder="userid"></td>
                        <td><input class="w3-input" id="commentContents" placeholder="댓글입력"></td>
                        <td><button type="button" onclick="insertReple"class="w3-btn w3-blue-grey">저장</button></td>
                        </form>
                     </tr>
                  </tbody>
            </table>
         </div>
            <!-- End Middle Column -->
      </div>


   </div>

      <!-- End Grid -->

   <!-- End Page Container -->
   <br>
   
        <div >
<table id="tbody">	
</table>
</div>
     

</body>
</html>
   
   
   



