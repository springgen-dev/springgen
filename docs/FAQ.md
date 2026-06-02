# FAQ

Frequently asked questions about SpringGen.

---

## What is SpringGen?

SpringGen is a developer productivity tool that generates Spring Boot backend projects based on selected configuration options.

It helps developers avoid repetitive project setup and start with a clean backend structure.

---

## Is SpringGen just a template?

No.

SpringGen is a generator platform. It dynamically builds project output based on selected options such as database type, Docker support, authentication, CI/CD, and deployment features.

---

## What is included in the free Starter version?

Starter includes:

* Spring Boot project structure
* Controller / Service / Repository layers
* DTO structure
* Global exception handling
* JWT authentication scaffold
* Database configuration
* Dockerfile
* Docker Compose local setup
* Basic GitHub Actions CI

---

## Is Starter free?

Yes.

Starter is free and can be used through the CLI.

```bash
npm install -g springgen
```

---

## What is included in Pro?

Pro includes production-focused features such as:

* OAuth2 authentication
* Refresh tokens
* Production configuration
* AWS EC2 deployment automation
* Full CI/CD deployment workflow
* Logging and observability
* Security hardening

---

## How much does Pro cost?

SpringGen Pro is currently available at launch pricing:

```text
$29 one-time purchase
```

Future pricing may increase after launch.

---

## Is SpringGen Pro a subscription?

No.

For the current MVP, SpringGen Pro is a one-time purchase.

---

## Is SpringGen a consulting service?

No.

SpringGen does not provide consulting, freelancing, or custom development services.

SpringGen provides premade automated project generation features.

---

## Does SpringGen write my business logic?

No.

SpringGen generates the backend foundation.

You are responsible for adding your own domain models, business logic, integrations, and production-specific requirements.

---

## Does the generated project work locally?

Yes.

Generated projects can run locally with:

```bash
./gradlew bootRun
```

or with Docker:

```bash
docker compose up --build
```

---

## Which databases are supported?

Starter supports:

```text
PostgreSQL
MySQL
MongoDB
```

Pro currently focuses on production-ready relational database setups such as PostgreSQL and MySQL.

---

## Does Starter include authentication?

Yes, Starter includes a lightweight JWT authentication scaffold.

The Starter JWT scaffold is intended for learning, local development, and project structure demonstration.

It is not production-ready authentication.

---

## Does Pro include production authentication?

Yes.

Pro includes OAuth2 login, JWT access tokens, refresh tokens, and persistent authentication entities.

---

## Can I deploy the generated project?

Yes.

Starter includes Docker support for local development.

Pro includes production-focused deployment support such as AWS EC2 deployment automation and CI/CD workflow generation.

---

## Does SpringGen host my generated application?

No.

SpringGen generates source code. You download the generated project and deploy it to your own infrastructure.

---

## Do I need an API key?

Starter CLI generation does not require a Pro API key.

Pro access requires purchase and onboarding through the SpringGen web app.

---

## Can I use generated projects commercially?

Yes.

You can use generated projects for your own applications, client projects, MVPs, and commercial products.

---

## Can I resell SpringGen itself?

No.

You may use generated output in your own projects, but you may not resell SpringGen, its generator platform, private Pro modules, or premium templates as a competing product.

---

## Where is Pro available?

Pro is available through the SpringGen web app:

```text
https://app.springgen.dev
```

---

## Is there an IntelliJ plugin?

Not yet.

An IntelliJ IDEA plugin is planned for a future release.

---

## How do I get support?

Contact:

```text
support@springgen.dev
```
