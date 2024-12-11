## Dependencies
- Spring Web: build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded.
- Spring Data JPA:
- Lombok:
- PostgreSQL database

## Setup
- `mvn clean install`
- `docker compose up`
- `mvn spring-boot:run`

### clean db
- `docker compose down`
- `docker compose down --volumes`: removes the volume
- `docker rmi postgres:latest`



## Directories and their responsabilities
- client: to interact with `external` APIs and microservices.
- config: store application classes.

- controller: handles incoming http requests.
- dto: defines structures for transfering data between layers.
- factory: helper classes to build/convert object, often transforming entities into DTOs and vice versa.

- model: structre of your database entities (mapped to database tables).
- respository: responsible for interacting directly with the db.


## Test Curls
### Crete User
```
curl -X POST http://localhost:8080/v1/user-info/create -H "Content-Type: application/json" -d '{
  "name": "John Doe",
  "active": true,
  "email": "johndoe@example.com",
  "secondEmail": "johndoe2@example.com"
}'
```
reponse:
```
true
```

### Look by email
```
curl -X GET "http://localhost:8080/v1/user-info/user-info-by-email?email=johndoe@example.com"
```
response:
```
{"id":1,"name":"John Doe","active":true,"createAt":"2024-12-11T23:02:28.663+00:00","email":"johndoe@example.com","secondEmail":"johndoe2@example.com"}
```
