### How to use this spring-boot project

- Install packages with `mvn package`
- Run `mvn spring-boot:run` for starting the application (or use your IDE)

Application (with the embedded H2 database) is ready to be used ! You can access the url below for testing it :

- Swagger UI : http://localhost:8080/swagger-ui.html
- H2 UI : http://localhost:8080/h2-console

> Don't forget to set the `JDBC URL` value as `jdbc:h2:mem:testdb` for H2 UI.



### Instructions

- download the zip file of this project
- create a repository in your own github named 'java-challenge'
- clone your repository in a folder on your machine
- extract the zip file in this folder
- commit and push

- Enhance the code in any ways you can see, you are free! Some possibilities:
  - Add tests
  - Change syntax
  - Protect controller end points
  - Add caching logic for database calls
  - Improve doc and comments
  - Fix any bug you might find
- Edit readme.md and add any comments. It can be about what you did, what you would have done if you had more time, etc.
- Send us the link of your repository.

#### Restrictions
- use java 8


#### What we will look for
- Readability of your code
- Documentation
- Comments in your code 
- Appropriate usage of spring boot
- Appropriate usage of packages
- Is the application running as expected
- No performance issues

#### Your experience in Java

- I have 10 years experience in Java and I started to use Spring Boot from last 2 years.
- I have worked on Core and Advanced Java for more than 9 years.
- I'm a beginner and just recently learned Spring Boot.
- I know Spring very well and have been using it for many years.
- I have worked on multiple projects automation. Like Release automation, Health check system, Transaction status across the systems, Online system delayed transactions check, Automated alert upon system memory check, Automated alert and UI for End Of Day execution.
- I am handing handling Infra team and its operations in current project. This includes clustered Weblogic setup/deployment/release automation/datasource setup/ Queues setup/Queues configuration/weblogic configuration/ Server startup parameters/ Oracle 19C Database multitanent setup/ deployemnts/ automation of deployments on 9 AWS environments. All the automation and setup is done through Core java and other tools. 
- I am working on micro-service developments and tools development like Calendar upload and Customer Signature enhancements.
- I have worked on in API(SOAP and REST) developments and for more than 3 years.

#### Changes comments
Employee : Move Lombok annotations to class level.
EmployeeServiceImpl: Method getEmployee() changed the return to null when value is not present.
EmployeeController: Added comments to each method.
EmployeeControllerTest: New class for JUNIT testing. Added method for all EmployeeController methods.
EmployeeController: saveEmployee changed return type to ResponseEntity<Employee> and made changes accordingly within the method. 