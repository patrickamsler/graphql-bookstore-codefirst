package graphql.bookstore.repository;

import graphql.bookstore.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class OrderRepository {

    private final static List<Order> orders = new ArrayList<>();

    public Order findOrderById(String id) {
        return orders.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Order createOrder(String bookId) {
        String id = UUID.randomUUID().toString();
        Date orderDate = new Date();
        Order order = new Order(id, bookId, orderDate);
        orders.add(order);
        return order;
    }
}
