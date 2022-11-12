# My Device Manager API
RestAPI developed in Java with SpringBoot to management devices

# Requirements
- [x] Add device
- [x] Get device by identifier
- [x] List all devices
- Update device (full and partial)
  - [x] Full
  - [x] Partial
- [x] Delete a device
- [x] Search device by brand

# Starters/Libraries Added
* H2 Database: use in-memory database to this test
* Spring Web: use for Spring Rest MVC
* Spring Boot Dev tools: to provide fast application restarts and reloads on Dev environment
* Spring Data JPA: use to connect on SQL databases
* Lombok: Helper to reduce boilerplate code
* Spring Security: use to add some level of security to the API
* ModelMapper: Used to mapper DTO to Entity objects

# Note
### Layers and responsibilities
To design this project, It could be call the Controller functions direct to Repository, but to separate all responsibilities, was adopted to create a Service layer between both.
List off folders below:
- Controllers
- Models
- Repository
- Service
- Exception
- Dto
- Converter

### PUT and PATCH methods:
For this service was used the diferences of HTTP methods PUT (to replace all content of a object) and PATCH (To change a partial data object).

References:
PUT: https://www.rfc-editor.org/rfc/rfc2616#page-55
PATCH: https://www.rfc-editor.org/rfc/rfc5789

Of course, another way is map the object body and check the existence of this contents, then update only the new contents and use the PUT method to make this two responsibilities, but this approach is not implemented to improve for a real RESTFUL pattern.

# Future Work
- [x] Add pagination and limits on findAll methods
- [x] Transform findByBrand to return with pagination and limits
- [x] Add correct answers to user on delete methods
- [x] Add logic to check duplicated names on save method
- [x] Add DTO to controllers
- [x] Add Swagger to entry points
- [x] Add a minimal security policy
- [x] Add custom exception treatments for endpoints
- [x] Test constructors of Entity
- [x] Apply Validation on Controllers endpoints
- [ ] Add Hateoas to controllers



### Sonar Lint attempted on this project
- [x] Persistent entities should not be used as arguments of "@RequestMapping" methods
  * Ref: https://rules.sonarsource.com/java/tag/spring/RSPEC-4684


# Swagger
Local endpoint: http://localhost:8080/swagger-ui/index.html


# Postman Collections
Collection [Download link](./collection/MyDeviceManagerAPI.postman_collection.json)