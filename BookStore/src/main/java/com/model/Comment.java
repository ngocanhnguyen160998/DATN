package com.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_comment = new User();

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book_comment = new Book();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser_comment() {
        return user_comment;
    }

    public void setUser_comment(User user_comment) {
        this.user_comment = user_comment;
    }

    public Book getBook_comment() {
        return book_comment;
    }

    public void setBook_comment(Book book_comment) {
        this.book_comment = book_comment;
    }
}
