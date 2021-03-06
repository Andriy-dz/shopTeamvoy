# Shop

### Postman commands for docker

###### Inject Data:
- Post: localhost:8081/injector

###### Basket:
- Post: localhost:8081/baskets    
  body: {"userId":1}
- Get: localhost:8081/baskets/{id}
- Put: localhost:8081/baskets/{id}
  body: {"userId":1}  
- Delete: localhost:8081/baskets/{id}

###### User:
- Post: localhost:8081/users  
  body: {"name":"Andrew"}
- Get: localhost:8081/users/{id}
- Put: localhost:8081/users/{id}    
  body: {"name":"Andrew"}
- Delete: localhost:8081/users/{id}

###### Shop:
- Post: localhost:8081/shops
  body: {"name":"Shop"}
- Get: localhost:8081/shops/{id}
- Put: localhost:8081/shops/{id}
  body: {"name":"Shop"}
- Delete: localhost:8081/shops/{id}

###### Product:
- Post: localhost:8081/products  
  body: {"name":"Banana", "count":10.0,"price":5.5,"shopId":1}
- Get: localhost:8081/products/{id}
- Put: localhost:8081/products/{id}    
  body: {"name":"Banana", "count":10.0,"price":5.5,"shopId":1}
- Delete: localhost:8081/products/{id}

###### Order:
- Post: localhost:8081/orders  
  body: {"productId":"2", "count":10.0,"basketId":1}:
- Post: localhost:8081/orders/cheapest?name={name}
  body: {"productId":"2", "count":10.0,"basketId":1}
- Get: localhost:8081/orders/{id}
- Put: localhost:8081/orders/confirm/{id}
- Delete: localhost:8081/orders/{id}

## Implementation details and technologies

### Project based on 3-layer architecture:
>- Presentation layer (controllers)
>- Application layer (services)
>- Data access layer (DAO)

### Technologies
>- Spring Boot
>- Spring Boot WEB
>- Spring Boot DATA
>- Hibernate
>- Hibernate validator
>- PostgreSQL
>- JSON
>- Lombok
>- Maven
>- Maven Checkstyle Plugin

### Diagram DB
![drawing](http://dl4.joxi.net/drive/2022/05/04/0052/3292/3415260/60/e67530c2bb.jpg)

## Setup
>1. Configure Apache Tomcat(V - 9.0.55)
>2. Install PostgreSQL(V - 14.0)
>3. In the src/main/resources/application.properties file change properties to the ones you specified when installing PostgreSQL
>4. add TomCat configuration to run project and start

## Setup by docker
Execute commands in the terminal :
- mvn clean package
- docker-compose up
