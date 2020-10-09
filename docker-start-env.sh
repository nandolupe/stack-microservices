#!/bin/bash
# Script para subir o ambiente da stack quando reiniciado o servidor

echo INICIALIZANDO AMBIENTE 

echo SUBINDO CONFIG-SERVER

docker run --rm -p 8888:8888 -e JAVA_OPTS='-Xmx128m -Xms128m' -m 200m --network integration --hostname config-server --name config-server -d config-server:1.0.0

echo CONFIG-SERVER INICIALIZADO COM SUCESSO

echo SUBINDO EUREKA

docker run --rm -p 8761:8761 -e JAVA_OPTS='-Xmx128m -Xms128m' -m 200m --network integration --hostname eureka-server --name eureka-server -d eureka-server:1.0.0

echo EUREKA INICIALIZADO COM SUCESSO

echo SUBINDO ZUUL

docker run --rm -p 8762:8762 -e JAVA_OPTS='-Xmx128m -Xms128m' -m 200m --network integration --hostname load-balance --name load-balance -d nandolup/zuul-server

echo ZUUL INICIALIZADO COM SUCESSO

echo SUBINDO MONITOR-SERVER

docker run --rm -p 8060:8060 -e JAVA_OPTS='-Xmx128m -Xms128m' -m 200m --network integration --hostname monitor-server --name monitor-server -d monitor-server:1.0.0

echo MONITOR-SERVER INICIALIZADO COM SUCESSO

echo SUBINDO API DE SERVICO DO BENEFICIARIO

docker run --rm -p 8089:8089 -e JAVA_OPTS='-Xmx128m -Xms128m -Dspring.profiles.active=prd' -m 200m --network integration --hostname beneficiario-service --name beneficiario-service -d beneficiario-service:1.0.0

echo API DE SERVICO DO BENEFICIARIO INICIALIZADA COM SUCESSO


docker run --rm -p 8087:8087 -e JAVA_OPTS='-Xmx128m -Xms128m -Dspring.profiles.active=default' -m 200m --network integration --hostname chm-api --name chm-api chm-api:1.0.0

echo TERMINO DE INICIALIZACAO DO AMBIENTE


