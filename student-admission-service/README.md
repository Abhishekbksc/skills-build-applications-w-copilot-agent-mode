# Student Admission Service

A Spring Boot microservices application for managing student admissions for Class 10 and Class 12.

## Features

- Accept student admission requests with validation
- Automatic admission acceptance for Class 10 and 12
- RESTful API endpoints
- H2 in-memory database for data persistence
- Input validation for student details
- Unique email constraint

## Technology Stack

- Java 17
- Spring Boot 3.2.1
- Spring Data JPA
- H2 Database
- Maven
- Bean Validation

## Prerequisites

- Java 17 or higher
- Maven 3.6+

## Running the Application

1. Navigate to the project directory:
```bash
cd student-admission-service
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### 1. Submit Student Admission
**POST** `/api/admissions`

Request Body:
```json
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "phoneNumber": "1234567890",
  "admissionClass": 10
}
```

Response:
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "phoneNumber": "1234567890",
  "admissionClass": 10,
  "admissionStatus": "ACCEPTED",
  "message": "Congratulations John Doe! Your admission has been accepted for Class 10. We look forward to welcoming you to our institution.",
  "createdAt": "2024-01-28T10:30:00"
}
```

### 2. Get All Admissions
**GET** `/api/admissions`

Response: Array of admission records

### 3. Get Admission by ID
**GET** `/api/admissions/{id}`

Response: Single admission record

### 4. Health Check
**GET** `/api/admissions/health`

Response: `Student Admission Service is running!`

## Testing with cURL

### Submit an admission for Class 10:
```bash
curl -X POST http://localhost:8080/api/admissions \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Jane Smith",
    "email": "jane.smith@example.com",
    "phoneNumber": "9876543210",
    "admissionClass": 10
  }'
```

### Submit an admission for Class 12:
```bash
curl -X POST http://localhost:8080/api/admissions \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Robert Johnson",
    "email": "robert.johnson@example.com",
    "phoneNumber": "5551234567",
    "admissionClass": 12
  }'
```

### Get all admissions:
```bash
curl http://localhost:8080/api/admissions
```

### Health check:
```bash
curl http://localhost:8080/api/admissions/health
```

## Validation Rules

- **Name**: Required, cannot be blank
- **Email**: Required, must be valid email format, must be unique
- **Phone Number**: Required, must be exactly 10 digits
- **Admission Class**: Required, must be either 10 or 12

## H2 Database Console

Access the H2 console at: `http://localhost:8080/h2-console`

- JDBC URL: `jdbc:h2:mem:admissiondb`
- Username: `sa`
- Password: (leave blank)

## Project Structure

```
student-admission-service/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/admission/student/
│   │   │       ├── StudentAdmissionServiceApplication.java
│   │   │       ├── controller/
│   │   │       │   └── AdmissionController.java
│   │   │       ├── dto/
│   │   │       │   ├── StudentAdmissionRequest.java
│   │   │       │   └── StudentAdmissionResponse.java
│   │   │       ├── model/
│   │   │       │   └── Student.java
│   │   │       ├── repository/
│   │   │       │   └── StudentRepository.java
│   │   │       └── service/
│   │   │           └── AdmissionService.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
└── pom.xml
```

## License

MIT License
