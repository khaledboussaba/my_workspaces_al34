var express = require('express');
var app = express();

// CORS enabled with express/node-js :
app.use(function(req, res, next) {
 res.header("Access-Control-Allow-Origin", "*");
 //ou avec "www.xyz.com" à la place de "*" en production
 res.header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
 next();
});

// GET http://localhost:8686/api-banque/tauxInteretCourant?nbMois=120
app.get('/api-banque/tauxInteretCourant', (req, res, next) => {
  var nbMois = Number(req.query.nbMois); // 120 pour 10 ans
  var tauxAnnuelPct;

  if (nbMois < 12) {
    tauxAnnuelPct = 1.1;
  }
  if (nbMois >= 12 && nbMois < 60) {
    tauxAnnuelPct = 0.8;
  }
  if (nbMois >= 60) {
    tauxAnnuelPct = 0.7;
  }

  var objDataRes = {
    nbMois : nbMois,
    tauxAnnuelPct : tauxAnnuelPct,
  };
  res.send(objDataRes);
});

app.listen(8686, () => {
  console.log('http://localhost:8686');
});
