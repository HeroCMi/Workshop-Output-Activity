# 🎓 Student Management System
A complete JavaFX desktop application connected to PostgreSQL, built for managing student records — add, view, and store student data securely.

---

## 📌 Features
- View all students in a table
- Add new student records (Name, Course, Year Level)
- Data saved to PostgreSQL database
- Simple, clean, user‑friendly interface
- Fully working page navigation

---

## 🛠️ Tech Stack
- **Language:** Java 17+
- **UI Framework:** JavaFX 21
- **Database:** PostgreSQL 15+
- **Build Tool:** Maven
- **IDE:** IntelliJ IDEA

---

## 🚀 How to Run
### 1. Setup Database
- Open pgAdmin → create database: `studentdb_new`
- Run this SQL query:
```sql
CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    course VARCHAR(50),
    year_level INT
);

return DriverManager.getConnection(
    "jdbc:postgresql://localhost:5432/studentdb_new",
    "postgres",
    "YOUR_PASSWORD_HERE"
);

