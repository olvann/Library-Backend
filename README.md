# Ximple Library Challenge

### Requirements
* Java 21
* Docker
* Maven 3.X

### Resources

* [Collection to test the service](https://)
* [Local health check](http://localhost:8080/actuator/health)
* [Local Swagger](http://localhost:8080/swagger-ui/index.html)

### How to run the project


Use the next command to run a database using docker, with the required authentication details is already in the project
`docker-compose up -d`

Before running compile the project since it uses auto generated sources
`mvn clean compile`

Tu run the project use
`mvn spring-boot:run`

You can check that the service is running by accesing to the [health check](http://localhost:8080/actuator/health)






