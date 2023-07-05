# SIRCLO | Backend Technical Test
## **Consists of 2 parts:**
- Data Structure (Cart)
- Backend Engineering (Berat)

## **Data Sctructure**
> Answered in 3 languages: Python, Java, and Golang.

Each language will contain 3 files: 
- **cart**: The cart class / data sctructure file.
- **main**: The driver file to run the main program.
- **run-bat**: Provided to easily run the program.

To run the program, You can cd to any of the language folder, and then run the run-bat file.

## **Backend Engineering**
> Answered in 3 language: Python, NodeJS, and Java.
> Assuming Frontend is not graded so there will be minimum CSS.

### Python
In this program I use the MVC Architecture (model, view, controller).
The techstack in this program is Flask to render the views (fullstack framework). Therefore, no database is needed as the data is stored in a dictionary inside the flask program.

To run the program, just run the main.py or the run.bat provided in the root folder for the Python. The program will be available in localhost port 5000.

For automated testing, I use the unittesting library from Python. to run it just run the test.py

Project Status: **Done**

### NodeJS
Assuming the date is unique (primary key).

In this program I use the MVC Architecture (model, view, controller).
The techstack in this program is Express that set its engine to ejs files to render the views (fullstack framework). 

Using **MySQL or MariaDB** as database. Url source can be configured in the db folder.

To run the program, just use npm start. The program will run on localhost:8000.

For automated testing, i use the sinon and mocha library. to run it use npm test.

Project Status: **Done**

### Java
In this program I use the Spring boot framework, so Backend and Frontend is separate. I tried to apply the Solid Principles and use as models (entity), service, controller, and repository.

Using **MySQL or MariaDB** as database. Url source can be configured in the application properties file

Project Status: **Not Done** As there is no Frontend side for the application, due to time reaching the deadline of the task is close. (Waktu habis untuk deadline).
**I Recommend using the Python for the program** 
