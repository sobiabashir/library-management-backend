# Library Management System 📚

A full stack REST API built with Java and Spring Boot for managing 
a library — books, authors, categories, members and borrowing records.

## Tech Stack
- Java 17
- Spring Boot 3
- Spring Data JPA / Hibernate
- H2 In-Memory Database
- Lombok
- Maven
- REST APIs

## Features
- Full CRUD operations for Books, Authors, Categories and Members
- Borrowing and returning books with availability tracking
- DTO pattern — separate Request and Response DTOs
- Entity relationships (OneToMany, ManyToOne)
- H2 Console for database inspection

## Project Structure
- entity — JPA entities (database models)
- dto — Request and Response DTOs
- repository — Spring Data JPA repositories
- service — Business logic layer
- controller — REST API endpoints
- enums — Role and BorrowStatus enums

## How to Run
1. Clone the repository
2. Open in IntelliJ IDEA
3. Run LibraryManagementApplication.java
4. API runs on http://localhost:8080
5. H2 Console at http://localhost:8080/h2-console
