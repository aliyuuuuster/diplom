const processRoutes = require('./process_routes');

module.exports = function (app, bodyParser) {
    processRoutes(app, bodyParser);
}