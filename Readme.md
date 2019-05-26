# GraphQL Bookstore
GraphQL example application.
The application uses Spring Boot and [graphql-spqr](https://github.com/leangen/graphql-spqr) 
with a code first development approach.

Build the project: `gradle build`

Start the application: `gradle bootRun`

Access GraphQL endpoint: `http://localhost:8080/graphql`

## Queries
 
All books
```
query {
  allBooks {
    id
    name
    pageCount
    author {
      firstName
      lastName
    }
  }
}
```
Find book by id
```
query {
  bookById(id: "book-2") {
    	name
    }
}
```
All authors
```
query {
  allAuthors {
      firstName
      lastName
      books {
        name
      }
    }
}
```
## Mutation
Create order
```
mutation {
  createOrder(bookId: "book-2" ) {
    id
    orderDate
    book {
      id
      name
    }
  }
}
```


