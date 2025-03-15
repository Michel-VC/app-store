# Proyecto Spring Boot - CRUD básico de test para prueba técnica

Este proyecto es una aplicación desarrollada con **Spring Boot 3.4** para ejemplificar un CRUD. 
Utiliza **PostgreSQL** como sistema de gestión de bases de datos. 
El sistema incluye operaciones básicas de gestión sobre la entidad Store mapeada por JPA.

## Características del Proyecto

- **CRUD básico** para gestionar la información de la tienda.
- Conexión a una base de datos **PostgreSQL**.
- Implementación de operaciones RESTful a través de un **`RestController`**.
- Gestión de la base de datos mediante **JPA**.

## Tecnologías Utilizadas

- **Spring Boot 3.4**: Framework principal.
- **Spring MVC**: Para la generación del proyecto web, RESTful y correr en el servidor embebido de Tomcat.
- **Spring Data JPA**: Para la gestión de la base de datos.
- **PostgreSQL**: Base de datos relacional.

## Prerrequisitos

Asegúrate de tener instalados los siguientes programas:
- **JDK 17** o superior.
- **PostgreSQL 13** o superior.
- **Maven** para la gestión de dependencias (opcional si usas IDE como IntelliJ IDEA o Eclipse).

## Configuración

### 1. Configuración de la base de datos

Asegúrate de que PostgreSQL está instalado y funcionando en tu máquina o servidor.

1. Crea una base de datos en PostgreSQL:

    ```sql
    CREATE DATABASE store_db;
    ```

2. Configura los parámetros de conexión en el archivo `src/main/resources/application.properties`:

    ```properties
    # Configuración de la base de datos PostgreSQL
    spring.datasource.url=jdbc:postgresql://localhost:5432/store_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.datasource.driver-class-name=org.postgresql.Driver

    # Configuración de JPA
    spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
    ```

    - **`spring.datasource.url`**: URL de conexión a tu base de datos PostgreSQL.
    - **`spring.datasource.username` y `spring.datasource.password`**: Tus credenciales de PostgreSQL.

### 2. Dependencias de Maven

Asegúrate de tener las siguientes dependencias en tu archivo `pom.xml` para que la aplicación funcione correctamente:

```xml
<dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
    </dependencies>
