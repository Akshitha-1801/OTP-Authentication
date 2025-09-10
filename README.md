# OTP Authentication System 🔐

This project implements a secure **OTP-based login authentication system** using **Spring Boot, REST API, and Thymeleaf**.

## 🚀 Features
- User login with **username & password**.
- Backend validates credentials and sends a **One-Time Password (OTP)** to the registered email.
- User enters OTP on a separate page.
- Backend validates OTP and grants access to **dashboard**.
- Prevents unauthorized access with an additional layer of security.

## 🛠 Tech Stack
- **Backend:** Java, Spring Boot (REST APIs)
- **Frontend:** HTML, Thymeleaf
- **Database:** MySQL (or any JDBC-supported DB)
- **Email Service:** JavaMailSender

## 📂 Project Flow
1. **Login Page** → User enters username & password.
2. **OTP Generation** → System sends OTP to registered email.
3. **OTP Verification Page** → User enters OTP.
4. **Validation** → If OTP is correct, user is redirected to Dashboard.

## ⚙️ How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/Akshitha-1801/OTP-Authentication.git
