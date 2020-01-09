var express = require('express');
var app = express();

// CORS enabled with express/node-js :
app.use(function(req, res, next) {
 res.header("Access-Control-Allow-Origin", "*");
 //ou avec "www.xyz.com" à la place de "*" en production
 res.header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
 next();
});

// GET http://localhost:8585/essai1
app.get('/essai1', (req, res, next) => {
  var objData = {
    ref : 'ref1',
    value : 12
  };
  res.send(objData);
});

// GET http://localhost:8585/api-emprunt/mensualite?montant=2000&nbMois=120&tauxAnnuelPct=1
app.get('/api-emprunt/mensualite', (req, res, next) => {
  var montant = Number(req.query.montant); // 2000 ou ...
  var nbMois = Number(req.query.nbMois); // 120 pour 10 ans
  var tauxAnnuelPct = Number(req.query.tauxAnnuelPct); // 1 pour 1% par an
  var tauxMensuel = tauxAnnuelPct / 100 / 12;
  var mensualite = montant * tauxMensuel / (1 - Math.pow(1.0 + tauxMensuel,-nbMois));
  var objDataRes = {
    montant : montant,
    nbMois : nbMois,
    tauxAnnuelPct : tauxAnnuelPct,
    mensualite : mensualite
  };
  res.send(objDataRes);
});

app.listen(8585, () => {
  console.log('http://localhost:8585');
});

// node server.js pour executer
// http://localhost:8585/essai1

// installer nodeamon pour ne pas restarter node
