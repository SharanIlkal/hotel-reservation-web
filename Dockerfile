# ---------- builder stage ----------
FROM maven:3.9.3-eclipse-temurin-17 as builder
WORKDIR /build

# copy pom and sources
COPY pom.xml .
COPY src ./src

# skip tests and build the fat jar
RUN mvn -B -DskipTests clean package

# ---------- runtime stage ----------
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# copy the jar produced by the builder stage
COPY --from=builder /build/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]

