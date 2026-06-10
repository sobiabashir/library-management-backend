# Library Management System — Backend 📚

A secure full stack REST API built with Java and Spring Boot, featuring JWT authentication, role-based access control and email integration.

## 🌐 Live Demo

**Frontend:** https://library-management-frontend-git-main-sobia-s-projects.vercel.app

**Backend API:** https://library-management-backend-production-61bb.up.railway.app

## 🛠 Tech Stack

- Java 21
- Spring Boot 3.5
- Spring Security
- JWT Authentication (jjwt 0.11.5)
- BCrypt Password Encoding
- Spring Data JPA / Hibernate
- MySQL (Railway production) / H2 (local development)
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
- H2 Console for local database inspection
- Multi-profile configuration (local H2 / prod MySQL)

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
| sobiaasim2017@gmail.com | admin123 | ADMIN |
| sobiabashir_786@hotmail.com | member123 | MEMBER |

## ☁️ Deployment

- **Backend** deployed on **Railway** with MySQL database
- **Frontend** deployed on **Vercel**
- Multi-profile Spring Boot setup: `local` profile uses H2, `prod` profile uses Railway MySQL

## 🚀 How to Run Locally

1. Clone the repository
```bash
git clone https://github.com/sobiabashir/library-management-backend.git
```
2. Open in IntelliJ IDEA
3. Run `LibraryManagementApplication.java`
4. API runs on `http://localhost:8080`
5. H2 Console at `http://localhost:8080/h2-console`

## 🔗 Frontend Repository

[Library Management System Frontend](https://github.com/sobiabashir/library-management-frontend)

---
Built by **Sobia Bashir** — Java Developer | Full Stack Engineer
