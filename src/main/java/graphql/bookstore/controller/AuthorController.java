package graphql.bookstore.controller;

import graphql.bookstore.model.Author;
import graphql.bookstore.repository.BookRepository;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private BookRepository bookRepository;

    @GraphQLQuery(name = "allAuthors", description = "find all authors in the repo")
    public List<Author> getAllAuthors() {
        return bookRepository.getAllAuthors();
    }
}
