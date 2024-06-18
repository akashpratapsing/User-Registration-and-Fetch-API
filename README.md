# User Registration and Fetch API

This project implements a RESTful API using Spring Boot for user registration and fetching user details. It includes proper exception handling, security best practices, and documentation with Swagger.

## Prerequisites
- Java 11 or higher
- Maven 3.6.3 or higher

## Getting Started

### Clone the Repository
```bash
git clone https://github.com/akashpratapsing/User-Registration-and-Fetch-API.git
cd user-registration-api
```

### Build and Run the Application
```bash
mvn clean install
mvn spring-boot:run
```
The application will start on http://localhost:8080.

## Project Structure
```
src
├── main
│   ├── java
│   │   └── com
│   │       └── task
│   │           └── userregistration
│   │               ├── controller
│   │               │   └── UserController.java
│   │               ├── exception
│   │               │   └── ResourceNotFoundException.java
│   │               │   └── GlobalExceptionHandler.java
│   │               │   └── ErrorDetails.java
│   │               ├── entity
│   │               │   └── User.java
│   │               ├── repository
│   │               │   └── UserRepository.java
│   │               ├── service
│   │               │   └── impl
|   |               |   │   └── UserServiceImpl.java
│   │               │   └── UserService.java
│   │               │   └── UserService.java
│   │               ├── config
│   │               │   └── SecurityConfig.java
|   |               |   └── OpenAPIConfig.java
│   │               ├── payload
│   │               │   └── UserDTO.java
|   |               │   └── ApiResponse.java    
│   │               └── TaskApiApplication.java
│   └── resources
│       └── application.properties
└── test
    └── java
        └── com
            └── task
                └── TaskApplicationTests
                    
```

## Dependencies
Add the following dependencies in `pom.xml`:

```xml
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.5.0</version>
		</dependency>
	</dependencies>
```

## API Endpoints
1. **Register User**
   - URL: `/api/user/register`
   - Method: `POST`
  ## Endpoints

### 1. Register User

- **URL**: `/api/user/register`
- **Method**: `POST`
- **Description**: Registers a new user.
- **Request Body**:
    ```json
    {
        "username": "john_doe",
        "email": "john@example.com",
        "password": "password123"
    }
    ```
- **Responses**:
    - **Success**: `200 OK`
        ```json
        {
            "id": 1,
            "username": "john_doe",
            "email": "john@example.com"
        }
        ```
    - **Failure**: `400 Bad Request`
        ```json
        {
            "message": "User Already exist with this email !"
        }
        ```

#### cURL Command

```sh
curl -X POST "http://localhost:8080/api/user/register" -H "Content-Type: application/json" -d '{
    "username": "john_doe",
    "email": "john@example.com",
    "password": "password123"
}'

```


2. **Fetch User Details**
   - **URL**: `/api/user/fetch`
   - **Method:** `GET`
   - **Description**:Fetches user details by username.
   - **Query Parameter**:
        - `username` (required): The username of the user to fetch.
- **Responses**:
    - **Success**: `200 OK`
        ```json
        {
            "id": 1,
            "username": "john_doe",
            "email": "john@example.com"
        }
        ```
    - **Failure**: `400 Bad Request`
        ```json
        {
             "message": "User not found with username : john_doe"
        }
        ```
  #### cURL Command
```sh

curl -X GET "http://localhost:8080/api/user/fetch?username=john_doe" -H "Content-Type: application/json"

```


## Exception Handling
The `ResourceNotFoundException` class is used to handle cases where a requested resource is not found. It extends `RuntimeException` and provides meaningful error messages.

## Security
Basic security is implemented using Spring Security. Passwords are hashed using `BCryptPasswordEncoder`.

## Documentation
Swagger is used for API documentation. Once the application is running, access the documentation at http://localhost:8080/swagger-ui/index.html.

```

This Markdown file provides a comprehensive overview of the User Registration and Fetch API project, including prerequisites, project structure, dependencies, API endpoints, exception handling, security, documentation and licensing information.
