<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, th, td, tr {
    border: 1px solid black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="bootstrap.min.css" rel="stylesheet">
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
<h3>Hi <%=userName %>, Login successful. Your Session ID=<%=sessionID %></h3>
<script src=domain.js></script>
<button type="button" onclick="traitementAjax()">API meteo</button>
<p id="demo"></p>
</body>
</html>