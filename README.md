# 🏠 DEA Real Estate Platform

A full-stack **Real Estate Property Management** web application built with **Spring Boot 4** (Java 17) for the backend and **Vite + TailwindCSS** for the frontend. The platform enables property listing, agent management, inquiry handling with real-time chat, seller applications, and comprehensive admin/agent dashboards.

---

## 📑 Table of Contents

- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Prerequisites](#-prerequisites)
- [Database Setup](#-database-setup)
- [Running in IntelliJ IDEA](#-running-in-intellij-idea)
- [Running the Frontend](#-running-the-frontend)
- [Environment Variables](#-environment-variables)
- [Application Architecture](#-application-architecture)
- [API Endpoints](#-api-endpoints)
- [Default Accounts](#-default-accounts)
- [Features](#-features)

---

## 🛠 Tech Stack

### Backend

| Component               | Technology                        | Version   |
|-------------------------|-----------------------------------|-----------|
| **Framework**           | Spring Boot                       | 4.0.2     |
| **Language**            | Java                              | 17        |
| **Build Tool**          | Apache Maven                      | 3.x       |
| **ORM**                 | Spring Data JPA / Hibernate       | Latest    |
| **Database**            | MySQL (MariaDB compatible)        | 10.4+     |
| **Security**            | Spring Security + JWT (jjwt)      | 0.12.6    |
| **WebSocket**           | Spring WebSocket (STOMP)          | Latest    |
| **Email**               | Spring Boot Starter Mail (SMTP)   | Latest    |
| **Validation**          | Spring Boot Starter Validation    | Latest    |
| **Monitoring**          | Spring Boot Actuator              | Latest    |
| **Code Generation**     | Lombok                            | Latest    |
| **Environment Config**  | spring-dotenv                     | 4.0.0     |
| **DevTools**            | Spring Boot DevTools              | Latest    |
| **Testing**             | JUnit 5, H2 (in-memory DB)       | Latest    |

### Frontend

| Component         | Technology      | Version |
|-------------------|-----------------|---------|
| **Build Tool**    | Vite            | 5.0     |
| **CSS Framework** | TailwindCSS     | 3.4.1   |
| **HTTP Client**   | Axios           | 1.6.2   |
| **PostCSS**       | PostCSS         | 8.4.31  |
| **Autoprefixer**  | Autoprefixer    | 10.4.20 |
| **Server**        | Express.js      | 5.2.1   |
| **Animations**    | AOS (Animate on Scroll) | CDN |

---

## 📁 Project Structure

```
DEA-Final/
├── src/                                    # Spring Boot Backend
│   ├── main/
│   │   ├── java/com/example/final_project/
│   │   │   ├── FinalProjectApplication.java    # Main entry point
│   │   │   ├── config/                         # Configuration classes
│   │   │   │   ├── ApplicationConfig.java          # Bean definitions
│   │   │   │   ├── SecurityConfig.java             # Spring Security + JWT config
│   │   │   │   ├── JwtAuthenticationFilter.java    # JWT token filter
│   │   │   │   ├── WebConfig.java                  # CORS configuration
│   │   │   │   ├── WebSocketConfig.java            # WebSocket/STOMP config
│   │   │   │   ├── DataInitializer.java            # Initial data loader
│   │   │   │   └── DataSeeder.java                 # Sample data seeder
│   │   │   ├── controller/                     # REST API Controllers (13)
│   │   │   │   ├── AuthenticationController.java   # Login / Register
│   │   │   │   ├── PropertyController.java         # Property CRUD
│   │   │   │   ├── AgentController.java            # Agent management
│   │   │   │   ├── InquiryController.java          # User inquiries
│   │   │   │   ├── AdminInquiryController.java     # Admin inquiry handling
│   │   │   │   ├── AgentInquiryController.java     # Agent inquiry handling
│   │   │   │   ├── AdminListingController.java     # Admin property management
│   │   │   │   ├── AdminSellerController.java      # Seller application review
│   │   │   │   ├── SellerController.java           # Seller self-service
│   │   │   │   ├── ListingController.java          # Public listings
│   │   │   │   ├── FileUploadController.java       # Image/file uploads
│   │   │   │   ├── NotificationController.java     # User notifications
│   │   │   │   └── StatsController.java            # Dashboard statistics
│   │   │   ├── model/                          # JPA Entities (16)
│   │   │   │   ├── User.java                       # User entity (ADMIN, AGENT, USER)
│   │   │   │   ├── Agent.java                      # Agent professional profiles
│   │   │   │   ├── Property.java                   # Property listings
│   │   │   │   ├── Inquiry.java                    # Inquiry threads
│   │   │   │   ├── InquiryMessage.java             # Chat messages
│   │   │   │   ├── SellerApplication.java          # Seller registrations
│   │   │   │   ├── ActivationToken.java            # Email activation tokens
│   │   │   │   ├── UserNotification.java           # In-app notifications
│   │   │   │   ├── PropertyMedia.java              # Property media files
│   │   │   │   ├── StoredCredential.java           # Credential storage
│   │   │   │   └── (Enums: Role, PropertyType, PropertyStatus,
│   │   │   │        HouseType, InquiryStatus, AgentStatus)
│   │   │   ├── dto/                            # Data Transfer Objects (11)
│   │   │   ├── repository/                     # Spring Data JPA Repositories (10)
│   │   │   └── service/                        # Business Logic Services (10)
│   │   │       ├── AuthenticationService.java      # Auth + JWT token generation
│   │   │       ├── PropertyService.java            # Property CRUD logic
│   │   │       ├── InquiryService.java             # Inquiry + real-time messaging
│   │   │       ├── AgentService.java               # Agent profile management
│   │   │       ├── SellerService.java              # Seller application workflow
│   │   │       ├── JwtService.java                 # JWT token utilities
│   │   │       ├── EmailService.java               # Email notifications
│   │   │       ├── NotificationService.java        # In-app notifications
│   │   │       ├── FileStorageService.java         # File upload handling
│   │   │       └── CustomUserDetailsService.java   # Spring Security user loader
│   │   └── resources/
│   │       └── application.properties          # App configuration
│   └── test/                                   # Unit & Integration Tests
│
├── frontend/                               # Vite + TailwindCSS Frontend
│   ├── index.html                              # Home page (hero, featured listings)
│   ├── login.html                              # User login
│   ├── register.html                           # User registration
│   ├── properties.html                         # Property search & browse
│   ├── view-property.html                      # Single property detail view
│   ├── agents.html                             # Agent directory
│   ├── agent-profile.html                      # Individual agent profile
│   ├── contact.html                            # Contact form (WhatsApp integration)
│   ├── about.html                              # About page
│   ├── aboutDev.html                           # About the developers
│   ├── admin-dashboard.html                    # Admin panel (full management)
│   ├── admin-inquiries.html                    # Admin inquiry management
│   ├── agent-dashboard.html                    # Agent workspace
│   ├── agent-inquiries.html                    # Agent inquiry view
│   ├── user-dashboard.html                     # User dashboard (my listings)
│   ├── user-inquiries.html                     # User inquiry tracking
│   ├── inquiry-chat.html                       # Real-time inquiry chat
│   ├── sell-property.html                      # Submit property for listing
│   ├── seller-apply.html                       # Apply as a seller
│   ├── seller-activate.html                    # Activate seller account
│   ├── submission-success.html                 # Post-submission confirmation
│   ├── src/
│   │   ├── main.js                             # Core frontend logic & API calls
│   │   ├── admin.js                            # Admin dashboard logic
│   │   ├── agent-dashboard.js                  # Agent dashboard logic
│   │   └── style.css                           # TailwindCSS + custom styles
│   ├── uploads/                                # Static property/agent images
│   ├── public/                                 # Public static assets
│   ├── package.json                            # Node.js dependencies
│   ├── vite.config.js                          # Vite build configuration
│   ├── tailwind.config.js                      # TailwindCSS configuration
│   └── postcss.config.js                       # PostCSS plugins
│
├── real_estate_db.sql                      # Full database dump (importable)
├── pom.xml                                 # Maven build configuration
├── mvnw / mvnw.cmd                         # Maven wrapper scripts
└── .gitignore
```

---

## ✅ Prerequisites

Make sure the following are installed on your system before running the project:

| Software            | Version   | Download Link                                                                 |
|---------------------|-----------|-------------------------------------------------------------------------------|
| **Java JDK**        | 17+       | [Oracle JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or [Adoptium](https://adoptium.net/) |
| **IntelliJ IDEA**   | 2023.x+   | [JetBrains IntelliJ](https://www.jetbrains.com/idea/download/)                |
| **MySQL Server**    | 8.0+      | [MySQL Downloads](https://dev.mysql.com/downloads/mysql/) or use [XAMPP](https://www.apachefriends.org/) (MariaDB) |
| **Node.js**         | 18+       | [Node.js Downloads](https://nodejs.org/)                                      |
| **npm**             | 9+        | Bundled with Node.js                                                          |
| **Git**             | Latest    | [Git Downloads](https://git-scm.com/downloads)                               |

---

## 🗄 Database Setup

### Option A — Import the provided SQL dump (Recommended)

1. Start your **MySQL/MariaDB** server (via XAMPP, MySQL Workbench, or CLI).

2. Create the database and import the dump:

   ```bash
   mysql -u root -p < real_estate_db.sql
   ```

   Or via **phpMyAdmin**:
   - Navigate to `http://localhost/phpmyadmin`
   - Create a new database named **`real_estate_db`**
   - Go to the **Import** tab → Choose `real_estate_db.sql` → Click **Go**

### Option B — Let Hibernate auto-create tables

If you skip the SQL import, Spring Boot will auto-create all tables on first run (since `spring.jpa.hibernate.ddl-auto=update` is configured). However, you won't have any sample data.

### Database Configuration

The default config in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/real_estate_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
```

> **Note:** Update the `username` and `password` if your MySQL server uses different credentials.

---

## Running in IntelliJ IDEA

### Step 1 — Clone / Open the Project

1. **Open IntelliJ IDEA**
2. Go to **File → Open**
3. Navigate to the project root folder and select it
4. Click **OK**. IntelliJ will detect it as a **Maven project** and begin indexing.

### Step 2 — Import Maven Dependencies

1. Wait for IntelliJ to finish indexing.
2. If dependencies are not auto-imported, open the **Maven** tool window (right sidebar) and click the **🔄 Reload All Maven Projects** button.
3. Alternatively, right-click `pom.xml` → **Maven** → **Reload Project**.

### Step 3 — Configure the JDK

1. Go to **File → Project Structure** (or press `Ctrl + Alt + Shift + S`)
2. Under **Project Settings → Project**:
   - Set **SDK** to **JDK 17**
   - Set **Language Level** to **17**
3. Click **Apply → OK**

### Step 4 — Verify Module Source Root

1. In **File → Project Structure → Modules**:
   - Ensure `src/main/java` is marked as **Sources** (blue folder icon)
   - Ensure `src/main/resources` is marked as **Resources**
   - Ensure `src/test/java` is marked as **Tests**
2. If not, right-click each folder and select the appropriate marking.

### Step 5 — Enable Lombok Annotation Processing

1. Go to **File → Settings** (or `Ctrl + Alt + S`)
2. Navigate to **Build, Execution, Deployment → Compiler → Annotation Processors**
3. ✅ Check **Enable annotation processing**
4. Click **Apply → OK**
5. Also ensure the **Lombok plugin** is installed:
   - Go to **Settings → Plugins** → Search for **Lombok** → Install if not present → Restart IntelliJ

### Step 6 — Configure the Run Configuration

1. IntelliJ should auto-detect `FinalProjectApplication.java` as the main class.
2. If not, manually create a run configuration:
   - Go to **Run → Edit Configurations**
   - Click **+ → Application**
   - Set **Main class** to: `com.example.final_project.FinalProjectApplication`
   - Set **Module** to your project module
   - Set **JRE** to **17**
   - Click **Apply → OK**

### Step 7 — Start MySQL

Make sure your MySQL/MariaDB server is **running** before starting the app:
- **XAMPP:** Start the MySQL module from the Control Panel
- **MySQL Service:** Ensure the `mysql` / `MySQL80` Windows service is running

### Step 8 — Run the Application

1. Click the **▶ Run** button (or press `Shift + F10`)
2. The Spring Boot application will start on **`http://localhost:8080`**
3. Check the console for:
   ```
   Started FinalProjectApplication in X.XX seconds
   ```

> ⚠️ **Troubleshooting:** If you see "module not specified" error, go to **Run → Edit Configurations** and set the correct module. If you see "Java file is located outside of the module source root", verify Step 4 above.

---

## 🌐 Running the Frontend

The frontend is a separate **Vite** project that runs independently and communicates with the backend via REST APIs.

### Step 1 — Install Dependencies

Open a terminal in the `frontend/` directory:

```bash
cd frontend
npm install
```

### Step 2 — Start the Dev Server

```bash
npm run dev
```

The frontend will be available at **`http://localhost:5173`**

### Step 3 — Verify Connection

Ensure both servers are running:

| Service    | URL                        |
|------------|----------------------------|
| Backend    | `http://localhost:8080`     |
| Frontend   | `http://localhost:5173`     |

The frontend makes API calls to the backend at `localhost:8080`. CORS is configured in `WebConfig.java` to allow requests from the frontend origin.

---

## 🔐 Environment Variables

For **email functionality** (seller activation emails, notifications), create a `.env` file in the project root:

```env
MAIL_HOST=smtp.gmail.com
MAIL_PORT=587
MAIL_USERNAME=email@gmail.com
MAIL_PASSWORD=app-password
MAIL_FROM=email@gmail.com
APP_BASE_URL=http://localhost:5173
```

> **Tip:** For Gmail, generate an [App Password](https://myaccount.google.com/apppasswords) instead of using your regular password.

The `.env` file is loaded automatically by the `spring-dotenv` library.

---

## 🏗 Application Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                    FRONTEND (Vite + TailwindCSS)            │
│   ┌──────────┐  ┌──────────┐  ┌───────────┐  ┌──────────┐   │
│   │  index   │  │properties│  │  agents   │  │dashboards│   │
│   │  .html   │  │  .html   │  │  .html    │  │  .html   │   │
│   └────┬─────┘  └────┬─────┘  └─────┬─────┘  └────┬─────┘   │
│        │             │              │             │         │
│   ┌────┴─────────────┴──────────────┴─────────────┴──────┐  │
│   │              main.js / admin.js / agent.js           │  │
│   │                  (Axios HTTP Client)                 │  │
│   └──────────────────────┬───────────────────────────────┘  │
└──────────────────────────┼──────────────────────────────────┘
                           │  REST API + WebSocket
┌──────────────────────────┼──────────────────────────────────┐
│                    BACKEND (Spring Boot 4)                  │
│   ┌──────────────────────┴───────────────────────────────┐  │
│   │              Controllers (REST Endpoints)            │  │
│   │  Auth │ Property │ Agent │ Inquiry │ Admin │ Seller  │  │
│   └──────────────────────┬───────────────────────────────┘  │
│   ┌──────────────────────┴───────────────────────────────┐  │
│   │                   Services (Business Logic)          │  │
│   │  Auth │ Property │ Agent │ Inquiry │ JWT │ Email     │  │
│   └──────────────────────┬───────────────────────────────┘  │
│   ┌──────────────────────┴───────────────────────────────┐  │
│   │               Repositories (Data Access)             │  │
│   │                   Spring Data JPA                    │  │
│   └──────────────────────┬───────────────────────────────┘  │
│   ┌──────────────────────┴───────────────────────────────┐  │
│   │     Security Layer (JWT Filter + Spring Security)    │  │
│   └──────────────────────────────────────────────────────┘  │
└──────────────────────────┼──────────────────────────────────┘
                           │
┌──────────────────────────┼──────────────────────────────────┐
│                     MySQL Database                          │
│   users │ agents │ properties │ inquiries │ messages │ ...  │
└─────────────────────────────────────────────────────────────┘
```

---

## 📡 API Endpoints

### Authentication
| Method | Endpoint             | Description           |
|--------|----------------------|-----------------------|
| POST   | `/api/auth/register` | Register a new user   |
| POST   | `/api/auth/login`    | Login and receive JWT |

### Properties
| Method | Endpoint                       | Description                 |
|--------|--------------------------------|-----------------------------|
| GET    | `/api/properties`              | List all available properties |
| GET    | `/api/properties/{id}`         | Get property details        |
| POST   | `/api/properties`              | Submit a new property       |
| PUT    | `/api/properties/{id}`         | Update property             |
| DELETE | `/api/properties/{id}`         | Delete property             |

### Agents
| Method | Endpoint              | Description           |
|--------|-----------------------|-----------------------|
| GET    | `/api/agents`         | List all agents       |
| GET    | `/api/agents/{id}`    | Get agent profile     |
| POST   | `/api/agents`         | Create agent (Admin)  |

### Inquiries
| Method | Endpoint                          | Description                |
|--------|-----------------------------------|----------------------------|
| POST   | `/api/inquiries`                  | Create inquiry             |
| GET    | `/api/inquiries/my`               | Get user's inquiries       |
| POST   | `/api/inquiries/{id}/messages`    | Send a message             |
| GET    | `/api/inquiries/{id}/messages`    | Get inquiry messages       |

### Admin
| Method | Endpoint                              | Description                    |
|--------|---------------------------------------|--------------------------------|
| GET    | `/api/admin/listings`                 | All property submissions       |
| PUT    | `/api/admin/listings/{id}/approve`    | Approve a listing              |
| PUT    | `/api/admin/listings/{id}/reject`     | Reject a listing               |
| GET    | `/api/admin/sellers`                  | Seller applications            |
| GET    | `/api/stats`                          | Dashboard statistics           |

---

## 👤 Default Accounts

After importing `real_estate_db.sql`, you can log in with these accounts:

| Role    | Email                        | Password   |
|---------|------------------------------|------------|
| Admin   | `admin@example.com`          | `admin123` |
| User    | `user@example.com`           | `user123`  |
| Agent   | `hemalag@re.com`             | `hemal123` |

> **Note:** All agent accounts use the password `<agentname>123`.

---

## ✨ Features

### 🏘 Property Management
- Browse, search, and filter property listings (Sale, Rent, Short-stay Rental)
- Detailed property view with image gallery, facilities, and house rules
- Property types: House, Apartment, Townhome, Land, Multi-family, Manufactured
- Property status tracking: Available, Pending, Sold, Rented, Rejected

### 👨‍💼 Agent System
- Agent directory with professional profiles
- Agent-property assignment
- Agent-specific inquiry management
- Top Agent of the Month spotlight
- Agent reviews and ratings

### 💬 Real-Time Inquiry Chat
- WebSocket-powered real-time messaging (STOMP protocol)
- Multi-role chat (User ↔ Agent ↔ Admin)
- Inquiry status tracking (Pending, Replied, Closed)
- Unread message indicators

### 🔒 Security & Authentication
- JWT-based stateless authentication
- Role-based access control (Admin, Agent, User)
- Spring Security filter chain
- Password encryption with BCrypt
- Email activation for seller accounts

### 📊 Admin Dashboard
- Manage properties, agents, users, and seller applications
- Approve/reject property listings with feedback messages
- Dashboard statistics (total listings, users, agents, inquiries)
- Inquiry management and agent assignment

### 🏪 Seller Portal
- Seller application form
- Admin approval workflow
- Email notifications for application status
- Seller account activation via secure token link

### 📱 Contact & Communication
- WhatsApp integration for direct contact
- Email notifications via SMTP (Gmail)
- In-app notification system

### 🎨 UI/UX
- Responsive design with TailwindCSS
- AOS (Animate on Scroll) animations
- Video hero background on home page
- Modern, premium dark-mode-ready aesthetics

---

## 📝 License

This project is developed as a final academic project.

---

<p align="center">
  <b>Built by Group 28 for the DEA Project</b>
</p>
