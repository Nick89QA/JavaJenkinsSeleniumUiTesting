# UI testing project with Java, Selenium and GitHub Actions

## Description

JavaJenkinsSeleniumUiTesting is a project for automated user interface testing using Selenium and Java. The project is designed to run and execute tests in Docker containers, providing convenience and cross-platform compatibility.

## Project Structure

- **src/test/java**: Contains test classes and methods.
- **docker-compose.yaml**: Docker Compose configuration file for setting up and running Selenium Grid.
- **pom.xml**: Maven configuration file for managing dependencies and building the project.

## Prerequisites

- Java 8 or higher
- Maven
- Docker
- Docker Compose

## Installation and Running

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/JavaJenkinsSeleniumUiTesting.git
    cd JavaJenkinsSeleniumUiTesting
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

3. Start Docker Compose to set up Selenium Grid:
    ```sh
    docker-compose up -d
    ```

4. Run the tests:
    ```sh
    mvn test
    ```

## Docker Compose Configuration

The `docker-compose.yaml` file is used to configure and start the Selenium Grid containers. It defines the following services:

- **selenium-hub**: The central hub of Selenium Grid.
- **chrome**: A node with the Chrome browser.
- **firefox**: A node with the Firefox browser.

```yaml
version: "3"
services:
  selenium-hub:
    image: selenium/hub:4.0.0
    platform: linux/amd64
    ports:
      - "4444:4444"

  chrome:
    image: selenium/node-chrome:4.0.0
    platform: linux/amd64
    depends_on:
      - selenium-hub
    environment:
      - SE_OPTS=-enable-logging
      - HUB_HOST=selenium-hub
      - HUB_PORT=4444
      - START_XVFB=false
    volumes:
      - /dev/shm:/dev/shm

  firefox:
    image: selenium/node-firefox:4.0.0
    platform: linux/amd64
    depends_on:
      - selenium-hub
    environment:
      - HUB_HOST=selenium-hub
      - HUB_PORT=4444
    volumes:
      - /dev/shm:/dev/shm
