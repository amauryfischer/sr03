<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Partage idee - login</title>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<link rel="stylesheet" type="text/css" href="login.css">
	<script type="text/javascript" src="cookies.js"> </script>
	<script type="text/javascript">
		var userName;
		var password;

		//function qui permet de retrouver des infos dans cookies
		function greetUser(){
			if(navigator.cookieEnabled){
				userName = readCookie("ideePartage_userName");
				password = readCookie("ideePartage_password");
				
			}
			
			if(userName){
				document.getElementById("login").value=userName;
			}else{
				document.getElementById("login").value="login";
			}
			if(password){
				document.getElementById("password").value=password;
			}else{
				document.getElementById("password").value="password";
			}
		}

		//function qui permet de mettre a jour des infos dans cookies
		function msjCookie(){
			userName=document.getElementById("login").value;
			password=document.getElementById("password").value;
			
			if(navigator.cookieEnabled){
				//writeCookie: la nom de l'info, contenu, jours rester dans cookie
				writeCookie("ideePartage_userName", userName, 10);
				writeCookie("ideePartage_password", password, 10);
			}
			
		}
	</script>
</head>

<body onload="greetUser();">
	<div class="container">
	  
	  <div class="row" id="pwd-container">
	    <div class="col-md-4"></div>
	    
	    <div class="col-md-4">
	      <section class="login-form">
	        <form method="post" role="login" action="AccountServlet" >
	          <img src="http://i.imgur.com/RcmcLv4.png" class="img-responsive" alt="" />
	          <input type="hidden" name="formType" id="formType" value="signIn">
	          <input type="text" name="login" id="login" placeholder="Email" required class="form-control input-lg"  />
	          
	          <input type="password" name="password" class="form-control input-lg" id="password" placeholder="Password" required="" />
	                   
	          <div class="pwstrength_viewport_progress"></div>
	          
	          <button type="submit" name="go" class="btn btn-lg btn-primary btn-block" onclick="msjCookie();">Sign in</button>
	          <div>
	            <a href="new_account.jsp">Create account</a> <!-- or <a href="#">reset password</a> -->
	          </div>
	          
	        </form>
	        
	        <div class="form-links">
	          <a href="#">www.website.com</a>
	        </div>
	      </section>  
	      </div>
	      
	      <div class="col-md-4"></div>
	      
	
	  </div>
	  
	  <p>
	    <a href="http://validator.w3.org/check?uri=http%3A%2F%2Fbootsnipp.com%2Fiframe%2FW00op" target="_blank"><small>HTML</small><sup>5</sup></a>
	    <br>
	    <br>
	    
	  </p>     
	  
	  
	</div>

</body>
</html>