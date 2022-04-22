package com.dto;

public class WarehouseDTO {
    private Long id;
    private String productName;
    private Integer amount;
    private Integer inputPrice;
    private String note;

    public WarehouseDTO() {
    }

    public WarehouseDTO(Long id, String productName, Integer amount, Integer inputPrice, String note) {
        this.id = id;
        this.productName = productName;
        this.amount = amount;
        this.inputPrice = inputPrice;
        this.note = note;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
}
