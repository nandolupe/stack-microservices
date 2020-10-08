# Python with Docker image

#### Description

*   Create with Python3
*   Plugins: Flask, pymongo and others


#### first steps

```shell
create database on mongodb -> python-teste-db

create colleciton on mongodb -> people
```

#### API Run

```shell
	pip3 install -r requirements.txt
	
	python3 MongoAPI.py
```

#### Docker Build/Run

```shell
	docker build -t python-with-mongo-db
	
	docker run -p 5001:5001 python-with-mongo-db
	
```

#### Data Examples

Data to persistence

##### FINDALL (GET)

```shell
{
  "database": "python-teste-db",
  "collection": "people"
}
	
```
	
##### SAVE (POST)


```shell
{
  "database": "python-teste-db",
  "collection": "people",
  "Document": {
    "first_name": "John",
    "last_name": "Coleman"
  }
}
```

##### UPDATE (PUT)


```shell
{
  "database": "python-teste-db",
  "collection": "people",
  "Filter": {
    "first_name": "John",
    "last_name": "Coleman"
  },
  "DataToBeUpdated": {
    "first_name": "John",
    "last_name": "Coleman"
  }
}
```

##### REMOVE (DELETE)


```shell
{
  "database": "python-teste-db",
  "collection": "people",
  "Filter": {
    "first_name": "John",
    "last_name": "Coleman"
  }
}
```