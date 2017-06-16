function getXhr()
{
	var xhr = null; 
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest();
	} // Firefox et autres
	else if(window.ActiveXObject){ // Internet Explorer 
		try {
			xhr = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			xhr = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	else { // XMLHttpRequest non supporté par le navigateur 
		alert("Votre navigateur ne supporte pas les objets XMLHTTPRequest..."); 
		xhr = false; 
	} 
	return xhr
}


function traitementAjax()
{
	//Partie Ajax
	var xhr = getXhr();
	var login = document.getElementById("login").value;
	var password = document.getElementById("password").value;
	var formType = document.getElementById("formType").value;
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//alert(xhr.getResponseHeader('REQUEST_AUTH'));
			if(xhr.getResponseHeader('REQUEST_AUTH') === '2'){
				document.location = '/sr03/client_page_accueil.jsp';
			}else{
				alert("Login ou mot de pass incorrect.");
			}
			} 
	}
	xhr.open("POST","http://localhost:8080/sr03/AccountServlet",true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("formType="+formType+"&login="+login+"&password="+password);
	
}

function createNewAccount_Ajax()
{
	var xhr = getXhr();
	var formType = document.getElementById("formType").value;
	var newName = document.getElementById("newName").value;
	var newPassword = document.getElementById("newPassword").value;
	var domain_ids = document.getElementById("domain_ids").value;
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.location = '/sr03/client_login.jsp';	
		} 
	}
	
	xhr.open("POST","http://localhost:8080/sr03/AccountServlet",true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("formType="+formType+"&newName="+newName+"&newPassword="+newPassword+"&domain_ids="+domain_ids);
}

function logout_Ajax()
{
	//Partie Ajax
	var xhr = getXhr();

	xhr.onreadystatechange = function(){
	
		if(xhr.readyState == 4 && xhr.status == 200){
			document.location = '/sr03/client_login.jsp';
		} 
	}
	xhr.open("GET","http://localhost:8080/sr03/SessionLogout",true);
	xhr.send(null);
}

