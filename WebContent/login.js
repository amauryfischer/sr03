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
	
}



