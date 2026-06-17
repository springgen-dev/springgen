# Docker Setup

This project includes Docker support for local development.

---

## 1. Local Docker Setup

Use this for development on your machine.

### Step 1: Check `.env`

The project includes a `.env` file.

Example:

```env
APP_NAME=my-app
SERVER_PORT=8080
SPRING_PROFILES_ACTIVE=local

DB_HOST=localhost
DB_PORT=5432
DB_NAME=my_db
DB_USER=postgres
DB_PASSWORD=postgres
```

For Docker, the application container automatically uses:

```env
DB_HOST=db
```

as configured in `docker-compose.yml`.

### Step 2: Start Application and Database

```bash
docker compose up --build
```

Application will run at:

```text
http://localhost:8080
```

### Step 3: Test Health Endpoint

```bash
curl http://localhost:8080/health
```

---

## 2. If Port Is Already in Use

If you see:

```text
bind: address already in use
```

change the ports in `.env`.

Example:

```env
SERVER_PORT=8081
DB_PORT=5433
```

Then rerun:

```bash
docker compose down
docker compose up --build
```

---

## 3. Reset Local Database

To remove containers and database volumes:

```bash
docker compose down -v
```

Then start again:

```bash
docker compose up --build
```

---

## 4. Docker Image Naming

Docker image names must be lowercase.

Valid:

```text
my-app:latest
```

Invalid:

```text
MyApp:latest
```

If you rename the application image, use lowercase letters, numbers, and hyphens only.

---

## 5. Docker Base Image Notes

This project uses a multi-stage Docker build.

The build stage uses the full JDK:

```dockerfile
FROM eclipse-temurin:21-jdk-alpine AS build
```

This stage is responsible for:

- downloading Gradle dependencies
- compiling the application
- running the Gradle build
- creating the Spring Boot JAR

After the build completes, only the generated JAR is copied into the runtime image.

The runtime stage uses:

```dockerfile
FROM eclipse-temurin:21-jre-alpine
```

The final container includes only:

```text
Java Runtime (JRE)
+
Spring Boot application JAR
```

It does not include:

```text
source code
Gradle cache
build files
JDK compiler tools
local project files
```

This keeps the production image:

- smaller
- faster to download
- safer to run

---

### Apple Silicon / Intel Notes

The default Alpine images support common platforms.

If you see an error like:

```text
exec format error
```

try changing the Docker base images from Alpine to standard images.

Change:

```dockerfile
FROM eclipse-temurin:21-jdk-alpine AS build
```

to:

```dockerfile
FROM eclipse-temurin:21-jdk AS build
```

and:

```dockerfile
FROM eclipse-temurin:21-jre-alpine
```

to:

```dockerfile
FROM eclipse-temurin:21-jre
```

Then rebuild:

```bash
docker compose build --no-cache
docker compose up
```

---

## 6. Docker Build Context

This project includes a `.dockerignore` file.

The `.dockerignore` file prevents unnecessary or sensitive files from being sent to Docker during image builds.

Excluded examples:

```text
.git
.gradle
build
out
target

.idea
.vscode
*.iml

.env
.env.*

docker-compose.yml
docker-compose.prod.yml
```

Benefits:

- prevents accidentally copying secrets into images
- reduces Docker build context size
- improves build performance
- keeps generated images cleaner

Only the required files are copied:

```text
gradlew
gradle/
build.gradle
settings.gradle
src/
```

The final Docker image contains only:

```text
app.jar
+
Java runtime
```

---

## 7. Common Commands

### Start Local Environment

```bash
docker compose up --build
```

### Stop Local Environment

```bash
docker compose down
```

### Reset Local Database

```bash
docker compose down -v
```

### Rebuild Without Cache

```bash
docker compose build --no-cache
```

### View Logs

```bash
docker compose logs -f app
docker compose logs -f db
```

---

## 8. Troubleshooting

### Database Does Not Exist

Check `.env`:

```env
DB_NAME=my_db
```

Then reset:

```bash
docker compose down -v
docker compose up --build
```

### Port Already in Use

Change `.env`:

```env
SERVER_PORT=8081
DB_PORT=5433
```

### Application Cannot Connect to Database

Make sure `docker-compose.yml` contains:

```yaml
environment:
  DB_HOST: db
```

Do not use `localhost` inside the application container to connect to the database container.

---

## 9. Summary

Start the local environment:

```bash
docker compose up --build
```

Application:

```text
http://localhost:8080
```

Health Check:

```bash
curl http://localhost:8080/health
```

