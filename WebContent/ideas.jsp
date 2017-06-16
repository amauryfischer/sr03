<%@page import="java.util.List"%>
<%@page import="beans.idea"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

	<link rel="stylesheet" href="bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="ideas.css">
	<script type="text/javascript" src="login.js"> </script>
	<script type="text/javascript" src="idea.js"> </script>
	<title>NEW IDEA</title>
	
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
            
			<li><a href="client_page_accueil.jsp">HOME</a></li>
            <li><a href="client_idea.jsp">IDEAS</a></li>
         	<li class="active"><a href="ideas.jsp">ADD IDEA</a></li>
            <li><a href="client_scientist.jsp">SCIENTISTS</a></li>
            <li><a href="client_domain.jsp">DOMAINES</a></li>
            <li><a href="client_comment.jsp">COMMENTS</a></li>
            <li><a href="comments.jsp">ADD COMMENT</a></li>
             

           </ul>
             
             <ul class="nav navbar-nav navbar-right">
           	 	<li><a href="#" onclick="logout_Ajax();" >LOG OUT</a></li>
           	 </ul>
    </div>
    </div>
</nav>
<div class="container auth">
    <div id="big-form" class="well auth-box">
      <form name = "myform2" method="post" action="ideas">
        <fieldset>

          <!-- Form Name -->
          <legend>New Idea</legend>


          <!-- Text input-->
          <div class="form-group">
            <label class=" control-label" for="textinput">Title</label>  
            <div class="">
              <input id="title" name="title" placeholder="Title" class="form-control input-md" type="text">
            </div>
          </div>

 
           <div class="form-group">
            <label class=" control-label" for="passwordinput">Comment-id</label>
            <div class="">
              <input id="commentIds" name="commentIds" placeholder="Comment-ids" class="form-control input-md" type="text">
            </div>
          </div>
          
                    <!-- Password input-->
          <div class="form-group">
            <label class=" control-label" for="passwordinput">Scientist-id</label>
            <div class="">
              <input id="scientistId" name="scientistId" placeholder="Scientist-id" class="form-control input-md" type="text">
            </div>
          </div>
          
                    <!-- Password input-->
          <div class="form-group">
            <label class=" control-label" for="passwordinput">Domain-id</label>
            <div class="">
              <input id="domainIds" name="domainIds" placeholder="Domain-ids" class="form-control input-md" type="text">
            </div>
          </div>

          <!-- Textarea -->
          <div class="form-group">
            <label class=" control-label" for="textarea">Content</label>
            <div class="">                     
              <textarea class="form-control" id="content" name="content">default content: no french accents</textarea>
            </div>
          </div>
		  
		  <!-- <input type="submit" value="ajouter idée"> -->
		   <button type="button" name="valider"  onclick="newIdea_Ajax();">Valider</button>
		   
        </fieldset>
      </form>
    </div>
    <div class="clearfix"></div>
  </div>
  
  </body>
</html>