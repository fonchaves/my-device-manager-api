# my-device-manager-api
RestAPI developed in Java with SpringBoot to management devices

# Starters Added
* H2 Database: use in-memory database to this test
* Spring Web: use for Spring Rest MVC
* Spring Boot Dev tools: to provide fast application restarts and reloads on Dev environment
* Spring Data JPA: use to connect on SQL databases
* Lombok: Helper to reduce boilerplate code
<!-- * Spring Security: use to add some level of security to the API -->

# Note
To design this project, It could be call the Controller functions direct to Repository, but to separate all responsibilities, was adopted to create a Service layer between both.
List off folders below:
- Controllers
- Models
- Repository
- Service

# Future Work
- [ ] Add pagination and limits on findAll methods


