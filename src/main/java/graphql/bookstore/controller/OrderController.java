package graphql.bookstore.controller;

import graphql.bookstore.model.Order;
import graphql.bookstore.repository.BookRepository;
import graphql.bookstore.repository.OrderRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookRepository bookRepository;

    @GraphQLQuery(name = "orderById", description = "find a order by id")
    public Order getOrderById(
            @GraphQLNonNull
            @GraphQLArgument(name = "id") String id) {
        return orderRepository.findOrderById(id);
    }

    @GraphQLMutation(name = "createOrder", description = "creates a new book order")
    public Order createOrder(
            @GraphQLNonNull
            @GraphQLArgument(name = "bookId") String bookId) {
        if (bookRepository.findById(bookId) == null) {
            throw new IllegalStateException("Invalid bookId " + bookId);
        }

        return orderRepository.createOrder(bookId);
    }
}
