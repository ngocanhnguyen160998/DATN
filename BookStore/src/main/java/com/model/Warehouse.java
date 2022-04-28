package com.model;

import javax.persistence.*;

@Entity
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer amount;
    private Long productId;
    private Integer inputPrice;
    private Integer inputAmount;
    private String note;

    public Warehouse() {
    }

    public Warehouse(Integer amount) {
        this.amount = amount;
    }

    public Warehouse(Long productId, Integer inputPrice, Integer inputAmount) {
        this.productId = productId;
        this.inputPrice = inputPrice;
        this.inputAmount = inputAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getInputPrice() {
        return inputPrice;
    }

    public void setInputPrice(Integer inputPrice) {
        this.inputPrice = inputPrice;
    }

    public Integer getInputAmount() {
        return inputAmount;
    }

    public void setInputAmount(Integer inputAmount) {
        this.inputAmount = inputAmount;
    }
}
