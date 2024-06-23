# Use an official OpenJDK runtime as a parent image
FROM openjdk:11

# Set the working directory
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Install necessary tools
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get install -y curl unzip xvfb

# Download and install Google Chrome
RUN curl -sSL https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb -o chrome.deb && \
    apt-get install -y ./chrome.deb && \
    rm chrome.deb

# Download and install ChromeDriver
RUN CHROME_DRIVER_VERSION=`curl -sS chromedriver.storage.googleapis.com/LATEST_RELEASE` && \
    curl -sS -L https://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_linux64.zip -o chromedriver.zip && \
    unzip chromedriver.zip -d /usr/local/bin/ && \
    rm chromedriver.zip

# Add Chromedriver to the PATH
ENV PATH /usr/local/bin:$PATH

# Add a non-root user to run tests
RUN useradd -m selenium
USER selenium

# Install project dependencies and build the project
RUN mvn clean install

# Define environment variable to use XVFB
ENV DISPLAY=:99

# Run the tests
CMD ["sh", "-c", "Xvfb :99 -ac & mvn test"]
