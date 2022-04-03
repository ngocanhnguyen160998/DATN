package com.dto;

public class ProductDTO {
    private Long id;
    private String name;
    private String image;
    private String info;
    private String descriptions;
    private Long price;
    private Long salePrice;
    private String categoryName;
    private String author;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String image, String info, String descriptions, Long price, Long salePrice, String categoryName, String author) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.info = info;
        this.descriptions = descriptions;
        this.price = price;
        this.salePrice = salePrice;
        this.categoryName = categoryName;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
