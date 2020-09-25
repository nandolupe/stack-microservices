#!/bin/bash
# Script para subir o ambiente da stack quando reiniciado o servidor

echo INICIALIZANDO AMBIENTE 

echo SUBINDO CONFIG-SERVER

docker run -p 8888:8888 -e JAVA_OPTS='-Xmx128m -Xms128m' -m 200m --network integration --hostname config-server --name config-server -d config-server

echo CONFIG-SERVER INICIALIZADO COM SUCESSO

echo SUBINDO EUREKA

docker run -p 8761:8761 -e JAVA_OPTS='-Xmx128m -Xms128m' -m 200m --network integration --hostname eureka-server --name eureka-server -d eureka-server

echo EUREKA INICIALIZADO COM SUCESSO

echo SUBINDO ZUUL

docker run -p 8762:8762 -e JAVA_OPTS='-Xmx128m -Xms128m' -m 200m --network integration --hostname load-balance --name load-balance -d zuul-server

echo ZUUL INICIALIZADO COM SUCESSO

echo SUBINDO MONITOR-SERVER

docker run -p 8060:8060 -e JAVA_OPTS='-Xmx128m -Xms128m' -m 200m --network integration --hostname monitor-server --name monitor-server -d monitor-server

echo MONITOR-SERVER INICIALIZADO COM SUCESSO

echo SUBINDO API DE SERVICO DO BENEFICIARIO

docker run -p 8089:8089 -e JAVA_OPTS='-Xmx128m -Xms128m' -m 200m --network integration --hostname beneficiario-service --name beneficiario-service -d beneficiario-service

echo API DE SERVICO DO BENEFICIARIO INICIALIZADA COM SUCESSO

echo TERMINO DE INICIALIZACAO DO AMBIENTE
