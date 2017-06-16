<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<link rel="stylesheet" href="bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="login.css">
	<script type="text/javascript" src="login.js"> </script>
	<script src="comment.js"></script>
	
	<title>COMMENTS</title>

	<style>
	table, th, td, tr {
	   class: "table table-striped";
	}
	</style>
	
</head>

<body onload="traitementAjax()">
	<%
	//allow access only if session exists
	
	String userName = null;
	
	if(session.getAttribute("userName")==null){
		response.sendRedirect("client_login.jsp");
	}else {
		userName = (String) session.getAttribute("userName");
	}
	
	String userNameSession = null;
	String sessionID = null;
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("userName")){
				userNameSession = cookie.getValue();			
			}
			if(cookie.getName().equals("JSESSIONID")){
				sessionID = cookie.getValue();
			}
		}
	}
	%>

	<nav class="navbar navbar-default" role="navigation">
	    <div class="container-fluid">
	    <div class="navbar-header">
	    	<a class="navbar-brand" href="#">Hi,<%=userName %>!</a>
	       <!--   <a class="navbar-brand" href="#">Projet SR03</a>-->
	    </div>
	    <div>
	        <ul class="nav navbar-nav">
	            
				<li><a href="client_page_accueil.jsp">HOME</a></li>
	            <li><a href="client_idea.jsp">IDEAS</a></li>
	         	<li><a href="ideas.jsp">ADD IDEA</a></li>
	            <li><a href="client_scientist.jsp">SCIENTISTS</a></li>
	            <li ><a href="client_domain.jsp">DOMAINES</a></li>
	            <li class="active"><a href="client_comment.jsp">COMMENTS</a></li>
	            <li><a href="comments.jsp">ADD COMMENT</a></li>
	             
	          <!-- <li style="margin-left" class="navbar-right"><a href="#">Log out</a></li> -->
	          
	          
	           </ul>
	           
           	 <ul class="nav navbar-nav navbar-right">
           	 	<li><a href="#" onclick="logout_Ajax();" >LOG OUT</a></li>
           	 </ul>
	    </div>
	    </div>
	</nav>
<p id="demo"></p>
</body>
</html>