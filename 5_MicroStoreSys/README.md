# Welcome to MicroStoreSys! 

This software is a simplification of a sales system implemented using Java, Spring framework (boot, data), whose the main goal is to create microservices that are able to handle entities elicited afterwards. Henceforth, this repository document an elegant and modern solution to solve business rules presented in this document. For this, we will be using the following technologies:

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/rabbitmq-%23FF6600.svg?&style=for-the-badge&logo=rabbitmq&logoColor=white)


Note: A memory database is used (h2 database), lombok is also used to reduce getters and setters. 


## System Overview

This system manage four entitities: 

1. customers
2. products
3. orders
4. address
5. deliveries

These entities are composed by the following attributes:

![image](https://user-images.githubusercontent.com/13739735/197055067-3f5a8b74-067d-409a-b9d4-a91718efe721.png)


## ⚙️ Development

This system is currently under construction and will be developed iteratively following X sprints that are described as it follows:

### Sprint 01 - API building

In this sprint, OrderSys will be configured as a maven project using start.spring.io using the following dependencies:

1. Spring Data JPA
2. Spring Boot DevTools
3. H2 Database
4. Spring for RabbitMQ
5. Lombok

Next, the following endpoints should be created:

#### For Customers
- GET - localhost:9000/cliente/lista - List all stored clients
- GET - localhost:9000/cliente/{id} - Display client with such id
- POST - localhost:9000/cliente/ - Add a client
- PUT - localhost:9000/cliente/ - Update or add a client
- DELETE - localhost:9000/cliente/{id} - delete client with such id

#### For Products
- GET - localhost:9000/produto/lista - List all stored products
- GET - localhost:9000/produto/{id} - Display product with such id
- POST - localhost:9000/produto/ - Add a product
- PUT - localhost:9000/produto/ - Update or add a product
- DELETE - localhost:9000/produto/{id} - delete product with such id

#### For Orders
- GET - localhost:9000/pedido/list - List all stored orders
- GET - localhost:9000/pedido/{id} - Display order with such id
- POST - localhost:9000/pedido/ - Add a order
- PUT - localhost:9000/pedido/ - Update or add a order

#### For Deliveries
- GET - localhost:9000/entrega/lista - List all stored deliveries
- GET - localhost:9000/entrega/{id} - Display delivery with such id


For testing these end points, use the following payloads:

Client: 
```json
{
  "idClient": 0,
  "clientName": "Name Client"
}
```


Product: 
```json
{
  "idProduct": 0,
  "productName": "Name Product",
  "productValue": "10.00"
}
```

Order: 
```json
{
    "client": {
        "id": 1,
        "name": "Vinicius dos Santos"
    },
    "products": [
        {
            "id": 1,
            "name": "Casa de papel",
            "value": 10.0
        }
    ],
    "address": {
        "street": "Serafim vieira dos santos",
        "stablishmentNumber": 777,
        "neighborhood": "Primavera 7",
        "complement": "Apto 22",
        "zipCode": "35825-000"
    }
}
```

Deliveries: 
```json
{
    "status": "Entregue",
    "deliveredIn": "1990-10-22",
    "receiver": "Vanessa",
    "idOrder": 1
}
```

### Sprint 02 - RabbitMQ integration

RabbitMQ should be implemented as simply as possible, for this, you I've configured it to create a queue. In controller, I've send a message to that queue, next a consumer was built to receive messages from the queue and print them to the terminal.


### Sprint 03 - Docker

Since this application only requires RabbitMQ installed and running. This systems uses the following script to download and run this container:

```
services:
  rabbitmq:
    image: rabbitmq:3.11-management
    container_name: rabbitmq
    restart: always
    ports:
      - 5672:5672
      - 15672:15672
    volumes: 
      - .dados:/var/lib/rabbitmq/
    environment: 
      - RABBITMQ_DEFAULT_USER=admin
      - RABBITMQ_DEFAULT_PASS=123456
```
