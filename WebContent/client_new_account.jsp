<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="ideas.css">
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script type="text/javascript" src="login.js"> </script>
	<title>New account</title>
</head>

<body>
	<div class="container auth">
	 <div id="big-form" class="well auth-box">
		 <form name = "newAccount" method="post" action="AccountServlet">
		 <input type="hidden" name="formType" id="formType" value="newAccount">
		 	<fieldset>
		 	 <!-- Form Name -->
		 	<legend>Créer une nouvelle Compte </legend>
		 	
		 	<!-- Name input-->
		 	<div class="form-group">
		 	<label class=" control-label" for="passwordinput">Name</label>
		 		<input id="newName" name="newName"  class="form-control input-md" type="text">
		 	</div>
			
			<!-- "password-->
	        <div class="form-group">
	        	<label class=" control-label" for="password">Password</label>
	        	<div class="">
	              <input id="newPassword" name="newPassword" class="form-control input-md" type="password">
	            </div>
	        </div>
		 	
		 	<!-- Domaine id -->
		 	<div class="form-group">
		 		<label class=" control-label" for="domaineId">Domaine ID</label>
		 		<div class="">
		 			<input id="domain_ids" name="domain_ids" class="form-control input-md" type="text">
		 		</div>
		 	</div>
		 	
		 	<!-- submit -->
		 	<button type="button" name="valider"  onclick="createNewAccount_Ajax();">Valider</button>
		 	
		 	</fieldset>
		 </form>
	 </div>
	 </div>
</body>
</html>