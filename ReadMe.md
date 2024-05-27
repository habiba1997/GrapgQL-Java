
# GraphQL
- GraphQL is a query language for APIs and a runtime for executing those queries by using a type system you define for your data.

## How To run the application
- Run the application as a Spring Boot application
- Open the browser and hit the URL http://localhost:8080/graphiql
- You will see the GraphiQL IDE where you can write the queries and execute them.

## GraphQL Query
- A GraphQL query is used to read or fetch values.

##  GraphQL Mutation
- A GraphQL mutation is used to write or post values.

## GraphQL Schema
- A GraphQL schema is at the core of any GraphQL server implementation. It describes the functionality available to the client applications that connect to it.

## GraphQl Vs Rest API
- REST is having fixed response while in GraphQL provides flexibility to the client to request only the data that is needed.
- Over and under fetching with REST API is a common problem, but with GraphQL, the client can request only the data that is needed.
- REST has different http methods and separate endpoints for each API in GraphQL we have Query and Mutation, and thers eis only one endpoint.
- GraphQL needs a schema file to define the types of data that can be queried, REST does not need that.


```graphql
type Query {
    books: [Book]
}

type Book {
    id : ID
    name : String
    author: String
    price: Float
    ratings: [Rating]
}

type Rating {
    id: ID
    rating: Int
    comment: String
    user: String
}

```
```java
@QueryMapping
public Collection<Book> books() {
  return bookCatalogService.getBooks();
}

@SchemaMapping
public List<Rating> ratings(Book book) {
  return bookCatalogService.ratings(book);
}
```

In the above code, we have defined two **Data Fetchers**
- books() for field books of the GraphQL object type Query.
- ratings(..) for field ratings of the type Book.

Note: 
- The important point to note here is if you don’t specify a Data Fetcher for a field then the GraphQL assigns a default PropertyDataFetcher which, in turn, looks for the public XXX getXXX() method in the POJO object defined by the Type.
- Therefore, in the above example, GraphQL resolves the field name from public String getName() method of the Book object.


If a GraphQL client requests the following data;

```graphql
query {
  books {
    id
    name
    ratings {
      rating
      comment
    }
  }
}
```
The GraphQL runtime engine does the following:

1.  the request and validates the request against the schema.
2. Then it calls the `book` Data Fetcher (handler method `books()`) to fetch book information once.
3. And, then it calls the `ratings` Data Fetcher for each book.

Note:
- AnnotatedControllerConfigurer detects @Controller beans and registers their annotated handler methods as DataFetchers via RuntimeWiring.Builder.

# GraphQL Variable
- GraphQL variables are used to pass dynamic values to the query at runtime.
- GraphQL variables are defined in the query and their values are passed in a separate JSON object.
- 
```graphql
query student($id : Int, $subName : SubjectNameFilter) {
  student(id : $id) {
    id
    firstName
    lastName
    email
    street
    city
    learningSubjects (subjectNameFilter : $subName) {
      id
      subjectName
      marksObtained
    }
    fullName
  } 
}
```
```json
{
  "id" : 1,
  "subName" : "Java"
}

```


Note:
The graphQl dependencies are deprecated
```xml
        <dependency>
            <groupId>com.graphql-java</groupId>
            <artifactId>graphql-spring-boot-starter</artifactId>
            <version>5.0.2</version>
        </dependency>
        <dependency>
            <groupId>com.graphql-java</groupId>
            <artifactId>graphql-java-tools</artifactId>
            <version>5.2.4</version>
        </dependency>

        <dependency>
            <groupId>com.graphql-java</groupId>
            <artifactId>graphiql-spring-boot-starter</artifactId>
            <version>5.0.2</version>
        </dependency>
```
latest version of graphql-java is 16.2.0
```xml
        <dependency>
            <groupId>com.graphql-java-kickstart</groupId>
            <artifactId>graphql-spring-boot-starter</artifactId>
            <version>15.1.0</version>
        </dependency>

        <dependency>
        <groupId>com.graphql-java-kickstart</groupId>
        <artifactId>graphiql-spring-boot-starter</artifactId>
        <version>11.1.0</version>
        </dependency>
        <dependency>
        <groupId>com.graphql-java-kickstart</groupId>
        <artifactId>graphql-java-tools</artifactId>
        <version>13.1.1</version>
        </dependency>

```

## GraphQl Dependencies

```xml
        <dependency>
            <groupId>com.graphql-java-kickstart</groupId>
            <artifactId>graphql-spring-boot-starter</artifactId>
        </dependency>
        <dependency>
        <groupId>com.graphql-java-kickstart</groupId>
        <artifactId>graphiql-spring-boot-starter</artifactId>
        </dependency>
        <dependency>
        <groupId>com.graphql-java-kickstart</groupId>
        <artifactId>graphql-java-tools</artifactId>
        </dependency>
```
The graphql-spring-boot-starter, graphiql-spring-boot-starter, and graphql-java-tools dependencies are part of the GraphQL Java Kickstart project, 
which provides a set of Spring Boot starters to quickly get started with GraphQL and Java.  
- graphql-spring-boot-starter: This is the core starter that integrates GraphQL with Spring Boot. It auto-configures the GraphQL Java engine and provides a servlet to handle GraphQL requests.  
- graphiql-spring-boot-starter: This starter provides an integration with GraphiQL, an in-browser IDE for exploring GraphQL. It serves the GraphiQL static resources and provides a controller that exposes a GraphiQL endpoint in your application.  
- graphql-java-tools: This library allows you to use the schema-first approach to define your GraphQL schema. It parses the schema files, maps them to Java classes, and creates data fetchers and type resolvers.  
```xml
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-graphql</artifactId>
        </dependency>
```
On the other hand, spring-boot-starter-graphql is a starter provided by Spring Boot itself. 
It provides a more integrated experience with Spring Boot, and it's based on graphql-java, the same underlying library that GraphQL Java Kickstart uses. 
However, it doesn't include GraphiQL by default, and it doesn't support the schema-first approach out of the box like graphql-java-tools does. 
Meaning: 
The schema-first approach is a way of developing GraphQL APIs. In this approach, you start by defining your API's types and operations (queries, mutations, and subscriptions) using the GraphQL Schema Definition
Language (SDL), and then you implement resolvers that fulfill those operations.
When it's mentioned that a library or tool doesn't support the schema-first approach out of the box, it means that the tool doesn't inherently facilitate the process of 
defining your API using SDL and then implementing the resolvers. You might have to manually wire up your schema to your resolvers or use additional tools or libraries to achieve this. 











