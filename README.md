# Hotel Reservation Web (Spring Boot)

## What
Hotel Reservation Web Application — Project Description

The Hotel Reservation Web Application is a full-stack hotel booking system built using Spring Boot, Thymeleaf, and PostgreSQL, designed to allow users to easily create, view, and manage hotel room reservations through a clean and responsive UI.

This project demonstrates core concepts of web development, backend APIs, database integration, UI/UX design, and cloud deployment.
It is fully hosted online using Render (backend) and can be extended with any frontend deployment platform.

## How to run
1. Ensure Java 17+ and Maven are installed.
2. Create DB and table in MySQL (run DDL below) or set spring.jpa.hibernate.ddl-auto=update in application.properties during development.
3. Update `src/main/resources/application.properties` with your MySQL username and password.
4. Build and run:

```bash
mvn spring-boot:run
```

Open http://localhost:8080/

## DDL
```sql
CREATE DATABASE IF NOT EXISTS hotel_db;
USE hotel_db;

CREATE TABLE IF NOT EXISTS reservations (
  reservation_id INT AUTO_INCREMENT PRIMARY KEY,
  guest_name VARCHAR(100) NOT NULL,
  room_number INT NOT NULL,
  contact_number VARCHAR(50),
  reservation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```
