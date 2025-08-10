# FastX Backend

FastX Backend is a Spring Boot-based REST API designed for managing ride bookings, user authentication, and real-time updates for the FastX platform.  
It follows a modular architecture with clear separation of layers (Controller, Service, Repository) and integrates seamlessly with a MySQL database.



## Features
- User Management: Register, login, and manage profiles.
- Ride Booking: Create, update, and track ride requests.
- Role-based Access Control: Admin and User permissions.
- Database Integration: MySQL with Spring Data JPA.
- Secure Authentication: Spring Security with JWT tokens.
- DTO-based Data Transfer for clean request/response handling.


## Tech Stack
- Java (Spring Boot 3.x)
- Spring Data JPA (Hibernate ORM)
- Spring Security + JWT
- MySQL (Relational Database)
- Lombok (Code reduction)
- Maven (Dependency management)
- Jakarta Persistence API



##  Project Structure

FastX-Backend/
│── src/main/java/com/fastx/backend
│ ├── controller # REST API controllers
│ ├── service # Business logic
│ ├── repository # Database access
│ ├── entity # JPA entities
│ ├── security # Security configuration
│── src/main/resources
│ ├── application.properties
│── pom.xml


## Setup Instructions

### 1) Clone the repository
```bash
git clone https://github.com/yourusername/FastX-Backend.git
cd FastX-Backend

2) Configure the Database
Edit src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/fastx_db
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3) Run the Application

mvn spring-boot:run

## API ENDPOINTS

| Method | Endpoint           | Description                | Auth Required  |
| ------ | ------------------ | -------------------------- | -------------  |
| POST   | `/api/auth/signup` | Register a new user        | NO             |
| POST   | `/api/auth/login`  | Authenticate and get token | NO             |
| GET    | `/api/rides`       | Get available rides        | YES            |
| POST   | `/api/rides/book`  | Book a ride                | YES            |
| GET    | `/api/users/me`    | Get logged-in user profile | YES            |



## License
All Rights Reserved.  
This project is the intellectual property of [Your Name].  
No part of this code may be used, copied, modified, or distributed without explicit permission from the author.

## Author
DEVI RAMYA
[LinkedIn Profile](https://www.linkedin.com/in/devi-ramya-52484b23a/) | deviramya1220@gmail.com
