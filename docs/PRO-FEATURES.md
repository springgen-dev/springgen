# Pro Features

SpringGen Pro unlocks unlimited Spring Boot backend generation — create as many projects as you need with authentication, database, security, deployment, and DevOps configuration ready to go.

**Pay once. Generate unlimited production-ready Spring Boot projects.**

Pro is available through the SpringGen web app:

```text
https://app.springgen.dev
```
---

## Pricing

SpringGen Pro is currently available at launch pricing:

```text
$29 one-time purchase
```

---

## What Pro Adds

Starter gives you a local-development-ready Spring Boot project.

Pro adds production-focused modules such as:

* OAuth2 authentication with Google and GitHub
* JWT access tokens and refresh tokens
* Persistent authentication storage
* Swagger authentication testing
* Production environment configuration
* AWS EC2 deployment automation
* Full CI/CD deployment workflow
* Logging and observability
* Security hardening

---

## Authentication

Pro includes production-focused authentication support.

### Included Authentication Features

* OAuth2 login with Google
* OAuth2 login with GitHub
* JWT access tokens
* Refresh token flow
* Persistent user entity
* Persistent refresh token entity
* Sample secured endpoint

### Included Documentation

Generated Pro projects include setup guides for:

* Google OAuth credentials
* GitHub OAuth applications
* Local OAuth testing
* Swagger JWT validation
* Frontend integration examples

### Generated Auth Components

Pro projects may include:

```text
entity/
├── User.java
└── RefreshToken.java

controller/
├── AuthController.java
└── SampleController.java

service/
└── RefreshTokenService.java

repository/
├── RefreshTokenRepository.java
└── UserRepository.java

config/
└── SecurityConfig.java

security/
├── JwtService.java
├── JwtAuthenticationFilter.java
├── OAuth2SuccessHandler.java
└── CustomOAuth2UserService.java

```

---

### OAuth2 Support

Pro supports OAuth2 login providers such as:

* Google
* GitHub

After successful login, the backend returns an authentication response containing:

```json
{
  "accessToken": "jwt-access-token",
  "refreshToken": "refresh-token-value",
  "tokenType": "Bearer",
  "email": "user@example.com"
}
```

---

### Refresh Token Flow

Pro includes a refresh token endpoint that allows clients to request a new access token without forcing the user to log in again.

Example endpoint:

```http
POST /api/auth/refresh
```

Example request:

```json
{
  "refreshToken": "YOUR_REFRESH_TOKEN"
}
```

Example response:

```json
{
  "accessToken": "new-access-token",
  "refreshToken": "same-refresh-token",
  "tokenType": "Bearer"
}
```

---

### Swagger Authentication Testing

Pro includes Swagger configuration for validating secured APIs locally.

Generated projects allow developers to:

* Authenticate with OAuth2
* Copy the generated JWT access token
* Authorize Swagger using Bearer authentication
* Test protected endpoints directly from the browser

Example:

```text
Authorize
    ↓
Bearer JWT Token
    ↓
Call secured APIs
```

Swagger is enabled for local development and disabled by default in production environments.

---

## Production Configuration

Pro includes production-ready configuration files such as:

```text
application-prod.yml
.env.prod
docker-compose.prod.yml
```

These files are intended for production-style environments where secrets and database connections are provided through environment variables.

---

## CI/CD

Pro includes GitHub Actions workflows for build and deployment.

Example workflow structure:

```text
.github/workflows/
├── ci.yml
└── cd.yml
```

### CI Workflow

The CI workflow generally handles:

* Build
* Test
* Validation

### CD Workflow

The CD workflow generally handles:

* Production environment setup
* Remote deployment
* Docker build/run on target environment

---

## AWS EC2 Deployment Automation

Pro includes deployment support for AWS EC2 through:

```text
scripts/deploy-ec2.sh
```

This script handles:

1. Validating production environment file
2. Stopping and removing the old container
3. Removing the old Docker image
4. Building the new optimized Docker image
5. Starting the new container
6. Applying restart policy and container memory limits

The generated deployment setup is designed to help developers deploy quickly while still allowing customization.

---

## Docker Support

Pro includes both local and production Docker support.

Local:

```bash
docker-compose up --build
```

Production-style:

```bash
docker-compose -f docker-compose.prod.yml --env-file .env.prod up -d
```

---
## Security Hardening

Pro includes additional security-focused configuration such as:

* CORS configuration
* Security headers
* Request filtering
* Stateless authentication
* Protected endpoints
* Production-focused security structure

Developers should still review and customize security settings before deploying to production.

---

## Logging and Observability

Pro includes logging and observability foundations such as:

- Request logging for API calls with method, path, status, duration, and request ID
- Request ID tracing to follow requests across application logs
- Structured `key=value` console logs for easier searching and debugging
- Production-ready log levels configured for containerized deployments
- Docker-compatible logging through standard output (`stdout`)

These features help developers debug, trace, and monitor backend behavior in Docker, cloud, and production environments.

---

## Who Should Use Pro?

Pro is intended for:

* Developers building SaaS applications
* Freelancers delivering backend systems
* Startup founders building MVP backends
* Engineers who want production-ready project scaffolding
* Developers who want to avoid repetitive setup work

---

## What Pro Is Not

SpringGen Pro is not:

* A consulting service
* Custom software development
* A fully managed hosting platform
* A replacement for reviewing production security
* A substitute for application-specific business logic

SpringGen Pro provides premade automated generation features and production-focused scaffolding.

---

## Upgrade

Use the SpringGen web app:

```text
https://app.springgen.dev
```

For support:

```text
support@springgen.dev
```
