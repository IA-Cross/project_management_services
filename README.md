﻿# Project Management API

This is a **Full-Stack Project Management Application** built with **Spring Boot (Groovy) and React**, providing a secure API for managing users, projects, and tasks.

## Features

- **User Authentication (JWT)**
- **Role-Based Access Control (RBAC)**
    - Admins can manage users.
    - Users can manage their own projects and tasks.
- **Task & Project Management**
- **REST API with Spring Boot**
- **Secure Password Hashing (BCrypt)**
- **Database: PostgreSQL / MySQL**
- **React Frontend (Coming Soon)**

---

## Technologies Used

### Backend:

- **Spring Boot (Groovy)**
- **Spring Security & JWT**
- **Spring Data JPA**
- **PostgreSQL / MySQL**
- **Gradle**

### Frontend (Coming soon...):

- **React.js**
- **Tailwind CSS**
- **React Query (for API calls)**

---

## Installation

###  1. Clone the Repository

```sh
git clone https://github.com/yourusername/project-management-api.git
cd project-management-api
```

###  2. Set Up the Database

Create a PostgreSQL/MySQL database and update `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/projectdb
    username: your_username
    password: your_password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

###  3. Build & Run the Backend

```sh
./gradlew bootRun
```

The API will be available at:\
`http://localhost:8080/api`

---

## Authentication & Roles

This API uses **JWT Authentication**. When a user logs in, they receive a **Bearer Token**, which must be included in API requests.

### Roles:

- **USER** → Can manage their own projects and tasks.
- **ADMIN** → Can manage users.

---

## API Endpoints

### Authentication

| Method | Endpoint             | Description                    |
| ------ | -------------------- | ------------------------------ |
| `POST` | `/api/auth/register` | Register a new user            |
| `POST` | `/api/auth/login`    | Log in and receive a JWT token |

### User Management (Admin Only)

| Method | Endpoint                  | Description           |
| ------ | ------------------------- | --------------------- |
| `GET`  | `/api/users`              | Get all users         |
| `PUT`  | `/api/users/{id}/promote` | Promote user to admin |

###  Project Management

| Method | Endpoint        | Description          |
| ------ | --------------- | -------------------- |
| `GET`  | `/api/projects` | Get all projects     |
| `POST` | `/api/projects` | Create a new project |

### Task Management

| Method | Endpoint     | Description       |
| ------ | ------------ | ----------------- |
| `GET`  | `/api/tasks` | Get all tasks     |
| `POST` | `/api/tasks` | Create a new task |

---

## Running the Frontend (React)

The frontend is under development. To run it:

```sh
cd frontend
npm install
npm start
```

Access the UI at ``.

---

## Future Improvements

OAuth Authentication (Google Login)\
Real-time Task Updates (WebSockets)\
UI Enhancements with Drag & Drop

---

## Contributing

Pull requests are welcome! If you'd like to contribute, please open an issue first.

---
