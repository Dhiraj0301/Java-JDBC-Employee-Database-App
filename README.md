# 🧾 Employee Database App (Java + MySQL)

A simple Java console-based application to manage employee records using **JDBC** and **MySQL**. This project demonstrates basic **CRUD operations** and Java-MySQL connectivity.

---

## 📋 Features

- ✅ Add Employee
- 📄 View Employees
- ✏️ Update Employee
- ❌ Delete Employee
- 🚪 Exit

---

## 🛠️ Tech Stack

- **Java** (JDK 17+)
- **MySQL** (Database)
- **JDBC** (MySQL Connector)
- **VS Code** or **Command Prompt**

---

## 📂 Project Structure

EmployeeDBApp/
├── EmployeeCRUD.java
├── DBConnection.java
├── run.bat
├── lib/
│ └── mysql-connector-j-<version>.jar

yaml
Copy
Edit

---

## ⚙️ Setup Instructions

### 1. 📥 Clone the repository
```bash
git clone https://github.com/your-username/employee-db-app.git
cd employee-db-app
2. 🛢️ Create the Database
Log into MySQL and run:

sql
Copy
Edit
CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    designation VARCHAR(100),
    salary DOUBLE
);
3. 📌 Configure JDBC
Edit DBConnection.java:

java
Copy
Edit
private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
4. 📦 Add MySQL JDBC Driver
Download from MySQL Connector/J
Put the .jar file in the lib/ folder.

▶️ Run the App
Use the provided batch file:

bash
Copy
Edit
run.bat
Or manually compile and run:

bash
Copy
Edit
javac -cp "lib/mysql-connector-j-<version>.jar" *.java
java -cp "lib/mysql-connector-j-<version>.jar;." EmployeeCRUD
📸 Preview
pgsql
Copy
Edit
--- Employee Database App ---
1. Add Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Exit
Enter choice: _
