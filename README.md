# Quiz Application

A Spring Boot RESTful web application for creating and managing quizzes, and allowing users to take quizzes and calculate their scores. This application provides a robust API for managing questions and quizzes.

## 🚀 Features

- **Question Management**: Complete CRUD operations for quiz questions (add, get all, get by category, update, delete)
- **Category Listing**: Retrieve a list of available question categories
- **Quiz Creation**: Create quizzes by specifying a category, number of questions, and title
- **Quiz Retrieval**: Fetch quiz questions for a given quiz ID
- **Quiz Submission & Scoring**: Submit quiz responses and calculate the user's score
- **API Documentation**: Integrated Swagger/OpenAPI documentation (can be added if not already present)

## 🛠️ Tech Stack

This project leverages a robust set of technologies across different layers to ensure scalability, maintainability, and enterprise-grade performance.

| Category | Technology | Description |
|----------|------------|-------------|
| **Backend** | Java 17+ | Core programming language |
| | Spring Boot 3.x | Opinionated application framework |
| | Spring MVC | Robust web layer framework |
| | Spring Data JPA | Simplified data access layer |
| | Hibernate | Powerful ORM framework |
| | Jakarta Persistence API (JPA) | Standard for object-relational mapping |
| **API Documentation** | Swagger/OpenAPI 3 (Optional) | Interactive API documentation |
| | Swagger UI (Optional) | Web-based API testing interface |
| **Database** | MySQL/PostgreSQL/H2 | Production-ready relational databases |
| **Tools & Libraries** | Lombok | Reduces boilerplate code (e.g., getters/setters) |
| | Maven | Project dependency management and build automation |
| | Spring Boot DevTools | Enhances development productivity and hot-reloading |

## 📦 Key Libraries and Frameworks

The project relies on a curated set of libraries to handle its core functionalities.

| Package | Artifact | Version | Usecase |
|---------|----------|---------|---------|
| `org.springframework.boot` | `spring-boot-starter-web` | 3.5.3* | Core framework for building the web application and RESTful services. |
| `org.springframework.boot` | `spring-boot-starter-data-jpa` | 3.5.3* | Provides JPA support for database operations and entity management. |
| `org.springframework.boot` | `spring-boot-starter-test` | 3.5.3* | Foundational library for unit and integration testing. |
| `org.springframework.boot` | `spring-boot-devtools` | 3.5.3* | Enhances development productivity and hot-reloading capabilities. |
| `com.mysql` | `mysql-connector-j` | (managed)* | MySQL database driver for connecting to MySQL databases. |
| `com.h2database` | `h2` | (managed)* | In-memory database for development and testing purposes. |
| `org.projectlombok` | `lombok` | (managed)* | Reduces boilerplate code for model and entity classes via annotations. |
| `io.swagger.core.v3` | `swagger-annotations` | 2.2.15 | Provides annotations for OpenAPI documentation generation. |
| `org.springdoc` | `springdoc-openapi-starter-webmvc-ui` | 2.2.0 | Generates interactive API documentation with Swagger UI. |
| `org.springframework.boot` | `spring-boot-starter-validation` | 3.5.3* | Provides validation support for request/response data. |

## 📋 Prerequisites

| Requirement | Version/Details |
|-------------|----------------|
| Java | 17 or higher |
| Maven | 3.6+ |
| Database | MySQL 8.0+, PostgreSQL 12+, or H2 (for development) |
| IDE | IntelliJ IDEA, Eclipse, VS Code |
| API Testing Tool | Postman, Insomnia, or curl |

## 🛠️ Installation

### Backend Installation with IntelliJ IDEA

1. Open IntelliJ IDEA and select "Open" project
2. Navigate to the `quizapp` directory
3. Ensure Java 17 is installed and configured
4. Click Run > Run 'QuizApplication' (or the main application class name)

### Backend Installation with VS Code

1. Open VS Code and select "Open Folder"
2. Navigate to the `quizapp` directory
3. Install the "Extension Pack for Java" if not already installed
4. Open the integrated terminal and run:
   ```bash
   mvn spring-boot:run
   ```

### Alternative Installation via Command Line

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/quizapp.git # Replace with your actual repo URL
   cd quizapp
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### Access the Application

The application will typically run on `http://localhost:8080` by default, unless configured otherwise in `application.properties`.

### API Documentation (If Swagger is configured)

Access the Swagger UI at (adjust port and context path if different):
```
http://localhost:8080/swagger-ui.html
```

## 📁 Project Structure

