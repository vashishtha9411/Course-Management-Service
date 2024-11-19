*COURSE MANAGEMENT SYSTEM*
The Course Management System is a Spring Boot-based web application designed to manage teachers, students, courses, and enrollments in an educational setup. This application provides functionality for creating, updating, and deleting students, teachers, and courses, as well as enrolling students in courses. It ensures validation such as preventing a student from enrolling in a course multiple times.

*Features*
1.Manage students and teachers
2.Assign teachers to courses
3.Enroll students in courses, with validation to ensure no duplicate enrollments
4.Track the number of courses per teacher
5.CRUD operations for all entities (Student, Teacher, Course, Enrollment)
6.API documentation using Postman


*Prerequisites*
Java 21
Maven (for dependency management)
MySQL 
IDE (IntelliJ IDEA or any IDE that supports Java and Spring Boot)


*Setup and Installation*
1.Clone the repository: Clone this repository to local machine using the following command:
  git clone " https://github.com/yourusername/course-management-system.git"

2.Import the project: Open IntelliJ IDEA, click on "Open," and select the cloned repository.

3.Set up the database:
If using MySQL, create a database and update the connection settings in application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/cms
spring.datasource.username=root
spring.datasource.password=password


4.Build the project: Run the following Maven command to install dependencies and build the project:

"mvn clean install"

5.Run the application: Start the application by running the following command:

"mvn spring-boot:run"
The server will run on http://localhost:8081.

*API Documentation*
1. POST URL= " http://localhost:8081/teachers"
Description:
This endpoint is used to create a new teacher in the system. You need to provide the teacher's name and an optional courseCount (which will default to 0).

Request:
Method: POST
URL: /teachers
Headers:
Content-Type: application/json
Request Body:(This is the json code)

{
  "name": "John Doe",
  "courseCount": 0
}

# name (String): The name of the teacher.
# courseCount (int, optional): The initial number of courses assigned to the teacher. If not provided, it defaults to 0.

Response:
Status Code: 201 Created
Response Body:

{
  "id": 1,
  "name": "John Doe",
  "courseCount": 0
}

#.id (Long): The unique ID assigned to the teacher.
#.name (String): The name of the teacher.
#.courseCount (int): The number of courses assigned to the teacher.

*Request in Postman:*
1.Open Postman.
2.Select POST as the HTTP method.
3.Enter the URL: http://localhost:8080/api/teachers
4.Go to the Body tab in Postman, select raw, and choose JSON as the format.
5.Paste the following JSON:

{
  "name": "John Doe",
  "courseCount": 0
}

6.Click Send.
