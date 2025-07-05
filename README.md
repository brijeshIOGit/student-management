# Student Management System API

A Spring Boot application demonstrating fundamental backend development concepts, including RESTful API design, database interaction with Spring Data JPA and MySQL, relationship mapping, data validation, and global exception handling. This project serves as a practical learning ground for core Spring Boot features.

## Table of Contents

* [Features](#features)
* [Technologies Used](#technologies-used)
* [Concepts Learned](#concepts-learned)
* [Getting Started](#getting-started)
    * [Prerequisites](#prerequisites)
    * [Clone the Repository](#clone-the-repository)
    * [Database Setup](#database-setup)
    * [Application Configuration](#application-configuration)
    * [Run the Application](#run-the-application)
* [API Endpoints](#api-endpoints)
    * [Courses](#courses)
    * [Students](#students)
* [Future Enhancements](#future-enhancements)
* [Contributing](#contributing)
* [License](#license)

## Features

This project implements the following functionalities:

* **Student Management:**
    * Create, Read, Update, Delete (CRUD) student records.
    * Associate students with a specific course (Many-to-One relationship).
    * Retrieve students by their associated course.
    * Input validation for student data (name, age, email).
* **Course Management:**
    * Create, Read, Update, Delete (CRUD) course records.
    * Input validation for course data (title, credit hours).
* **RESTful API:** Exposes well-defined REST endpoints for all operations.
* **Global Exception Handling:** Centralized error handling for consistent API responses (e.g., 404 Not Found, 400 Bad Request for validation errors).
* **Lombok Integration:** Reduces boilerplate code for getters, setters, constructors, etc.

## Technologies Used

* **Java 17+**
* **Spring Boot 3.x**
* **Spring Data JPA**
* **Hibernate** (JPA Implementation)
* **MySQL** (Relational Database)
* **Lombok**
* **Maven** (Build Tool)
* **Postman / Insomnia** (for API Testing)

## Concepts Learned

This project provides hands-on experience with crucial Spring Boot and Java concepts, making it excellent for interview preparation:

* **Spring Initializr:** Project bootstrapping.
* **Maven/Gradle Dependency Management:** Understanding `pom.xml` and common Spring Boot starters (`spring-boot-starter-web`, `spring-boot-starter-data-jpa`, `mysql-connector-java`, `lombok`).
* **RESTful API Design:** Principles of REST, HTTP methods (GET, POST, PUT, DELETE), and status codes (200, 201, 204, 400, 404, 500).
* **Spring MVC (`@RestController`, `@RequestMapping`, `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`):** Building REST controllers.
* **Dependency Injection (`@Autowired`):** Spring's core mechanism for managing component dependencies.
* **Service Layer (`@Service`):** Separating business logic from controllers.
* **Data Persistence with JPA:**
    * **Entities (`@Entity`, `@Table`):** Mapping Java objects to database tables.
    * **Primary Keys (`@Id`, `@GeneratedValue`):** Defining unique identifiers.
    * **Relationships (`@ManyToOne`, `@JoinColumn`):** Modeling associations between entities. Understanding `FetchType.LAZY` vs. `EAGER`.
    * **Spring Data JPA Repositories (`JpaRepository`):** Simplified data access with CRUD operations and custom query methods (e.g., `findByCourse`).
* **Data Validation (`jakarta.validation`, `@Valid`, `@NotBlank`, `@Min`, `@Email`):** Ensuring data integrity.
* **Global Exception Handling (`@ControllerAdvice`, `@ExceptionHandler`):** Centralized and consistent error responses.
* **Lombok (`@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`):** Reducing boilerplate code.
* **`application.properties`:** Externalized configuration for database connections and other application settings.

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine.

### Prerequisites

* **Java Development Kit (JDK) 17+**
* **Apache Maven**
* **MySQL Server** (or a Docker environment with MySQL)
* An IDE like **IntelliJ IDEA**, **Eclipse (with STS)**, or **VS Code** with Java extensions.
* **Lombok Plugin** installed in your IDE (and annotation processing enabled).

### Clone the Repository

```bash
git clone https://github.com/brijeshIOGit/student-management.git
cd student-management
```
### SQL

```bash
CREATE DATABASE student_db;
USE student_db;
```

### application.properties

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/student_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate properties
spring.jpa.hibernate.ddl-auto=update # Use 'create' for first run to auto-create tables, then 'update'
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```