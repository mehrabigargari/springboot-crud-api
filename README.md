🧩 Spring Boot CRUD REST API
A simple CRUD (Create, Read, Update, Delete) RESTful API built using Spring Boot and Maven.
This project demonstrates basic REST architecture principles, error handling, and service-layer abstraction in Java with Spring.

🚀 Features
Create, read, update, and delete user entities
RESTful endpoints with proper HTTP methods
Exception handling using @ControllerAdvice
Maven-based dependency management
MySQL database support
Follows a layered architecture (Controller → Service → Repository)

🛠️ Tech Stack
Java 17+
Spring Boot 3.x
Spring Web
Spring Data JPA
Maven for build management


|  Method  |      Endpoint       |     Description      |
| -------- | ------------------- | -------------------- |
| `GET`    | `/api/members`      | Get all users        |
| `GET`    | `/api/members/{id}` | Get user by ID       |
| `POST`   | `/api/members`      | Create a new user    |
| `PUT`    | `/api/members/{id}` | Update existing user |
| `DELETE` | `/api/members/{id}` | Delete a user by ID  |
