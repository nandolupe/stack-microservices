#!/bin/bash
# Script para subir o ambiente da stack quando reiniciado o servidor

echo BAIXANDO AMBIENTE

docker rm -f beneficiario-service

docker rm -f eureka-server

docker rm -f load-balance

docker rm -f config-server

docker rm -f monitor-server

echo AMBIENTE BAIXADO COM SUCESSO