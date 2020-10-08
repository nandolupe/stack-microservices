# Python with Docker image and Eureka Service Register

#### Description

*   Create with Python3
*   Plugins: Flask, pymongo and others
*	Register on Eureka 


#### first steps

```shell
create database on mongodb -> beneficiario-db

create collection on mongodb -> beneficiario
```

#### API Run

```shell
	pip3 install -r requirements.txt
	
	python3 BeneficiarioAPI.py
```

#### Docker Build/Run

```shell
	docker build -t beneficiario-python 
	
	docker run -p 5001:5001 beneficiario-python
	
```

#### Data Examples

Data to persistence

##### FINDALL (GET)

```shell
{
  "database": "beneficiario-db",
  "collection": "beneficiario"
}
	
```
	
##### SAVE (POST)


```shell
{
  "database": "beneficiario-db",
  "collection": "beneficiario",
  "Document": {
    "dataNascimento": "13/02/1985",
    "nomeBeneficiario": "PEDRO MANUEL SILVA",
    "sexo": "M"
  }
}
```

##### UPDATE (PUT)


```shell
{
  "database": "beneficiario-db",
  "collection": "beneficiario",
  "Filter": {
    "dataNascimento": "13/02/1989",
    "nomeBeneficiario": "LUIZ FERNANDO PEREIRA",
    "sexo": "M"
  },
  "DataToBeUpdated": {
    "dataNascimento": "13/02/1989",
    "nomeBeneficiario": "LUIZ FERNANDO PEREIRA",
    "sexo": "M",
    "estado": "SP"
  }
}
```

##### REMOVE (DELETE)


```shell
{
  "database": "beneficiario-db",
  "collection": "beneficiario",
  "Filter": {
    "dataNascimento": "13/02/1985",
    "nomeBeneficiario": "PEDRO MANUEL SILVA",
    "sexo": "M"
  }
}
```