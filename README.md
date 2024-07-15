# UI testing project with Java, Selenium and GitHub Actions

## Description

JavaSelenium is a project for automated user interface testing using Selenium and Java. The project is designed to run and execute tests in Docker containers, 
providing convenience and cross-platform compatibility.

## Project Structure

- **src/test/java**: Contains test classes and methods.
- **docker-compose.yaml**: Docker Compose configuration file for setting up and running Selenium Grid.
- **pom.xml**: Maven configuration file for managing dependencies and building the project.

## Prerequisites

- Java 8
- Maven
- Junit
- Docker
- Github actions
## Installation and Running

1. Clone the repository:
    ```sh
    git https://github.com/Nick89QA/JavaJenkinsSeleniumUiTesting.git
    cd JavaJenkinsSeleniumUiTesting
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

3. Run the tests:
    ```
    mvn test
    ```


