# CLI Usage

SpringGen Starter can be used from the command line to generate Spring Boot backend projects quickly.

The CLI is intended for the free Starter flow.

---

## Install

Install SpringGen globally using npm:

```bash
npm install -g springgen
```

Verify installation:

```bash
springgen --version
```

---

## Generate a Starter Project

```bash
springgen init my-app --db=postgres
```

This generates a Spring Boot project in a new folder:

```text
my-app/
```

---

## Basic Usage

```bash
springgen init <project-name> --db=<database>
```

Example:

```bash
springgen init inventory-service --db=postgres
```

---

## Supported Databases

```bash
--db=postgres
--db=mysql
--db=mongo
```

Examples:

```bash
springgen init order-service --db=postgres
springgen init user-service --db=mysql
springgen init catalog-service --db=mongo
```

---

## Generated Project Includes

The free Starter project includes:

* Spring Boot backend structure
* Controller / Service / Repository layers
* DTO structure
* Global exception handling
* JWT authentication scaffold
* Database configuration
* Dockerfile
* Docker Compose local setup
* Basic GitHub Actions CI workflow

---

## Run the Generated Project

After generation:

```bash
cd my-app
```

Run locally:

```bash
./gradlew bootRun
```

Or run with Docker:

```bash
docker-compose up --build
```

The application starts at:

```text
http://localhost:8080
```

---

## Health Check

```bash
curl http://localhost:8080/health
```

Expected response:

```text
200 OK
```

---

## Environment Configuration

The generated project includes an `.env` file.

Update database values before running if needed:

```env
DB_HOST=localhost
DB_PORT=5432
DB_NAME=my_db
DB_USER=postgres
DB_PASSWORD=postgres
```

For Docker, the application container uses:

```env
DB_HOST=db
```

as configured in `docker-compose.yml`.

---

## Pro Features

The CLI currently supports the free Starter generation flow.

SpringGen Pro is available through the web app:

```text
https://app.springgen.dev
```

Pro includes:

* OAuth2 authentication
* Refresh token flow
* Production configuration
* AWS EC2 deployment automation
* Full CI/CD deployment workflow
* Logging and observability
* Security hardening

---
## How this npm Package Works

npm package acts as a command-line wrapper for SpringGen.

It sends your selected project configuration to the SpringGen API, downloads the generated ZIP file, and extracts it locally.

For free Starter generation, SpringGen may use a locally generated device ID to prevent abuse.

The CLI does not collect:

* Local source code
* Environment variables
* Secrets
* Existing project files

## Troubleshooting

### Command Not Found

If you see:

```text
zsh: command not found: springgen
```

try reinstalling:

```bash
npm install -g springgen
```

Then check npm global bin path:

```bash
npm bin -g
```

Make sure the npm global bin directory is in your system `PATH`.

---

### Docker Issues

If Docker fails, check:

```bash
docker --version
docker-compose --version
```

Then rerun:

```bash
docker-compose down -v
docker-compose up --build
```

---

### Database Connection Issues

Check your `.env` values.

For Docker-based runs, make sure `DB_HOST=db`.

For local `./gradlew bootRun`, use:

```env
DB_HOST=localhost
```

---

## Support

For support, contact:

```text
support@springgen.dev
```
