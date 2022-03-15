package com.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private Date createdDate;

    @Column
    private Date modifiedDate;

    @Column
    private Integer amount;

    @Column
    private Long unit_price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order = new Order();

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book = new Book();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Long unit_price) {
        this.unit_price = unit_price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order3) {
        this.order = order3;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book3) {
        this.book = book3;
    }
}
