# TodoTaskBackend

![GitHub repo size](https://img.shields.io/github/repo-size/keshav21/TodoTaskBackend) ![GitHub stars](https://img.shields.io/github/stars/keshav21/TodoTaskBackend?style=social) ![GitHub forks](https://img.shields.io/github/forks/keshav21/TodoTaskBackend?style=social) ![GitHub issues](https://img.shields.io/github/issues/keshav21/TodoTaskBackend) ![GitHub pull requests](https://img.shields.io/github/issues-pr/keshav21/TodoTaskBackend)

This is the backend for the TodoTask application, built with [Java Spring Boot](https://spring.io/projects/spring-boot).

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Database Setup](#database-setup)
- [Usage](#usage)
- [Docker Deployment](#docker-deployment)
- [License](#license)

## Introduction

TodoTaskBackend is a RESTful API backend for managing todo tasks. It provides endpoints to create, read, update, and delete tasks. This backend is built using Spring Boot framework in Java.

## Features

- RESTful API endpoints for managing todo tasks.
- CRUD (Create, Read, Update, Delete) operations for tasks.
- Secure authentication and authorization mechanisms.

## Prerequisites

Before you begin, ensure you have met the following requirements:
- Java Development Kit (JDK) 17 or later installed.
- Maven build tool installed.
- Postgres Running and DB and table is created.
- Docker installed (optional, for running with Docker).

## Getting Started

To get started with TodoTaskBackend, follow these steps:

1. Clone the repository:

```bash
git clone https://github.com/keshav21/TodoTaskBackend.git
```

2. Navigate to the project directory:

```bash
cd TodoTaskBackend
```

3. Build the project using Maven:

```bash
mvn clean package
```

4. Run the application:

```bash
java -jar target/todo-app-1.0.0-SNAPSHOT.jar
```

## Database Setup

Follow these steps to set up the PostgreSQL database for TodoTaskBackend:

1. **Install PostgreSQL:**

   Download and install PostgreSQL from the [official website](https://www.postgresql.org/download/). Follow the installation instructions for your operating system.

2. **Start PostgreSQL Server:**

   Start the PostgreSQL server. The default port is 5432.

3. **Create Database:**

   Open a terminal or command prompt and run the following command to access the PostgreSQL command-line interface:

   ```sh
   psql -U postgres
   ```

   Replace `postgres` with your PostgreSQL username if different.

4. **Create Database:**

   In the PostgreSQL command-line interface, run the following SQL command to create a new database named `todo_db`:

   ```sql
   CREATE DATABASE todo_db;
   ```

   You can choose a different name for the database if desired.

5. **Create Database User:**

   Run the following SQL command to create a new user named `todo_user` with password `todopassword` and grant access to the `todo_db` database:

   ```sql
   CREATE USER todo_user WITH PASSWORD 'todopassword';
   GRANT ALL PRIVILEGES ON DATABASE todo_db TO todo_user;
   ```

   You can choose a different username and password if desired.
   
6. **Create Database Table:**
   
    Run the following SQL command to create table in the database:

   ```sql
    CREATE TABLE todo_item (
    id UUID PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    due_date TIMESTAMP,
    priority VARCHAR(50),
    status VARCHAR(50),
    recurring_type VARCHAR(50),
    canceled BOOLEAN,
    recurring BOOLEAN
     );
   ```

   
7. **Configure Application:**

   Update the `application.yml` file in the TodoTaskBackend project with the database connection details:

   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/todo_db
       username: todo_user
       password: todopassword
       driver-class-name: org.postgresql.Driver
   ```

   Adjust the URL, username, and password according to your PostgreSQL configuration.

## Usage

To use TodoTaskBackend, you can interact with its RESTful API endpoints. Here are some example endpoints:

- **GET api/todo/get/all: Get all tasks.
- **POST /api/todo/create: Create a new task.
- **PUT /api/todo/update: Update an existing task.
- **POST /api/todo/cancel/{id}: Cancel a task by ID.
- **DELETE /api/todo/delete/{id}: Delete a task by ID.

## Docker Deployment

To deploy this application using Docker, follow these steps:

1. Clone this repository:
   ```
git clone https://github.com/keshav21/TodoTaskBackend.git
   ```

2. Navigate to the cloned directory:
   ```
cd TodoTaskBackend
   ```

3. Build the Docker image:
   ```
docker build -t todo-task-backend .
   ```

4. Run the Docker container:
   ```
docker run -p 8080:8080 todo-task-backend
   ```

## Kubernetes Deployment

To deploy this application on Kubernetes, follow these steps:

1. Ensure you have a Kubernetes cluster set up and `kubectl` configured.

2. Clone this repository:
   ```
git clone https://github.com/keshav21/TodoTaskBackend.git
   ```

3. Navigate to the cloned directory:
   ```
cd TodoTaskBackend
   ```

4. Apply the Kubernetes deployment and service YAML files:
   ```
kubectl apply -f deployment.yaml
kubectl apply -f service.yaml
   ```

5. Apply the Kubernetes Ingress YAML file (if using Ingress):
   ```
kubectl apply -f ingress.yaml
   ```

6. Access the application using the appropriate URL.

```

## License

This project is licensed under the [MIT License](LICENSE).

---

