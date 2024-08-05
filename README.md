# UI Testing Framework with Java and Selenium

## Description

The **Java and Selenium** project is designed for automated user interface testing of web applications using Selenium WebDriver and Java. It provides a robust framework that follows the Page Factory design pattern, making it easier to manage complex page elements. This project is configured to run seamlessly on GitHub Actions runner machines, automatically generating and deploying Allure reports to GitHub.

## Key Features

- **Automated Testing**: Streamline the testing process for web applications.
- **Page Factory Design Pattern**: Improve code maintainability and readability.
- **Continuous Integration**: Automated builds and tests through GitHub Actions.
- **Allure Reporting**: Comprehensive reporting of test results and performance metrics.

## Technologies Used

- **Java 8**
- **Selenium WebDriver**
- **JUnit for Testing**
- **Maven for Dependency Management**
- **GitHub Actions for CI/CD**
- **Allure for Reporting**
- **Log4j for Logging**

## Project Structure

- **.github/workflows**: Contains configuration files for GitHub Actions that build the project, run tests, and deploy Allure reports.
- **src/test/java/core**: Contains base classes for configuring and executing Selenium WebDriver.
- **pom.xml**: Maven configuration file for managing dependencies and building the project.
- **src/test/resources**: Contains Log4j configuration files for logging.

## Prerequisites

- Java 8 or higher
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

3. Run the tests locally:
    ```sh
    mvn test
    ```

4. Generate the Allure report:
    ```sh
    mvn allure:report
    ```

5. Open the Allure report in your browser:
    ```sh
    allure open target/allure-results
    ```

## Logging

This project uses Log4j for logging. Configuration files can be found in the `src/test/resources` directory.

## Contribution

Contributions are welcome! Please open an issue or submit a pull request.

## License

This project is licensed under the MIT License.