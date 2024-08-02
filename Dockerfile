FROM maven:3.8.5-openjdk-8

# Копируем проект в контейнер
COPY . /app
WORKDIR /app

# Сборка проекта и запуск тестов
RUN mvn clean install && mvn test
