package com.example.bnta.bookshelf.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity(name = "bookshelves")
public class Bookshelf { // K & R

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"bookshelves"})
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnoreProperties({"bookshelves","author"})
    private Book book;

    @Column
    private Status status;

    @Column
    private int rating;

    public
    Bookshelf(User user, Book book){
        this.user = user;
        this.book = book;
        this.status = Status.WANT_TO_READ;
        this.rating = 0;
    }

    public Bookshelf(){}

    public Long getId(){
        return id;
    }

    public
    void setId(Long id){
        this.id = id;
    }

    public
    User getUser(){
        return user;
    }

    public
    void setUser(User user){
        this.user = user;
    }

    public
    Book getBook(){
        return book;
    }

    public
    void setBook(Book book){
        this.book = book;
    }

    public
    Status getStatus(){
        return status;
    }

    public
    void setStatus(Status status){
        this.status = status;
    }

    public
    int getRating(){
        return rating;
    }

    public
    void setRating(int rating){
        this.rating = rating;
    }
}