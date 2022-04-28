package com.dto;

public class WishlistDTO {
    private Long productId;
    private String productName;
    private String image;
    private Integer amount;
    private Long price;
    private Long salePrice;

    public WishlistDTO() {
    }

    public WishlistDTO(Long productId, String productName, String image, Integer amount, Long price, Long salePrice) {
        this.productId = productId;
        this.productName = productName;
        this.image = image;
        this.amount = amount;
        this.price = price;
        this.salePrice = salePrice;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Long salePrice) {
        this.salePrice = salePrice;
    }


}
