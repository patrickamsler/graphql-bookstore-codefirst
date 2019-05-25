package graphql.bookstore.controller;

import graphql.bookstore.model.Book;
import graphql.bookstore.repository.BookRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;


    @GraphQLQuery(name = "bookById", description = "find a book by id")
    public Book getBookById(@GraphQLArgument(name = "id") String id) {
        return bookRepository.findById(id);
    }

    @GraphQLQuery(name = "allBooks", description = "returns all available books")
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
}
