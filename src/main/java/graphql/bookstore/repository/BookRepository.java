package graphql.bookstore.repository;

import graphql.bookstore.model.Author;
import graphql.bookstore.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookRepository {

    private static final List<Book> books = new ArrayList<>();

    static {
        Author author1 = new Author("author-1", "Joanne", "Rowling");
        Author author2 = new Author("author-2", "Herman", "Melville");
        Author author3 = new Author("author-3", "Anne", "Rice");

        books.add(new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, author1));
        books.add(new Book("book-2", "Moby Dick", 635, author2));
        books.add(new Book("book-3", "Interview with the vampire", 371, author3));
        books.add(new Book("book-4", "Billy Budd", 421, author2));
    }

    public Book findById(String id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public List<Book> findBooksByAuthor(String authorId) {
        return books.stream()
                .filter(book -> book.getAuthor().getId().equals(authorId))
                .collect(Collectors.toList());
    }

    public List<Author> getAllAuthors() {
        return books.stream()
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList());
    }
}
