package com.dto;

public class CartDTO {
    private Long productId;
    private String productName;
    private String image;
    private Integer amount;
    private Integer warehouseAmount;
    private Long total;

    public CartDTO() {
    }

    public CartDTO(Long productId, String productName, String image, Integer amount, Integer warehouseAmount, Long total) {
        this.productId = productId;
        this.productName = productName;
        this.image = image;
        this.amount = amount;
        this.warehouseAmount = warehouseAmount;
        this.total = total;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getWarehouseAmount() {
        return warehouseAmount;
    }

    public void setWarehouseAmount(Integer warehouseAmount) {
        this.warehouseAmount = warehouseAmount;
    }
}
