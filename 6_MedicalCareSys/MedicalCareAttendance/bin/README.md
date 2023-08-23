# Welcome to MedicalCareSys! 

This is a very simple system which aims to create several API's using SpringBoot and execute some business logic related to healthcare system. 


## :computer: System Overview

This system manage have two main modules:
1. Medical Care - this module deals with doctors, patients, appointments and examinations.
2. Sales - this module deals with seller, channels, insurance

#### Medical Care module
<div align="center">
<img src="https://user-images.githubusercontent.com/13739735/199307899-43cffd39-af80-4c81-aa18-df3ae8092f83.png" width="500"/>
</div>

#### Sales Module

<div align="center">
<img src="https://user-images.githubusercontent.com/13739735/198321768-f3386db0-cf85-42e4-8116-fec5e470247c.png" width="500"/>
</div>


It is important to mention that this system exchange messages using RabbitMQ to ensure quality. Queues are designed as it follows:

<div align="center">
<img src="https://user-images.githubusercontent.com/13739735/198322962-16304d43-c821-4677-8952-a10e8b5fcc82.png" width="600"/>
</div>



## ⚙️ Development

*Warn: This system is currently under construction and will be developed iteratively.*

### Sprint 01 - API building

In this sprint, we setup Dunimed application using docker to run RabbitMQ and MYSQL. Then, move forward creating a maven project using start.spring.io using the following dependencies:

1. Spring Data JPA
2. Spring Boot DevTools
3. MySQL connectors
4. Spring for RabbitMQ
5. Lombok

The endpoints should be documented using swagger.


## Technologies

- ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
- ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
- ![RabbitMQ](https://img.shields.io/badge/Rabbitmq-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)
- ![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
- ![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
- ![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)

## Testing
- Mockito
- JUnit
- Postman (collections are available)

## Other tools:
 ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
 ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)

