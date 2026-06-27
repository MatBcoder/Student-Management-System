# Student Management System

A Spring Boot REST API for managing student records. In this version student data is stored in a database and accessed through the Repository layer as requested by the Controller which accepts and sends responses. The endpoints are tested using postman. Other features include sorting, searching for a student using either their names, student numbers or both, also pagination and validation of the student data.
## Features
* data stored in code
* Create Student
* View Students
* Update Student
* Delete Student

## Technologies Used

* Java
* Spring Boot
* Maven
* Postman
* Git
* GitHub

## API Endpoints

### Get All Students

GET /students

### Add Student

POST /students

### Update Student

PUT /students/{id}

### Delete Student

DELETE /students/{id}

## Version 2
### Features
* Data stored in database
* Generating Student numbers
* Searching Students (With student numbres and / names )
* Sorting the Students in order
* Pagination
* Validation
* Global Exception Handling

### Techologies
* Java 25
* Spring Boot
* Maven
* Spring data JPA
* PostgreSQL
* Supabase (database)
* Testing API with Postman

## Future Improvements
* Authentication and Authorisation (Spring Security + JWT)
* Unit testing
* React Frontend (UI)
* Deployment
