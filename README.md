# Ximple Library Challenge

### Requirements
* Java 21
* Local mysql database
* Maven 3.X

### Resources

* [Collection to test the service](https://)
* [Local health check](http://localhost:8080/actuator/health)
* [Local Swagger](http://localhost:8080/swagger-ui/index.html)

### How to run the project
A local mysql database is required before running
with 
`jdbc = jdbc:mysql://localhost/librarydb,
user = root, 
password = 123456`

alternatively the docker compose file can be used to run the database
`docker-compose up -d`

Before running compile the project since it uses auto generated sources
`mvn clean compile`

Tu run the project use
`mvn spring-boot:run`

You can check that the service is running by accesing to the [health check](http://localhost:8080/actuator/health)