```
quizapp/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/shivamvyas/quizapp/
│   │   │       ├── advice/
│   │   │       │   ├── ErrorDetails.java
│   │   │       │   ├── QuestionControllerAdvice.java
│   │   │       │   └── QuizControllerAdvice.java
│   │   │       ├── exception/
│   │   │       │   ├── QuestionNotFoundException.java
│   │   │       │   └── QuizNotAvailableException.java
│   │   │       ├── model/
│   │   │       │   ├── Question.java
│   │   │       │   ├── QuestionClient.java
│   │   │       │   ├── Quiz.java
│   │   │       │   └── Response.java
│   │   │       ├── repo/
│   │   │       │   ├── IQuestionRepo.java
│   │   │       │   └── IQuizRepo.java
│   │   │       ├── rest/
│   │   │       │   ├── QuestionController.java
│   │   │       │   └── QuizController.java
│   │   │       ├── service/
│   │   │       │   ├── IQuestionService.java
│   │   │       │   ├── IQuizService.java
│   │   │       │   ├── QuestionService.java
│   │   │       │   └── QuizService.java
│   │   │       └── QuizApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## 🎯 Application Flow

### 1. Question Management
- **Add Question**: Add new quiz questions to the database
- **Get All Questions**: Retrieve all questions stored in the system
- **Get Questions by Category**: Filter questions by a specific category
- **Update Question**: Modify existing question details
- **Delete Question**: Remove a question from the database

### 2. Quiz Management
- **Create Quiz**: Generate a new quiz based on category, number of questions, and a title
- **Get Quiz Questions**: Retrieve the questions for a specific quiz, formatted for the client
- **Submit Quiz**: Submit user responses for a quiz and calculate the final score

## 🗄️ Database Schema

### Question Table

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| id | BIGINT | PRIMARY KEY, AUTO_INCREMENT | Unique question identifier |
| question_title | VARCHAR(255) | NOT NULL | The text of the question |
| option1 | VARCHAR(255) | NOT NULL | First answer option |
| option2 | VARCHAR(255) | NOT NULL | Second answer option |
| option3 | VARCHAR(255) | NOT NULL | Third answer option |
| option4 | VARCHAR(255) | NOT NULL | Fourth answer option |
| right_answer | VARCHAR(255) | NOT NULL | The correct answer |
| difficulty_level | VARCHAR(255) | NOT NULL | Difficulty (e.g., "Easy", "Medium", "Hard") |
| category | VARCHAR(255) | NOT NULL | Category of the question (e.g., "Java", "Python") |

### Quiz Table

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| id | BIGINT | PRIMARY KEY, AUTO_INCREMENT | Unique quiz identifier |
| title | VARCHAR(255) | NOT NULL | Title of the quiz |
| questions | ManyToMany Relationship | | List of questions associated with this quiz |

## 🔗 API Endpoints

### Question Controller (`/question`)

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| GET | `/all-questions` | Get all questions | None | List<Question> |
| GET | `/category` | Get all available categories | None | List<String> |
| GET | `/category/{category}` | Get questions by category | None | List<Question> |
| POST | `/add-question` | Add a new question | Question JSON | String |
| PUT | `/update-question/{id}` | Update an existing question by ID | Question JSON | String |
| DELETE | `/delete-question/{id}` | Delete a question by ID | None | String |

### Quiz Controller (`/quiz`)

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| POST | `/create` | Create a new quiz | Query Params: category, numOfQues, title | String |
| GET | `/get/{id}` | Get quiz questions for client | None | List<QuestionClient> |
| POST | `/submit/{id}` | Submit quiz responses and calculate score | List<Response> JSON | String |

## 📝 Request/Response Examples

### Add a Question

```bash
curl -X POST http://localhost:8080/question/add-question \
  -H "Content-Type: application/json" \
  -d '{
    "questionTitle": "What is Spring Boot?",
    "option1": "A framework for building web applications",
    "option2": "A database",
    "option3": "A programming language",
    "option4": "An operating system",
    "rightAnswer": "A framework for building web applications",
    "difficultyLevel": "Easy",
    "category": "Java"
  }'
```

### Create a Quiz

```bash
curl -X POST "http://localhost:8080/quiz/create?category=Java&numOfQues=5&title=Java%20Basics%20Quiz"
```

### Get Quiz Questions

```bash
curl -X GET http://localhost:8080/quiz/get/1
```

### Submit Quiz

```bash
curl -X POST http://localhost:8080/quiz/submit/1 \
  -H "Content-Type: application/json" \
  -d '[
    {
      "id": 1,
      "response": "A framework for building web applications"
    },
    {
      "id": 2,
      "response": "Another answer"
    }
  ]'
```

## ⚙️ Configuration

### Database Configuration (`src/main/resources/application.properties`)

```properties
# Server Configuration
server.port=8080 # Default port, can be changed

# Database Configuration (Example for H2 - good for development)
spring.datasource.url=jdbc:h2:mem:quizdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update # or create-drop, validate, none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

```

## 🔮 Future Enhancements

- [ ] User authentication and authorization for quiz creators and takers
- [ ] Role-based access control (Admin for question management, User for taking quizzes)
- [ ] Timer functionality for quizzes
- [ ] Leaderboard to display top scores
- [ ] More sophisticated question types (e.g., multiple select, true/false)
- [ ] Integration with a frontend framework (e.g., React, Angular, Vue.js)
- [ ] Docker deployment
- [ ] Comprehensive unit and integration tests

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 👨‍💻 Author

**Shivam Vyas**
- GitHub: [@shivam-0718](https://github.com/shivam-0718)
- LinkedIn: [Shivam Vyas](https://linkedin.com/in/shivam-vyas)
- Email: shivam.vyas.1807@gmail.com

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Lombok project for reducing boilerplate code
- All contributors and testers

## 📞 Support

If you encounter any issues or have questions, please:

1. Check the [Issues](https://github.com/yourusername/quizapp/issues) section (replace with your actual repo URL)
2. Create a new issue if your problem isn't already reported
3. Provide detailed information about your environment and the issue

---

**Happy Quizzing! 🎉**