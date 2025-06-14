# Cadastro Prontuário Health

## Description
Pre-registration system for telemedicine that manages user profiles and addresses. The system handles comprehensive user information including personal data, demographics, health conditions, and contact details.

## Technologies
- Java 17
- Spring Boot 3.4.4
- MySQL 8
- Maven
- SpringDoc OpenAPI
- Lombok
- JPA/Hibernate

## Prerequisites
- Java 17 or higher
- MySQL 8
- Maven

## Setup

### Database Configuration
Configure your MySQL database connection in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://[YOUR_DATABASE_HOST]/[YOUR_DATABASE_NAME]
spring.datasource.username=[YOUR_USERNAME]
spring.datasource.password=[YOUR_PASSWORD]
```

### Building the Project
```bash
./mvnw clean install
```

### Running the Application
```bash
./mvnw spring-boot:run
```

## API Documentation
The API documentation is available through Swagger UI. After starting the application, access:
```
http://localhost:8080/swagger-ui.html
```

## Features
- User registration with comprehensive profile information including:
  - Personal information
  - Address management
  - Health conditions
  - Demographics
  - Employment status
  - Social identifiers

## Project Structure
```
src/main/java/com/telemedicina/pre_cadastro/
├── config/
├── controller/
├── domain/
│   ├── Dto/
│   └── Usuario/
├── repository/
└── service/
```

## Available Endpoints
- User Management: `/usuario`
- Address Management: `/endereco`

For detailed API documentation and available operations, please refer to the Swagger UI documentation.