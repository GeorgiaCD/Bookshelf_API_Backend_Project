package com.example.bnta.bookshelf.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class User { // K & R

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @OneToMany(mappedBy = "user")
    private List<Bookshelf> bookshelves;

    public User(String userName) {
        this.userName = userName;
        this.bookshelves = new ArrayList<>();
    }

    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Bookshelf> getBookshelf() {
        return bookshelves;
    }

    public void setBookshelf(List<Bookshelf> bookshelves) {
        this.bookshelves = bookshelves;
    }

    public
    void addBookshelf(Bookshelf bookshelf){
        this.bookshelves.add(bookshelf);
    }
}