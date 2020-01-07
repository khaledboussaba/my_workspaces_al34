var divRes;
var divMessage;

window.onload=function() {
	var inputChangeMini = document.getElementById("txtChangeMini");
	var btnGetDevises = document.getElementById("btnGetDevises");
	var btnPostDevise = document.getElementById("btnPostDevise");
	divRes = document.getElementById("divRes");

	btnGetDevises.addEventListener("click", ()=> {
		var changeMini = inputChangeMini.value;
		makeAjaxGetRequest("./devise-api/public/devise?changeMini="+changeMini, callbackGererResultat);
	});
	
	btnPostDevise.addEventListener("click", ()=> {
		var nouvelleDevise = {
				code : null,
				name : null,
				change : null
		}
		nouvelleDevise.code = document.getElementById("txtCode").value;
		nouvelleDevise.name = document.getElementById("txtName").value;
		nouvelleDevise.change = document.getElementById("txtChange").value;
		makeAjaxPostRequest("./devise-api/public/devise", JSON.stringify(nouvelleDevise), callbackGererResultatPost);
	});
	
}

function callbackGererResultatPost(texteReponse) {
	divMessage = document.getElementById("divMessage");
	divMessage.innerHTML = texteReponse;
}

function callbackGererResultat(texteReponse) {
	//divRes.innerHTML = texteReponse;
	var listeDevisesJs = JSON.parse(texteReponse);
	var htmlListeDevises = "<ul>";
	for(i=0; i< listeDevisesJs.length; i++) {
		htmlListeDevises = htmlListeDevises + "<li>" + listeDevisesJs[i].name + " , " + listeDevisesJs[i].change + "</li>"; 
	}
	htmlListeDevises = htmlListeDevises + "</ul>";
	divRes.innerHTML = htmlListeDevises;
}

function makeAjaxGetRequest(url, callback) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
			callback(xhr.responseText);
		}
	};
	xhr.open("GET", url, true);
	xhr.send(null);
}

function makeAjaxPostRequest(url, jsonData, callback) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
			callback(xhr.responseText);
		}
	};
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.send(jsonData);
}
