

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