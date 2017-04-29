<%@page import="java.util.List"%>
<%@page import="beans.idea"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <title>Partage d'idee</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
  <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">Projet SR03</a>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">iOS</a></li>
            <li><a href="#">SVN</a></li>
            <li class="dropdown">
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
            </li>
        </ul>
    </div>
    </div>
</nav>

<div class="container">
  <div class="jumbotron">
    <h1>Partage d'idee</h1>
    <p>DISCUSSIONS ET PARTAGES D'IDEES PARMI LES CHERCHEURS</p> 
  </div>

</div>


<table border="1">
<!--  
<tr>
	<th>ID</th>
	<th>
		<a href="GestionIdeas?action=sort">NOM</a>
	</th>
	<th>TEL</th>
	<th>USERNAME</th>
	<th>ACTIONS</th>
</tr>
-->

<a href="GestionIdeas">Id</a>
	<%
		Object obj = request.getAttribute("listeIdeas");
		if(obj!=null){
			List<idea> lu = (List<idea>)obj;
			//List<idea> lu = obj;
			for(idea u : lu){
	%>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getTitle()%></td>
				<td><%=u.getContent()%></td>
				<td><%=u.getCreatedAt()%></td>
				<td><%=u.getCommentIds()%></td>
				<td><%=u.getScientistId()%></td>
				
			<!--  	<td>
					<a href="GestionUsers?action=supprimer&id=<%=u.getId()%>">Supprimer</a>
					<a href="GestionUsers?action=modifier&id=<%=u.getId()%>">Modifier</a>	
				</td>
			-->	
				
				
			</tr>
	<%
			}
			
			
		}
	%>
</table>




</body>
</html>
