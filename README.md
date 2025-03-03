# Ximple Library Challenge

### Requirements
* Java 21
* Docker
* Maven 3.X

### Resources

* [Postman collection](Ximple%20library.postman_collection.json)
* [Local health check](http://localhost:8080/actuator/health)
* [Local Swagger](http://localhost:8080/swagger-ui/index.html)

### How to run the project


Use the next command to run a database using docker, the required authentication details are included in the `docker-compose.yml` file
`docker-compose up -d`

Before running compile the project since it uses auto generated sources
`mvn clean compile`

Tu run the project use
`mvn spring-boot:run`

You can check that the service is running by accessing to the [health check](http://localhost:8080/actuator/health)

The project uses flyway so the required tables and some test data will be added to the mysql database






