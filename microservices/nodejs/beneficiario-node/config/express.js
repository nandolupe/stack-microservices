//import Eureka from 'eureka-js-client';

const express    = require('express');
const bodyParser = require('body-parser');
const config     = require('config');
const consign    = require('consign');
const Eureka = require('eureka-js-client').Eureka;

const eureka = new Eureka({
  instance: {
    app: 'beneficiario-node',
    hostName: 'localhost',
    ipAddr: '127.0.0.1',
    statusPageUrl: 'http://localhost:8090',
    port: {
      '$': 5000,
      '@enabled': 'true',
    },
    vipAddress: 'localhost',
    dataCenterInfo: {
      '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
      name: 'MyOwn',
    }
  },
  eureka: {
    host: 'localhost',
    port: 8761,
    servicePath: '/eureka/apps/'
  }
});
eureka.logger.level('debug');
eureka.start(function(error){
  console.log(error || 'complete');
});

module.exports = () => {
  const app = express();

  // SETANDO VARIÁVEIS DA APLICAÇÃO
  app.set('port', process.env.PORT || config.get('server.port'));

  // MIDDLEWARES
  app.use(bodyParser.json());

  // ENDPOINTS
  consign({cwd: 'api'})
    .then('data')
    .then('controllers')
    .then('routes')
    .into(app);

  return app;
};



