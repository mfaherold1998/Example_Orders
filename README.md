# Example #1 Online Orders Data Base

## Entity/Relation Diagram

This is a Spring Boot project to initialize a database with the following Entity-Relationship model design:

```mermaid
erDiagram
    %% Entities
    CLIENT {
      int client_id PK
      string name
      string email
    }

    ORDER {
      int order_id PK
      date date
      decimal total
    }

    PRODUCT {
      int product_id PK
      string name
      decimal price
    }

    BILL {
      int bill_id PK
      date date
      decimal total_amount
    }

    %% Relations
    CLIENT ||--o{ ORDER : "makes"
    ORDER ||--o{ PRODUCT : "contains"
    BILL ||--|| ORDER : "corresponds to"
    PRODUCT }o--o{ BILL : "include in"
```
**Relations:**

||--o{ => One to Many

}o--|| => Many to One

||--|| => One to One

}o--o{ => Many to Many

## Some others details

**IDE:** IntelliJ Community 2024.2.1

**Spring boot initializer:** https://start.spring.io/

**Dependencies:**

- Spring Web
- Spring Data JPA
- Lombok
- Spring Boot Started Test => https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test/3.3.4
- PostgreSQL Driver
- Jakarta Persistence => https://mvnrepository.com/artifact/jakarta.persistence/jakarta.persistence-api/3.2.0
- Hibernate Validation

**Aplication Properties** template for PostgreSQL databases:

- spring.application.name=OnlineOrders
- spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
- spring.jpa.hibernate.ddl-auto=create
- spring.jpa.hibernate.show-sql=true
- spring.jpa.properties.hibernate.format_sql=true
- spring.profiles.active = dev
- spring.datasource.url=jdbc:postgresql://localhost:5432/ordersdb
- spring.datasource.username=postgres
- spring.datasource.password=admin

- logging.level.root=INFO
- logging.level.org.springframework.web=ERROR
- logging.level.com.example.orders.service=DEBUG
- logging.file.name=logs/orders_dev.log
- logging.file.max-size=10MB
- logging.file.max-history=10
- logging.pattern.file=%d{yyyy-MM-dd HH:mm:ss} - %logger{36} - %msg%n

> The name of entity ORDER has been changed in the code by PEDIDO due to name conflicts in the database.
