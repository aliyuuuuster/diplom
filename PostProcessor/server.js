const express = require('express');
const app = express();
const bodyParser = require('body-parser').json();

require('./app/routes')(app, bodyParser);

app.listen(9000);
console.log('Server starter at http://localhost:9000');