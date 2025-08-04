FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

# Installer Maven dans le conteneur
RUN apt-get update && apt-get install -y maven

# Compiler ton projet sans les tests
RUN mvn clean package -DskipTests

EXPOSE 8080


CMD ["java", "-jar", "target/springboot-jwt-project-0.0.1-SNAPSHOT.jar", "--spring.config.name=application-docker"]

