# User Products CRUD

Backend CRUD на Spring Boot для пользователей и принадлежащих им товаров.

## Запуск

```bash
./mvnw spring-boot:run
```

## Проверка

```bash
./mvnw test
```

## Основные endpoint'ы

```text
POST   /api/v1/users
GET    /api/v1/users
GET    /api/v1/users/{userId}
PUT    /api/v1/users/{userId}
DELETE /api/v1/users/{userId}

GET    /api/v1/users/{userId}/products
POST   /api/v1/users/{userId}/products
GET    /api/v1/users/{userId}/products/{productId}
PUT    /api/v1/users/{userId}/products/{productId}
DELETE /api/v1/users/{userId}/products/{productId}
```
