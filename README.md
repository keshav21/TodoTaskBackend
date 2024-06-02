# TodoTaskBackend

![GitHub repo size](https://img.shields.io/github/repo-size/keshav21/TodoTaskBackend) ![GitHub stars](https://img.shields.io/github/stars/keshav21/TodoTaskBackend?style=social) ![GitHub forks](https://img.shields.io/github/forks/keshav21/TodoTaskBackend?style=social) ![GitHub issues](https://img.shields.io/github/issues/keshav21/TodoTaskBackend) ![GitHub pull requests](https://img.shields.io/github/issues-pr/keshav21/TodoTaskBackend)

This is the backend for the TodoTask application, built with [Java Spring Boot](https://spring.io/projects/spring-boot).

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Usage](#usage)
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
java -jar target/TodoTaskBackend-1.0.0.jar
```

## Usage

To use TodoTaskBackend, you can interact with its RESTful API endpoints. Here are some example endpoints:

- **GET api/todo/get/all: Get all tasks.
- **POST /api/todo/create: Create a new task.
- **PUT /api/todo/update: Update an existing task.
- **POST /api/todo/cancel/{id}: Cancel a task by ID.
- **DELETE /api/todo/delete/{id}: Delete a task by ID.


## License

This project is licensed under the [MIT License](LICENSE).

---
