# GraphQL Java

A Java learning project demonstrating GraphQL queries, mutations, resolvers, and student data, with supporting examples and session material in `Demo/`, `GraphQL/`, and `client/`.

**Technologies:** Java 17, Spring Boot 3.2, Spring GraphQL, Spring Data JPA, MySQL, Maven, and Docker Compose.

## Run locally

1. Install JDK 17, Maven, and Docker.
2. Run `docker compose up -d` to start the local MySQL database on port 3305.
3. Run `mvn spring-boot:run` from this folder.
4. Open http://localhost:8080/graphiql to explore queries; the default GraphQL endpoint is `/graphql`.

Run tests with `mvn test`. Database values in the Compose/config files are local demonstration defaults.
