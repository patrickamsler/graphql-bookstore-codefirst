package graphql.bookstore.model;

import java.util.Date;

public class Order {

    private String id;
    private String bookId;
    private Date orderDate;

    public Order() {
    }

    public Order(String id, String bookId, Date orderDate) {
        this.id = id;
        this.bookId = bookId;
        this.orderDate = orderDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
