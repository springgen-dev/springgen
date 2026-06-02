# JWT Scaffold

## Overview

The Starter edition includes a lightweight JWT scaffold intended to help developers understand how JWT-based authentication integrates with Spring Security.

This implementation is **not production-ready authentication**. It provides a simple example of:

* Login endpoint
* JWT authentication flow
* JWT filter integration
* Securing endpoints with Bearer tokens
* Spring Security configuration

The generated implementation uses a mock token and is intended as a starting point for further customization.
For production deployments, consider upgrading to SpringGen Pro or replacing the scaffold with a fully implemented authentication system.
---

## Login Endpoint

### Request

```http
POST /api/auth/login
```

### Body

```json
{
  "username": "dummy-username",
  "password": "dummy-password"
}
```

### Response

```json
{
  "token": "mock-jwt-token-for-dummy-username"
}
```

---

## Using the Token

Include the returned token in the Authorization header:

```http
Authorization: Bearer mock-jwt-token-for-dummy-username
```

---

## Secure Endpoint

### Request

```http
GET /api/sample/secure-endpoint
```

### Headers

```http
Authorization: Bearer mock-jwt-token-for-dummy-username
```

### Response

```json
{
  "message": "This is a secure endpoint.",
  "success":true,
  "error":null
}
```

---

## Included Components

The scaffold includes the following components:

### Security Configuration

* Spring Security configuration
* Public endpoint configuration
* JWT filter registration
* Stateless session management

### JWT Service

* Mock token generation
* Mock token validation
* Bearer token extraction

### JWT Filter

* Authorization header processing
* SecurityContext population
* Request authentication flow

### Authentication Controller

* `/api/auth/login`
* Dummy credential validation
* Mock token generation

### Sample Secure Controller

* `/api/sample/secure-endpoint`
* Demonstrates endpoint protection

---

## Testing

### Login

```bash
curl -X POST http://localhost:8080/api/auth/login \
-H "Content-Type: application/json" \
-d '{
  "username":"dummy-username",
  "password":"dummy-password"
}'
```

Expected response:

```json
{
  "token": "mock-jwt-token-for-dummy-username"
}
```

### Access Secure Endpoint

```bash
curl http://localhost:8080/api/sample/secure-endpoint \
-H "Authorization: Bearer mock-jwt-token-for-dummy-username"
```

Expected response:

```json
{
  "message": "This is a secure endpoint",
  "success":true,
  "error":null
}
```

---

## Important Notes

This JWT implementation is intentionally simplified for demonstration purposes.

The generated token:

* Is not cryptographically signed
* Does not expire
* Does not validate users against a database
* Is intended only as a learning scaffold and project starter

Before deploying to production, consider implementing:

* User persistence
* Password hashing (BCrypt)
* Real JWT signing and verification
* Token expiration handling
* Refresh tokens
* Role-based authorization
* OAuth2/OpenID Connect integration
* Secure secret management

---

## Purpose

The goal of this scaffold is to provide a working example that demonstrates how Spring Security and JWT authentication fit together in a Spring Boot application.

Developers are encouraged to replace the mock implementation with a production-grade authentication solution based on their application's requirements.
