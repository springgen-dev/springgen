# SpringGen — Generate Spring Boot Backends in Minutes 🚀  [![npm](https://img.shields.io/npm/v/springgen)](https://www.npmjs.com/package/springgen) [![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

Generate production-ready Spring Boot backends instantly — from local development to Docker, CI/CD, authentication, and AWS deployment.

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

> [!NOTE]
> SpringGen uses a deterministic template/module engine to assemble tested Spring Boot project structures, configurations, and production-ready components.
>
> Generated projects come from maintained templates and predictable configurations — not runtime AI-generated code from prompts.


Think of it as:

> Like a frontend starter generator — but for production-ready Spring Boot backends.

SpringGen is not just a template pack. It is a generator platform with a CLI and web UI that dynamically builds project structures based on selected configuration options.

---

## How is SpringGen different?

### vs Spring Initializr

Spring Initializr creates the project foundation:
- dependencies
- build files
- basic Spring Boot application

SpringGen creates the application foundation:
- layered backend structure
- DTO patterns
- exception handling
- security scaffolding
- Docker / CI setup

### vs JHipster

JHipster is a powerful full-stack application generator with a large ecosystem, frontend generation, and many architecture choices.

SpringGen is a lightweight backend-focused generator for developers who want an opinionated Spring Boot starting point without adopting a larger generator ecosystem.


---

## Why Developers Use SpringGen

* Save hours of setup time
* Start with a real backend structure
* Use clean layered architecture
* Get Docker and CI setup quickly
* Focus on business logic instead of boilerplate
* Go from idea to working backend faster

---

## 🚀 SpringGen Pro — Production Ready

Stop rebuilding the same production setup for every Spring Boot project.

SpringGen Pro generates a backend foundation with authentication, deployment, security, and DevOps configuration ready to go.

### ⚙️ Full Config UI

Choose:

- Package name
- Database
- Docker setup
- CI/CD
- Security
- Logging
- AWS deployment options


### 🔐 OAuth2 + Refresh Tokens

Generate production-ready Spring Security:

- Google OAuth2 login
- GitHub OAuth2 login
- JWT access tokens
- Refresh token flow


### 🐳 Production Docker Setup

Includes:

- Dockerfile
- docker-compose.yml
- docker-compose.prod.yml
- Environment configuration
- Health checks


### 🚀 CI/CD → AWS EC2 Deploy

Push code.

GitHub Actions automatically:

- Builds your application
- Creates production configuration
- Connects to EC2
- Deploys your Docker application


### 🖥️ Generated EC2 Deploy Script

Deploy anytime with a ready-to-use script.

Generated:

```text
scripts/deploy-ec2.sh
```

Handles:

- Docker builds
- Application updates
- Container restarts

Use it through GitHub Actions or run manually on EC2.


### 🛡️ Security Hardening

Includes:

- CORS configuration
- Secure headers
- Request filtering
- Validation
- Production security defaults


### 📊 Logging & Observability

Includes:

- Request logging
- Structured logs
- Production-ready logging configuration


---

## AWS EC2 Deployment Automation

![SpringGen EC2 Deployment](examples/screenshots/pro-ec2-deployment-flow.png)

SpringGen Pro supports two deployment workflows:

### Automated Deployment

```text
GitHub Secrets
   ↓
Git Push
   ↓
GitHub Actions
   ↓
EC2
   ↓
Docker Application Running
```

Best for production workflows.


### Manual Deployment

Use the generated deploy script on EC2

```bash
# 1. One-time setup
nano .env.prod

# 2. Deploy anytime
git pull origin main
./scripts/deploy-ec2.sh
```

Best for manual releases, testing, and full control over deployments.

---

## Unlock SpringGen Pro

Generate production-ready Spring Boot projects in minutes.

👉 https://app.springgen.dev

**$29 one-time launch pricing**

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

Configure Environment variables.Update your  `.env` values.

```bash
cd my-app
./gradlew bootRun
```

Or run with Docker:

```bash
docker compose up --build
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
### Pro Documentation

SpringGen Pro generated projects include additional production guides:

- AWS EC2 deployment guide
- OAuth2 + refresh token setup
- Production configuration guide
- CI/CD deployment instructions

Available inside generated Pro projects.

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

📧 support@springgen.dev

Website:
🌐 https://app.springgen.dev

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
