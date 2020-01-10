var express = require('express'); //for exposing REST WS
var app = express();

var axios = require("axios"); //for calling REST WS (http request with Promise)

// CORS enabled with express/node-js :
app.use(function(req, res, next) {
res.header("Access-Control-Allow-Origin", "*");
//ou avec "www.xyz.com" à la place de "*" en production
res.header("Access-Control-Allow-Headers",
"Origin, X-Requested-With, Content-Type, Accept");
next();
});

var apiBanqueBaseUrl ="http://localhost:8686/api-banque";
var apiEmpruntBaseUrl ="http://localhost:8585/api-emprunt";
    
/*
Un objet Promise (normalisé en javascript depuis es2015) et retourné par une
api récente telle que fetch ou axios correspond à un objet technique immédiatement
retourné qui permet d'attendre l'issue (qui sera connue en différé) d'un
traitement asynchrone / non_bloquant .

objPromise.then( (resDiffere) => { ... gestion_resultat ...} )
          .catch( (errDiffere) => { ... gestion erreur ... } );
		  
enchainements possibles via 
appelAsync1(...).then( (resDiff1) => { return appelAsync2(resDiff1); } )
                .then( (resDiff2) => { return appelAsync3(resDiff2); } )
                .then( (resDiff3) => { ...gestion resDiff3 ... } )
				.catch( (err) => {... gestion errDe1_ou_2_ou_3... } );

NB: le mot clef async d'origine c# et intégré en javascript depuis es2017
permet de déclarer une fonction asynchrone dont la valeur de retour sera
automatiquement imbriquée dans un objet "Promise" .
au sein d'une fonction préfixée par async ,l'écriture return data 
est transformée en return new Promise(data) ou Promise.resolve(data) .

NB2: le mot clef await permet d'attendre le retour d'une sous fonction
retournant une Promise (écrite via async ... ou via return new Promise).

NB3: le mot clef await ne peut techniquement être utilisé qu'à l'intérieur
d'une fonction préfixée par async .

et donc (depuis es2017), écriture plus simple (au sein d'une fonction async):
try{
 var resDiff1 = await appelAsync1(...);
 var resDiff2 = await appelAsync2(resDiff1);
 var resDiff3 = await appelAsync3(resDiff2);
 return resDiff3 ou autre;
}cath(err){
	... gestion execption (err de 1,2 ou 3) ...
}

*/	

//fonction utilitaire retournant Promise<data> plutot que Promise<response>	
async function getHttpResponseDataAsPromise(url) {
      try {
        const response = await axios.get(url);
        const data = response.data;
        console.log(data);
		return data;
      } catch (error) {
        console.log(error);
		throw error;
      }
}

//fonction utilitaire pour encapsuler une fonction async 
//au sein d'une route express
function asyncToResp(fn) {
    return function(req, res, next) {
	  //fn is a alias/reference to a async function (returning data in Promise)
      fn(req, res, next)
      .then((data)=> { res.send(data) }) //retour d'un resultat converti en json 
      .catch((err)=>{ 
	      res.status(500)
		      .json({errorCode:'500', message: 'Internal Server Error'})
	  });
    };
}
/*
utilisation:
app.get("fin_url" , asyncToResp( 
                       async  function(req, res,next) {
						   ...;
						   var res1 = await appelAsync1(...);
						   ...;
						   return dataObj; //sera automatiquement transformé en json et renvoyé
					   })
	    );
*/

 // GET http://localhost:8787/orchestrationNode/pret-api/propositionPret?montant=2000&nbMois=120
app.get("/orchestrationNode/pret-api/propositionPret",
  asyncToResp(async  function(req, res,next) {
	var nbMois = Number(req.query.nbMois); // 120 pour 10 ans
	var montant = Number(req.query.montant); 
	
	//debut orchestration (avec ici async/await de es2017 )
	var resTauxInteretCourant = 
	        await getHttpResponseDataAsPromise(apiBanqueBaseUrl 
			    + "/tauxInteretCourant?nbMois=" + nbMois);
	var tauxAnnuelPct = resTauxInteretCourant.tauxAnnuelPct;//donnée pivot
	
	var resCalculMensualite = 
	        await getHttpResponseDataAsPromise(apiEmpruntBaseUrl
			        +"/mensualite?montant="+montant
				    +"&nbMois="+nbMois+"&tauxAnnuelPct="+tauxAnnuelPct);
	var mensualite = resCalculMensualite.mensualite;
	
	var resFraisDossier = 
	        await getHttpResponseDataAsPromise(apiBanqueBaseUrl 
			      + "/fraisDossier?montant="+montant);
	var fraisDossier = resFraisDossier.fraisDossier;
	//fin orchestration
	
	var propositionPret = {
		montant : montant,
		nbMois : nbMois,
		tauxAnnuelPct : tauxAnnuelPct,
		mensualite : mensualite ,
		fraisDossier : fraisDossier
	};
	return propositionPret;
   })
);


app.listen(8787,function () {
	console.log("http://localhost:8787");
});

// node orchestrateur.js
// ou bien 
// npm install nodeamon
// nodeamon orchestrateur.js
