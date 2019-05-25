package graphql.bookstore.controller;

import graphql.bookstore.model.Author;
import graphql.bookstore.model.Book;
import graphql.bookstore.model.Order;
import graphql.bookstore.repository.BookRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;


    @GraphQLQuery(name = "bookById", description = "find a book by id")
    public Book getBookById(
            @GraphQLNonNull
            @GraphQLArgument(name = "id") String id) {
        return bookRepository.findById(id);
    }

    @GraphQLQuery(name = "allBooks", description = "returns all available books")
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @GraphQLQuery
    public Book book(@GraphQLContext Order order) {
        return bookRepository.findById(order.getBookId());
    }

    @GraphQLQuery
    public List<Book> books(@GraphQLContext Author author) {
        return bookRepository.findBooksByAuthor(author.getId());
    }
}
