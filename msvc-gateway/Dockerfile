# --- ETAPA 1: Compilación temporal ---
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copiar el wrapper de Maven y configuraciones
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Descargar dependencias en caché
RUN ./mvnw dependency:go-offline

# Copiar código fuente y compilar omitiendo tests para agilizar el despliegue
COPY src ./src
RUN ./mvnw clean package -DskipTests

# --- ETAPA 2: Imagen final ligera de ejecución ---
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# NOTA: Docker sustituirá de forma dinámica el nombre del JAR usando la variable JAR_FILE en el docker-compose
ARG JAR_NAME
COPY --from=build /app/target/msvc-gateway-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]