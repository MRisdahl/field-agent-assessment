#Field Agent API
## Requirements

_TODO_

## Technical Requirements
* Do not change the database schema. Only Java changes are required.
* Use Spring to make your life easier. Specifically, use as much Spring Testing as possible to save steps.
* Test both data and domain layer components. The @MockBean isn't required for domain testing, but if you don't use it
  you must create a test double. Controller testing isn't strictly required, but try to test at least one HTTP endpoint 
  with a mock web server. It might be interesting to trigger global exception handling.
* Tests must never run against the production database. They run against the test database.

## Tasks
* What are my primary tasks?
* How long do I estimate each of those tasks will take?
* Are there any dependencies between tasks? What order do I need to complete the tasks in?

* [] review supplied code (2hrs)
* [] review Database data (2hrs)
* [] Add Alias model (.25hrs)
* [] Add Alias repository (3hrs)
  * [] add methods
  * [] add test file
  * [] test methods (test after each method)
  * [] add interface
* [] Add Alias Service (3hrs)
  * [] add methods
  * [] add test file
  * [] test methods (use mocking to establish know good state. need to review)
* [] Add Alias Controller (1hr)
  * [] create HTTP requests.  test in vs code
* [] Add missing methods to Security clearance repository (1.5hrs)
  * [] test methods (test after each method)
* [] Add security clearance service file (2hrs)
  * [] add methods
  * [] add test file
  * [] test methods (use mocking to establish know good state. need to review)
* [] Add security clearance controller (1.5hrs)
  * [] create HTTP requests. test in vs code
* [] go through test plan to make sure everything is working (2hrs)

Total time Estimate: 18.25hrs

### Security Clearances
* What classes and methods do I need to add to the project?
* Add SecurityClearanceController - @RestController
* Add SecurityClearanceService
  * Security clearance name is required
  * Name cannot be duplicated.
* For SecurityClearanceJdbcTemplateRepository
  * Add findAll() method
  * Add add() method
  * Add update() method
  * Add deleteById() method
    * What will my strategy be for deleting security clearances?
      * need to prevent a security clearance from being deleted if it's already being used
  
#### HTTP Requests
* What REST API endpoints do I need to define?
* What are the HTTP methods and paths for each endpoint?
* Get http://localhost:8080/security-clearance HTTP/1.1 (findAll)
* Get http://localhost:8080/security-clearance/{securityClearanceId} HTTP/1.1 (findById)
* POST http://localhost:8080/security-clearance HTTP/1.1  (add)
  Content-Type: application/json
  {
  }

* PUT http://localhost:8080/security-clearance/{securityClearanceId} HTTP/1.1  (update)
  Content-Type: application/json
  {
  }
  
* DELETE http://localhost:8080/security-clearance/{securityClearanceId} HTTP/1.1

* What HTTP response status codes and content will each endpoint return to clients?
* What HTTP requests do I need to write to facilitate manual testing of the application?

#### Testing
* What unit tests do I need to write to fully test my new classes?
* What will I do to ensure that my unit tests never run against the production database?
* Do I need to do anything to establish a known good state for my repository unit tests?
  * need to create a DbTestConfig class  and like it to the field_agent_test database

### Aliases
* What classes and methods do I need to add to the project?
* How will I fetch an individual agent with their aliases attached?
  * Look at the one to many relationship between agency and location to figure this out.
* Add Aliase Model
* Add AliaseController - @RestController
* Add AliaseJdbcTemplateRepository
  * Add findAll() method
  * Add findById() method  
  * Add add() method
  * Add update() method
  * Add deleteById() method
* Add AliaseService
  * Name is required
  * Persona is not required unless a name is duplicated. The persona differentiates between duplicate names.
#### HTTP Requests
* What REST API endpoints do I need to define?
* What are the HTTP methods and paths for each endpoint?
* Get http://localhost:8080/aliases HTTP/1.1 (findAll)
* Get http://localhost:8080/aliases/{alias_id} HTTP/1.1 (findById)
* POST http://localhost:8080/aliases HTTP/1.1  (add)
  Content-Type: application/json
  {
  }

* PUT http://localhost:8080/aliases/{alias_id} HTTP/1.1  (update)
  Content-Type: application/json
  {
  }

* DELETE http://localhost:8080/aliases/{alias_id} HTTP/1.1

* What HTTP response status codes and content will each endpoint return to clients?
* What HTTP requests do I need to write to facilitate manual testing of the application?

#### Testing
* What unit tests do I need to write to fully test my new classes?
* What will I do to ensure that my unit tests never run against the production database?
* Do I need to do anything to establish a known good state for my repository unit tests?
  * need to create a DbTestConfig class  and like it to the field_agent_test database

### Global Exception Handling
* How will I implement global error handling?
  * create GlobalExceptionHandler Class in the Controllers package. Use pets or solar panel project as a guide.
* How will I determine the most precise exception to handle when data integrity failures occur?
  * Need to do some research on this one.
  
### Clarification
* Are there any requirements that I need to get clarification on?
* Do I have to do any research?
  * need to research exceptions that handle data integrity failures when they occur.
  * need to review examples from the week to tackle deleting security clearances
  * To fetch an individual agent with their aliases attached I'll need to review the supplied
    code especially the agency and location relationship.
  * need to review how to use mocking.  
* Will I use test doubles or mocking when testing my service classes?
  * I'm going to try and use @Mockbean for my service testing need to review the LMS
* Are there any unknowns? What do I need to do to get clarity?
* How will I review the provided database?
  * Use the database diagram provided and select * queries to get a better understanding of the data
  * Might need to add more data when I start doing tests.
* How will I review the provided code?
  * create http requests in the VS code and provide break points to see how everything is working.

* If I have time, what stretch goals will I implement?
  * If I have time I'll try to implement full HTTP CRUD for mission












