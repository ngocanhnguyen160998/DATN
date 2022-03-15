package com.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String keyWord;

    @Column
    private String image;

    @Column(columnDefinition = "text")
    private String description;

    @Column
    private Long price;

    @Column
    private Long inputPrice;

    @Column
    private Long salePrice;

    @Column
    private Integer amount;

    @Column
    private Integer input_amount;


    @ManyToMany
    @JoinTable(name = "books_writers"
            , joinColumns = @JoinColumn(name = "book_id", nullable = false)
            , inverseJoinColumns = @JoinColumn(name = "writer_id", nullable = false)
    )
    private Set<Writer> writers = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category = new Category();

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisherBook = new Publisher();

    @OneToMany(mappedBy = "book_comment")
    private List<Comment> comments = new ArrayList<>();


    @OneToMany(mappedBy = "book")
    private List<OrderDetail> orderDetails = new ArrayList<>();

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

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getInputPrice() {
        return inputPrice;
    }

    public void setInputPrice(Long input_price) {
        this.inputPrice = input_price;
    }

    public Long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Long sale_price) {
        this.salePrice = sale_price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getInput_amount() {
        return input_amount;
    }

    public void setInput_amount(Integer input_amount) {
        this.input_amount = input_amount;
    }

    public Set<Writer> getWriters() {
        return writers;
    }

    public void setWriters(Set<Writer> writers) {
        this.writers = writers;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Publisher getPublisherBook() {
        return publisherBook;
    }

    public void setPublisherBook(Publisher publisher_book) {
        this.publisherBook = publisher_book;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> order_details) {
        this.orderDetails = order_details;
    }
}
