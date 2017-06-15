<%@page import="java.util.List"%>
<%@page import="beans.idea"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <title>Share your ideas</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="bootstrap.min.css">  
  <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="login.css">
  
  
</head>
<body>

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
            
			<li class="active"><a href="client_page_accueil.jsp">HOME</a></li>
            <li><a href="client_idea.jsp">IDEAS</a></li>
         	<li><a href="ideas.jsp">ADD IDEA</a></li>
            <li><a href="client_scientist.jsp">SCIENTISTS</a></li>
            <li><a href="client_domain.jsp">DOMAINES</a></li>
            <li><a href="client_comment.jsp">COMMENTS</a></li>
            <li><a href="comments.jsp">ADD COMMENT</a></li>
             
          <!-- <li style="margin-left" class="navbar-right"><a href="#">Log out</a></li> -->
          
           <!--  <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">  
                    Java
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">jmeter</a></li>
                    <li><a href="#">EJB</a></li>
                    <li><a href="#">Jasper Report</a></li>
                    <li class="divider"></li>
                    <li><a href="#"> </a></li>
                    <li class="divider"></li>
                    <li><a href="#"> </a></li>
                </ul>
            </li> -->
           </ul>
    </div>
    </div>
</nav>

<div class="container">
  <div class="jumbotron">
    <h1>Project SR03 - Share your ideas</h1>
    <p>DISCUSSIONS AND SHAREING IDEAS BETWEEN SCIENTISTS</p> 
    <br>
    <p align="right">Jin YU<br>Amaury FISCHER DE GUILLEBON</p>
  </div>

</div>


</body>
</html>
