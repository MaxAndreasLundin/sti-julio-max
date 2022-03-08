Spring boot project for the course Java B.

Welcome to Max & Julios wondrous magic show. Follow the instructions below to witness the magic!!!

1. You will need docker installed on your computer. Download Docker Desktop
   here, https://www.docker.com/products/docker-desktop
2. Start Docker Desktop.
3. Navigate to the root of the project folder with your favorite terminal. The terminal will not be interactive, you
   will need 3 terminal windows.
4. In your first terminal window enter ./postgres-start.sh. This will download the correct image if it's missing and
   start the postgres server in a docker container.
5. In your second terminal window enter ./docker-build.sh. This will compile the project and create a docker image.
6. In your second terminal window enter ./docker-start.sh. This will start the docker image you created in the previous
   step.
7. The application is now running in a docker container. To access the application open your web browser and
   enter http://localhost:8080/swagger-ui.html.
8. Use your remaining terminal window to close the application by first running ./docker-stop.sh.
9. Use your remaining terminal window to close the server by running ./postgres-stop.sh.

----Info----   
We populate the server on application startup with test data using Hibernate. It can be seen in the class
InitialDataConfig.

For logging example check CourseController. We are using Lombok annotation @Slf4j and log.info in the appropriate
methods.

When creating a student in the swagger ui remember to remove the object course. There's a separate method to add/remove
a students courses. 
Under courses remove the curly brackets and everything inside.

"id": 0,
"name": "string",
"surname": "string",
"courses": [
   {
   "id": 0,
   "points": 0,
   "hours": 0 
   }
]

