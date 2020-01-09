var express = require('express');
var app = express();

app.get('/essai1', (req, res, next) => {
  var objData = {
    ref : 'ref1',
    value : 12
  };
  res.send(objData);
});

app.listen(8585, () => {
  console.log('http://localhost:8585');
});

// node server.js pour executer
// http://localhost:8585/essai1
