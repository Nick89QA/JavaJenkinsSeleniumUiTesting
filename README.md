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
    mvn test
    ```

## Running with Docker and GitHub Actions

1. Ensure your self-hosted runner is set up on GitHub. Follow the instructions [here](https://docs.github.com/en/actions/hosting-your-own-runners/adding-self-hosted-runners) to add a self-hosted runner to your repository.

2. Create a Dockerfile in the root of your project:
    ```Dockerfile
    # Use the official Maven image to create a build artifact
    FROM maven:3.8.5-openjdk-11-slim AS build

    # Set the working directory
    WORKDIR /app

    # Copy the Maven configuration file
    COPY pom.xml .

    # Download the project dependencies
    RUN mvn dependency:go-offline -B

    # Copy the project source code
    COPY src ./src

    # Build the project and run tests
    RUN mvn clean install

    # Second stage: minimal image with JRE to run the application
    FROM openjdk:11-jre-slim

    # Set the working directory
    WORKDIR /app

    # Copy the built artifacts from the first stage
    COPY --from=build /app/target /app/target

    # Command to run the tests
    CMD ["java", "-jar", "target/your-app.jar"]
    ```

3. Create a GitHub Actions workflow file in `.github/workflows/ci.yml`:
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

4. Push the changes to your GitHub repository to trigger the CI workflow.

## Logging

This project uses Log4j for logging. Configuration files can be found in the `src/test/resources` directory.
