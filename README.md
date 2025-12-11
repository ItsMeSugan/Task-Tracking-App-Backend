🗂️ Task Manager Application – Backend

Built with Java, Spring Boot, and MySQL (Dockerized)

This is the backend service for a Task Manager Application that allows users to create multiple task lists, add tasks inside each list, track completion status, and view real-time progress percentages.
The application uses Spring Boot for REST APIs and MySQL (running via Docker) as the database.

▶️ Running the Application
1. Start MySQL (Docker)
Make sure your MySQL container is running.

2. Run Spring Boot App
Using Maven:
mvn spring-boot:run
Or using your IDE (IntelliJ / Eclipse).

Task List APIs
Method	Endpoint	Description
POST	/api/task-lists	Create a task list
GET	/api/task-lists	Get all task lists
GET	/api/task-lists/{task_list_id}	Get a single task list
PUT	/api/task-lists/{task_list_id}	Update task list
DELETE	/api/task-lists/{task_list_id}	Delete task list


Task APIs
Method	Endpoint	Description
POST	/api/task-lists/{task_list_id}/tasks	Add task to task list
GET	/api/task-lists/{task_list_id}/tasks	Get all tasks in a list
GET	/api/task-lists/{task_list_id}/tasks/{task_id}	Get a single task
PUT	/api/task-lists/{task_list_id}/tasks/{task_id}	Update task
DELETE	/api/task-lists/{task_list_id}/tasks/{task_id}	Delete task


🚀 Features
✔️ Task List Management

Create multiple task lists individually

Each list contains its own set of tasks

✔️ Task Operations

Add tasks under a specific list

Mark tasks as completed / not completed

Delete or update tasks

📊 Progress Tracking

Automatically calculates percentage complete for each task list

Progress bar (for frontend) can display list completion visually

Helps users track productivity easily

🗄️ Database

MySQL database running in Docker

Persistent storage using Docker volumes

🔌 RESTful APIs



Clean and consistent REST endpoints

Follows best practices for maintainable backend structure
