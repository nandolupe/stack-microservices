# Golang and Eureka Service Register

#### Description

*   Create with Golang
*   Plugins: toml, mgo.v2, mux, go-eureka-client
*	Register on Eureka 


#### first steps

```shell
    create database on mongodb -> golang-db

    create collection on mongodb -> beneficiario
```

#### API Run

```shell
    
    export GOPATH=/home/luiz/stack-microservices/microservices/go/
	
    go get github.com/BurntSushi/toml gopkg.in/mgo.v2 github.com/gorilla/mux github.com/ArthurHlt/go-eureka-client/eureka


```

#### Data Examples

Data to persistence

##### ENDPOINT

```shell
    http:/localhost:3000/beneficiario
```

##### FINDALL (GET)

```shell
    no body content	
```
	
##### SAVE (POST)


```shell
    {
      "Nome": "LUIZ PEREIRA",
      "sexo": "M",
      "Estado": "SP",
      "active": true
    }
```

##### UPDATE (PUT)


```shell
    {
      "Nome": "LUIZ PEREIRA",
      "sexo": "M",
      "Estado": "SP",
      "active": true
    }
```

##### REMOVE (DELETE)


```shell
    no body content
```
