# Docker Setup

Starter project includes Docker support for local development.

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

## 5. Apple Silicon / Intel Notes

This project uses:

```dockerfile
FROM eclipse-temurin:21-jdk-alpine
```

If you see an error like:

```text
exec format error
```

try changing the Dockerfile base image to:

```dockerfile
FROM eclipse-temurin:21-jdk
```

Then rebuild:

```bash
docker compose build --no-cache
docker compose up
```

---

## 6. Common Commands

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

## 7. Troubleshooting

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

## 8. Summary

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
