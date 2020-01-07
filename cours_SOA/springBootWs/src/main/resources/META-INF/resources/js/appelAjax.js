var divRes;

window.onload=function() {
	var inputChangeMini = document.getElementById("txtChangeMini");
	var btnGetDevises = document.getElementById("btnGetDevises");
	divRes = document.getElementById("divRes");

	btnGetDevises.addEventListener("click", ()=> {
		var changeMini = inputChangeMini.value;
		makeAjaxGetRequest("./devise-api/public/devise?changeMini="+changeMini, callbackGererResultat);
	});
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
