
FROM maven:3.8.6-openjdk-11-slim AS build

RUN apt-get update && apt-get install -y \
    xvfb \
    && rm -rf /var/lib/apt/lists/*


RUN curl -Lo /usr/local/bin/cm https://github.com/aerokube/cm/releases/download/1.8.1/cm_linux_amd64 && \
    chmod +x /usr/local/bin/cm

WORKDIR /app

COPY . .

CMD ["sh", "-c", "Xvfb :99 -ac & cm selenoid start --vnc --port 5555 & mvn test"]


