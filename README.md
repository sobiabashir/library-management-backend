# Library Management System — Backend 📚

A secure full stack REST API built with Java and Spring Boot, featuring JWT authentication, role-based access control and email integration.

## 🛠 Tech Stack

- Java 17
- Spring Boot 3
- Spring Security
- JWT Authentication (jjwt 0.11.5)
- BCrypt Password Encoding
- Spring Data JPA / Hibernate
- H2 In-Memory Database
- JavaMailSender (Gmail SMTP)
- Lombok
- Maven

## ✨ Features

- JWT-based login and authentication
- Role-based access control — ADMIN and MEMBER roles
- Full CRUD for Books, Authors, Categories and Members
- Book borrowing and return system with availability tracking
- Forgot password — sends real reset email via Gmail
- Welcome email sent automatically when admin creates a new member
- Password reset via secure token with 1 hour expiry
- DTO pattern — separate Request and Response DTOs
- Entity relationships — OneToMany and ManyToOne
- BCrypt password encoding
- H2 Console for database inspection

## 🔐 API Endpoints

| Method | URL | Access | Description |
|--------|-----|--------|-------------|
| POST | /api/auth/login | Public | Login and get JWT token |
| POST | /api/auth/forgot-password | Public | Request password reset email |
| POST | /api/auth/reset-password | Public | Reset password with token |
| GET | /api/books | ADMIN, MEMBER | Get all books |
| POST | /api/books | ADMIN | Add new book |
| PUT | /api/books/{id} | ADMIN | Update book |
| DELETE | /api/books/{id} | ADMIN | Delete book |
| GET | /api/authors | ADMIN | Get all authors |
| POST | /api/authors | ADMIN | Add new author |
| GET | /api/members | ADMIN | Get all members |
| POST | /api/members | ADMIN | Add new member |
| POST | /api/borrowing/borrow | ADMIN, MEMBER | Borrow a book |
| PUT | /api/borrowing/return/{id} | ADMIN | Return a book |

## 📁 Project Structure
src/main/java/com/sobia/library_management/
├── controller/     — REST API endpoints
├── dto/
│   ├── request/    — Incoming data models
│   └── response/   — Outgoing data models
├── entity/         — JPA database entities
├── enums/          — Role and BorrowStatus enums
├── repository/     — Spring Data JPA repositories
├── security/       — JWT filter, config, UserDetailsService
└── service/        — Business logic layer

## 🗄 Database Schema

| Entity | Fields |
|--------|--------|
| Author | id, firstName, lastName, email |
| Category | id, name |
| Book | id, title, isbn, publishedYear, availableCopies, author, category |
| Member | id, firstName, lastName, email, phone, membershipDate, role, password |
| BorrowingRecord | id, borrowDate, returnDate, status, book, member |

## 👤 Default Users

| Email | Password | Role |
|-------|----------|------|
| sobiaasim2017@gmail.com | Sweet123 | ADMIN |
| sobiabashir_786@hotmail.com | member123 | MEMBER |

## 🚀 How to Run

1. Clone the repository
2. git clone https://github.com/sobiabashir/library-management-backend.git
3. 2. Open in IntelliJ IDEA
3. Update `application.properties` with your Gmail credentials
4. Run `LibraryManagementApplication.java`
5. API runs on `http://localhost:8080`
6. H2 Console at `http://localhost:8080/h2-console`

## 🔗 Frontend Repository

[Library Management System Frontend](https://github.com/sobiabashir/library-management-frontend)

---

Built by **Sobia Bashir** — Java Developer | Full Stack Engineer
