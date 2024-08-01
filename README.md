# UI Testing Project with Java, Selenium, and GitHub Actions

## Description

JavaSelenium is a project for automated user interface testing using Selenium and Java. This project follows the Page Factory design pattern and is configured to run on a GitHub server using Docker on a self-hosted runner machine.

## Project Structure

- **src/test/java/core**: Contains base classes for configuring and executing Selenium WebDriver.
- **pom.xml**: Maven configuration file for managing dependencies and building the project.
- **src/test/resources**: Contains Log4j configuration for logging.

## Prerequisites

- Java 8
- Maven
- JUnit
- GitHub Actions

## Installation and Running

1. Clone the repository:
    ```sh
    git clone https://github.com/Nick89QA/JavaJenkinsSeleniumUiTesting.git
    cd JavaJenkinsSeleniumUiTesting
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

3. Run the tests:
    ```sh
    mvn clean test
    ```
4. Generate Allure report:
    ```sh
    mvn allure:report
    ```

## Logging

This project uses Log4j for logging. Configuration files can be found in the `src/test/resources` directory.
