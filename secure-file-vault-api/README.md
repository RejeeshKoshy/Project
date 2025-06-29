## **Title:** Secure File Vault – An API-Based Encrypted File Storage System

### **Team Size:** 3 Members

### **Submitted by:**

* Member 1: @petrifiedsage – Authentication & Security
* Member 2: @Betson-Benny – File Encryption & Vault
* Member 3: @RejeeshKoshy – API Integration & Testing

### **Guided by:** Dr. PeriyaSwami

### **Institution:** St Joseph's University, School of Information Technology

---

### 1. **Introduction**

In today’s digital world, sensitive files are often at risk of unauthorized access, theft, or accidental leakage. This project aims to build a **Secure File Vault** – a RESTful API system that enables users to **upload, encrypt, store, and retrieve files securely** using password-based and token-based authentication.

The project will be developed using **Python (FastAPI)** and follow best practices in **cybersecurity and data protection**.

---

### 2. **Objective**

* To create a secure, password-protected file vault system.
* To build a backend API that supports file upload, encryption, and retrieval.
* To implement authentication using **JWT tokens** and **bcrypt password hashing**.
* To ensure files are safely stored using **AES-256 encryption**.
* To allow future upgrades like **MFA**, **integrity checks**, and **file expiry**.

---

### 3. **Scope of the Project**

This is a **modular project**, making it easy to expand. In Phase 1 (MVP), the team will deliver:

* User registration and login with secure password hashing
* JWT-based session management
* File upload (encrypted using AES)
* File download (decrypted on valid request)
* API testing via Postman/Swagger UI

---

### 4. **Modules and Team Division**

| Module                        | Description                                       | Member |
| ----------------------------- | ------------------------------------------------- | ------ |
| Authentication & Security     | Registration, Login, JWT, bcrypt                  | M1     |
| Vault (Encryption/Decryption) | AES-based file encryption, secure upload/download | M2     |
| API Server & Integration      | FastAPI setup, database, route linking, testing   | M3     |

---

### 5. **Software and Tools Used**

| Tool/Library        | Purpose                      |
| ------------------- | ---------------------------- |
| Python (FastAPI)    | API development              |
| SQLite/PostgreSQL   | User and metadata storage    |
| bcrypt              | Secure password hashing      |
| cryptography        | File encryption (AES-256)    |
| JWT (`python-jose`) | Token-based authentication   |
| Postman             | API testing and validation   |
| Git/GitHub          | Version control and teamwork |

---

### 6. **Expected Outcome**

* A functional backend system with secure file handling APIs
* Encrypted file storage and safe retrieval using password
* Simple, testable API endpoints for demonstration
* Clean and extensible codebase suitable for real-world use

---

### 7. **Future Enhancements**

* Two-Factor Authentication (TOTP using Google Authenticator)
* File integrity checks (SHA-256 hashing)
* File expiration and access control
* Web-based user interface (Angular/React)
* Secure file sharing with QR codes or expiring links

---

### 8. **References**

* FastAPI Documentation
* Python Cryptography Library
* OWASP Best Practices for Authentication
* JWT and API Security Standards
