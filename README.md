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
