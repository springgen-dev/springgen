# SpringGen — Generate Spring Boot Backends in Minutes 🚀  [![npm](https://img.shields.io/npm/v/springgen)](https://www.npmjs.com/package/springgen)[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

Generate ready-to-run Spring Boot backend projects instantly — from local development setup to production deployment foundations.

**Free Starter via CLI** • **[🚀 Upgrade to Pro](https://app.springgen.dev)**

---

## What is SpringGen?

SpringGen is a developer productivity tool that creates fully structured Spring Boot backend projects so you do not waste time on repetitive boilerplate setup.

Instead of spending hours configuring:

* Spring Boot project structure
* Authentication scaffolding
* Docker setup
* Database configuration
* CI/CD pipeline setup
* Deployment configuration

you can generate a working backend project in seconds.

Think of it as:

> Create React App — but for Spring Boot backend projects.

SpringGen is not just a template pack. It is a generator platform with a CLI and web UI that dynamically builds project structures based on selected configuration options.

---

## Why Developers Use SpringGen

* Save hours of setup time
* Start with a real backend structure
* Use clean layered architecture
* Get Docker and CI setup quickly
* Focus on business logic instead of boilerplate
* Go from idea to working backend faster

---

## Starter vs Pro

| Feature                                  | Starter |                Pro |
|------------------------------------------|--------:|-------------------:|
| Price                                    |    Free | $29 launch pricing |
| Spring Boot structure                    |       ✅ |                  ✅ |
| Controller / Service / Repository layers |       ✅ |                  ✅ |
| DTO structure                            |       ✅ |                  ✅ |
| Global exception handling                |       ✅ |                  ✅ |
| JWT authentication scaffold              |       ✅ |                  ✅ |
| Dockerfile                               |       ✅ |                  ✅ |
| Docker Compose local setup               |       ✅ |                  ✅ |
| Basic GitHub Actions CI                  |       ✅ |                  ✅ |
| OAuth2 authentication                    |       ❌ |                  ✅ |
| Refresh token flow                       |       ❌ |                  ✅ |
| Production configuration                 |       ❌ |                  ✅ |
| AWS EC2 deployment automation            |       ❌ |                  ✅ |
| Full CI/CD deployment workflow           |       ❌ |                  ✅ |
| Logging and observability setup          |       ❌ |                  ✅ |
| Security hardening                       |       ❌ |                  ✅ |


---
## Pro — Production Ready

SpringGen Pro adds production-focused features for developers building deployable backend systems.

Pro includes:

### Production Authentication

* OAuth2 login with Google and GitHub
* JWT access tokens
* Refresh token flow
* Secure authentication structure

👉 No need to build auth from scratch

### Cloud Deployment

* AWS EC2 deployment script
* Production Docker setup
* Environment-based deployment configuration

👉 Deploy your backend in minutes

### Full CI/CD

* GitHub Actions build workflow
* GitHub Actions deployment workflow
* Production deployment automation

👉 No DevOps setup needed

### Security Hardening

* CORS configuration
* Security headers
* Request filtering
* Production-ready security configuration foundation

👉 Safer defaults out of the box

### Logging and Observability

* Request logging
* Structured logging setup
* Production-friendly logging configuration

### 🚀 Upgrade to SpringGen Pro

Generate production-ready Spring Boot projects instantly:

👉 https://app.springgen.dev

Current launch pricing:

**$29 one-time purchase**

Includes:

- OAuth2 authentication
- Refresh token flow
- Production configuration
- AWS deployment automation
- CI/CD workflows
- Security hardening

---
## Try SpringGen Free (Starter CLI)

The Starter edition is free and available through the CLI.

It is designed for:

* Local development
* MVP projects
* Backend scaffolding
* Learning project structure
* Quickly starting Spring Boot APIs

### Install

```bash
npm install -g springgen
```

### Generate a Project

```bash
springgen init my-app --db=postgres
```

### Supported Databases

```bash
--db=postgres
--db=mysql
--db=mongo
```

### Run the Generated Project

```bash
cd my-app
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

## Who is SpringGen For?

SpringGen is useful for:

* Backend developers building SaaS products
* Freelancers delivering client backend systems
* Startup founders who need to ship quickly
* Engineers tired of repetitive setup work
* Developers building portfolio-ready projects
* Java/Spring developers who want a faster starting point

SpringGen may not be ideal for:

* Beginners expecting step-by-step Spring Boot tutorials
* Developers who want to manually configure every file from scratch
* Teams needing fully custom enterprise architecture generation

---

## How It Works

```text
CLI or UI sends project configuration
↓
SpringGen backend validates requested tier
↓
Generator engine builds project dynamically
↓
Starter or Pro modules are applied
↓
ZIP project is generated
↓
User downloads and runs the project
```
---
## Example Generated Project Structure

```text
my-app/
├── src/main/java/com/example/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── dto/
│   ├── config/
│   ├── security/
│   └── Application.java
│
├── src/main/resources/
│   ├── application.yml
│   └── application-prod.yml          # Pro
│
├── Dockerfile
├── docker-compose.yml
├── docker-compose.prod.yml           # Pro
│
├── .github/workflows/
│   ├── ci.yml
│   └── cd.yml                        # Pro
│
├── scripts/
│   └── deploy-ec2.sh                 # Pro
│
├── .env
└── .env.prod                         # Pro
```

---
## Screenshots

### Generate Starter Projects

![Starter Generator](examples/screenshots/starter-generator-ui.png)

Generate free Spring Boot Starter projects with:

- JWT scaffold
- Docker setup
- Database configuration
- Basic CI

---

### Generate Pro Projects

![Pro Generator](examples/screenshots/pro-generator-ui.png)

Generate production-ready Spring Boot projects with:

- OAuth2 authentication
- Refresh tokens
- AWS deployment automation
- CI/CD
- Security hardening

---

### Starter Generated Output

![Starter Output](examples/screenshots/generated-starter-project.png)

---

### Pro Generated Output

![Pro Output](examples/screenshots/generated-pro-project.png)

---

## Authentication Notes

Starter includes a lightweight JWT scaffold for development and demonstration purposes.

Pro includes production-focused authentication support with:

* OAuth2 login
* JWT access tokens
* Refresh tokens
* Persistent user and token entities

For more details, see:

```text
docs/JWT-SCAFFOLD.md
docs/PRO-FEATURES.md
```

---

## Documentation

Available documentation:

```text
docs/
├── CLI-USAGE.md
├── STARTER-JWT-SCAFFOLD.md
├── STARTER-DOCKER-SETUP.md
├── PRO-FEATURES.md
└── FAQ.md
```

---

## Examples

Example resources:

```text
examples/
├── screenshots/
│
│   # UI
│   ├── starter-generator-ui.png
│   ├── pro-generator-ui.png
│
│   # Generated outputs
│   ├── generated-starter-project.png
│   └── generated-pro-project.png
│
└── generated-structure.md
```

## Business Model

SpringGen provides a free Starter generator and a paid Pro upgrade.

* Starter is free.
* Pro is a one-time purchase.
* SpringGen does not provide consulting, freelancing, or custom software development services.
* Pro access unlocks premade automated project generation features.

---

## Roadmap

Planned future improvements:

* IntelliJ IDEA plugin
* Microservices starter
* Redis module
* Additional OAuth providers
* Team features
* More deployment targets
* More database options
* Advanced observability modules

---

## Support

For support, contact:

```text
📧 support@springgen.dev

🌐 [app.springgen.dev](https://app.springgen.dev)

```

Website:

```text
https://app.springgen.dev
```

---

## Repository Scope

This public repository contains SpringGen documentation, examples, screenshots, and preview versions of the Starter CLI/npm client.

The preview CLI projects are provided for transparency and local exploration.

The production SpringGen backend, web application, billing integration, deployment infrastructure, Pro templates, and commercial generation modules are maintained privately.

The published npm package and hosted SpringGen platform are operated from the private production repository.


---

## License

The public SpringGen documentation, examples, and preview CLI clients are released under the MIT License.

SpringGen Pro templates, premium modules, deployment infrastructure, backend services, and commercial generation features are proprietary and are not included under this license.

See:

LICENSE

---

## ⭐ Support the Project

If this helped you:
   * Star this repo
   * Share with other developers

---

## One-Line Summary

Generate Spring Boot backends instantly — from local setup to production deployment foundations.
