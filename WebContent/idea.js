
function idea(id, title, content, created_at, comment_ids, scientists_id, domain_ids){
	this.id = id;
	this.title = title;
	this.content = content;
	this.created_at;
	this.comment_ids;
	this.scientists_id;
	this.domain_ids;
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

0 : L'objet XHR a été créé, mais pas encore initialisé (la méthode open n'a pas encore été appelée)
1 : L'objet XHR a été créé, mais pas encore envoyé (avec la méthode send )
2 : La méthode send vient d'être appelée
3 : Le serveur traite les informations et a commencé à renvoyer des données
4 : Le serveur a fini son travail, et toutes les données sont réceptionnées
		 */
	
		if(xhr.readyState == 4 && xhr.status == 200){
			array_of_json_idea = JSON.parse(xhr.responseText);
			monAppel(array_of_json_idea);
			// Traitement du resultat 
			} 
	}
	xhr.open("GET","http://localhost:8080/sr03/ideas",true);
	xhr.send(null);
}

function monAppel(text)
{
	text.forEach(function(entry) {
	    console.log(entry);
	});
	document.getElementById('demo').innerHTML = text;
}