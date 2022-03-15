package com.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private Date createdDate;

    @Column
    private Date modifiedDate;

    @Column
    private String note;

    @Column
    private Integer status;

    @Column
    private String payment_info;

    @Column
    private Long price_total;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userOrder = new User();

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> order_details = new ArrayList<>();

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPayment_info() {
        return payment_info;
    }

    public void setPayment_info(String payment_info) {
        this.payment_info = payment_info;
    }

    public Long getPrice_total() {
        return price_total;
    }

    public void setPrice_total(Long price_total) {
        this.price_total = price_total;
    }

    public User getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(User user_order) {
        this.userOrder = user_order;
    }

    public List<OrderDetail> getOrder_details() {
        return order_details;
    }

    public void setOrder_details(List<OrderDetail> order_details) {
        this.order_details = order_details;
    }
}
