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
- Docker
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

## Running with Docker and GitHub Actions

1. Ensure your self-hosted runner is set up on GitHub. Follow the instructions [here](https://docs.github.com/en/actions/hosting-your-own-runners/adding-self-hosted-runners) to add a self-hosted runner to your repository.


    ```

1. Create a GitHub Actions workflow file in `.github/workflows/ci.yml`:
    ```yaml
    name: CI

    on: [push, pull_request]

    jobs:
      build:
        runs-on: [self-hosted, <your-label>]

        steps:
        - name: Checkout code
          uses: actions/checkout@v2

        - name: Set up Docker Buildx
          uses: docker/setup-buildx-action@v1

        - name: Build Docker image
          run: docker build -t my-java-app .

        - name: Run tests
          run: docker run my-java-app
    ```

   Replace `<your-label>` with the label you assigned to your self-hosted runner.

2. Push the changes to your GitHub repository to trigger the CI workflow.

## Logging

This project uses Log4j for logging. Configuration files can be found in the `src/test/resources` directory.
