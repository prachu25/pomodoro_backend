# Pomodoro – Backend

Backend for a productivity web application that helps users stay focused using the Pomodoro technique, track study sessions,
and maintain daily streaks.

**Tech:** Java • Spring Boot • REST API • MySQL • Maven • Docker

**Live:** https://pomodoro-app-sigma-pink.vercel.app/ 
> ⚠️ Backend hosted on Render (free tier). First load may take up to **1–2 minutes**.

**Frontend Repository:** [pomodoro_frontend](https://github.com/prachu25/pomodoro_frontend)

---

## Overview
Pomodoro Backend is a RESTful API built using Spring Boot that powers a productivity tracking web application.

It allows users to:
- Register and login
- Track study and break sessions
- Maintain daily study streaks
- View daily dashboard summary
- The backend manages business logic, session tracking, and database operations using MySQL.

## Key Features

- **User Authentication** – Secure register & login system
- **Study Session Tracking** – Store daily study sessions
- **Break Session Tracking** – Track break intervals
- **Daily Streak System** – Automatically updates streak based on study consistency
- **Dashboard Summary** – Daily study statistics & session history
- **RESTful APIs** – Clean API structure for frontend integration
- **Spring Boot Architecture** – Layered design (Controller → Service → Repository)
- **Timezone Handling** – Accurate streak tracking using Asia/Kolkata time

---

## Architecture
```
User
↓
Frontend (React + Vite)
↓
Spring Boot Backend (REST APIs)
├── Controller Layer
├── Service Layer
└── Repository Layer
↓
MySQL Database
↑
Response back to Frontend

```
### Requesr Flow

1. Client sends request to Spring Boot API
2. Controller receives request & validates data
3. Service layer processes business logic
    - Authentication
    - Study session handling
    - Break session handling
    - Streak updates
    - Dashboard calculations
4. Repository layer interacts with the MySQL database
5. Data is stored or fetched from the database
6. Processed response returned to frontend

---

## Tech Stack

### Backend
- Java  
- Spring Boot  
- Spring Web (REST APIs)  
- Spring Data JPA  
- Hibernate

### Database
- MySQL (Aiven Cloud)

### Tools & Testing
- Postman – API testing  
- Maven – Dependency management  
- Git & GitHub – Version control
- Docker – Deployment container
- Render - Cloud hosting

---

## Project Structure
```
pomodoro_backend/
├── src/
│ ├── main/
│ │ ├── java/com/example/pomodoro/
│ │ │ ├── config/
│ │ │ │ └── CorsConfig.java                 # CORS configuration for frontend requests
│ │ │ │
│ │ │ ├── controller/
│ │ │ │ ├── AuthController.java             # User authentication APIs (login/register)
│ │ │ │ ├── PomodoroController.java         # Study & break session APIs
│ │ │ │ └── DashboardController.java        # Dashboard summary APIs
│ │ │ │
│ │ │ ├── dto/
│ │ │ │ ├── RegisterRequest.java            # Register request data
│ │ │ │ ├── LoginRequest.java               # Login request data
│ │ │ │ ├── PomodoroRequest.java            # Study/Break session request
│ │ │ │ └── DashboardResponse.java          # Dashboard response model
│ │ │ │
│ │ │ ├── entity/
│ │ │ │ ├── User.java                       # User entity (name, email, password)
│ │ │ │ ├── PomodoroSession.java            # Study/Break session entity
│ │ │ │ └── Streak.java                     # Streak tracking entity
│ │ │ │
│ │ │ ├── repository/
│ │ │ │ ├── UserRepository.java             # User database operations
│ │ │ │ ├── PomodoroSessionRepository.java  # Session database operations
│ │ │ │ └── StreakRepository.java           # Streak database operations
│ │ │ │
│ │ │ ├── service/
│ │ │ │ ├── AuthService.java                # Authentication business logic
│ │ │ │ ├── PomodoroService.java            # Session & streak logic
│ │ │ │ └── DashboardService.java           # Dashboard calculation logic
│ │ │ │
│ │ │ └── PomodoroApplication.java          # Main Spring Boot application
│ │
│ │ └── resources/
│ │     ├── application.properties          # Local configuration
│ │     ├── application-prod.properties     # Production configuration (Render)
│ │     ├── static/                         
│ │     └── templates/                     
│ │
│ └── test/                                
│
├── .mvn/                                   # Maven wrapper files
├── target/                                
├── Dockerfile                              # Docker container setup
├── pom.xml                                 # Maven dependencies
└── README.md                               # Project documentation

```

---

## API Endpoints

### Authentication
- **POST** `/api/auth/register` – User Registration
```
{
  "name": "Test User",
  "email": "test@gmail.com",
  "password": "123456"
}
```
- **POST** `/api/auth/login` – User Login
```
{
  "email": "test@gmail.com",
  "password": "123456"
}
```
### Study & Break Sessions
- **POST** /api/pomodoro/study – Save study session & update streak
```
{
  "userId": 1,
  "minutes": 25
}
```
- **POST** /api/pomodoro/break – Save break session
```
{
  "userId": 1,
  "minutes": 15
}
```
### Dashboard
- **GET** /api/dashboard/today?userId={userId} - today summary
```
{
    "studySessions": 1,
    "breakSessions": 1,
    "totalStudyMinutes": 25,
    "sessions": [
        {
            "id": 5,
            "userId": 1,
            "sessionType": "STUDY",
            "minutes": 25,
            "sessionDate": "2026-02-10"
        },
        {
            "id": 6,
            "userId": 1,
            "sessionType": "BREAK",
            "minutes": 5,
            "sessionDate": "2026-02-10"
        }
    ]
}
```

---

## Database Tables
- users
- pomodoro_sessions
- streaks
  
---

## Installation & Setup
### 1. Clone Repository
```bash
git clone git clone https://github.com/prachi25/pomodoro_backend.git
cd pomodoro_backend
```

### 2. Configure Application Properties
Edit backend config file:
```bash
src/main/resources/application.properties
```
Update values:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/pomodoro_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
### 3. Start backend server:
```bash
.\mvnw.cmd spring-boot:run
```
Backend runs on:
```bash
http://localhost:8080
```
### 4. Test APIs (Optional)
Use Postman to test APIs:
```bash
POST http://localhost:8080/api/auth/login
POST http://localhost:8080/api/pomodoro/study
GET  http://localhost:8080/api/dashboard/today?userId=1
```

----

## Future Enhancements
- JWT Authentication
- Weekly & monthly analytics
- Leaderboard system
- Notifications & reminders
- Multi-timezone support

---

## License
This project is licensed under the MIT License.

---




 


















