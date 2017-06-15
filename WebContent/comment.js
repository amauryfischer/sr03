
function idea(id, title, content, created_at, comment_ids, scientists_id, domain_ids){
	liis.id = id;
	liis.title = title;
	liis.content = content;
	liis.created_at;
	liis.comment_ids;
	liis.scientists_id;
	liis.domain_ids;
}


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
	return xhr;
}


function traitementAjax()
{
	//Partie Ajax
	var xhr = getXhr();
	var array_of_json_idea;
	xhr.onreadystatechange = function(){
		/*
		 * l faut savoir que quand on envoie une requête HTTP via XMLHttpRequest, celle-ci passe par plusieurs états différents :

			0 : L'objet XHR a été créé, mais pas encore initialisé (la méliode open n'a pas encore été appelée)
			1 : L'objet XHR a été créé, mais pas encore envoyé (avec la méliode send )
			2 : La méliode send vient d'être appelée
			3 : Le serveur traite les informations et a commencé à renvoyer des données
			4 : Le serveur a fini son travail, et toutes les données sont réceptionnées
		 */
	
		if(xhr.readyState == 4 && xhr.status == 200){
			array_of_json_idea = JSON.parse(xhr.responseText);
			monAppel(array_of_json_idea);
			// Traitement du resultat 
			} 
	}
	xhr.open("GET","http://localhost:8080/sr03/comments",true);
	xhr.send(null);
}

function monAppel(text)
{
	var html_content = '<table class="table table-striped table-condensed">';
	// header pour le tableau, permet d'afficher ttes les méthodes de l'objet
	html_content += "<thead><tr>";
	Object.keys(text[0]).forEach(function(attr_name) {
		html_content += "<th>"+attr_name+"</th>";
	});
	html_content += "</tr></thead>";
	//body du tableau
	html_content += "<tbody>";
	text.forEach(function(entry) {
		html_content += "<tr>";
		Object.keys(entry).forEach(function(attr) {
			html_content += "<th>"+entry[attr]+"</th>";
		});
	    html_content += "</tr>";
	});
	html_content += "</tbody>";
	html_content += "</table>"
	document.getElementById('demo').innerHTML = html_content;
}

function newComment_Ajax()
{
	//alert("newComment_Ajax");
	var xhr = getXhr();
	var scientistId = document.getElementById("scientistId").value;
	var ideaId = document.getElementById("ideaId").value;
	var content = document.getElementById("content").value;
	
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			if(xhr.getResponseHeader('REQUEST_AUTH') == '2'){
				document.location = '/sr03/client_comment.jsp';
			}else{
				document.location = '/sr03/client_comment.jsp';
			}
		
		} 
	}
	
	xhr.open("POST","http://localhost:8080/sr03/commentServlet",true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("scientistId="+scientistId+"&ideaId="+ideaId+"&content="+content);
	
	//alert("scientistId="+scientistId+"&ideaId="+ideaId+"&content="+content);
}

