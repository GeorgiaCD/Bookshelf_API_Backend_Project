package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class Bookshelf { // K & R

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn (name = "user_id")
    @JsonIgnoreProperties ({"bookshelfs"})
    private User user;

    @ManyToOne
    @JoinColumn (name = "book_id")
    @JsonIgnoreProperties ({"bookshelfs"})
    private Book book;

    @Column
    private Status status;

    @Column
    private int rating;

    public
    Bookshelf(User user, Book book, Status status, int rating){
        this.user = user;
        this.book = book;
        this.status = status;
        this.rating = rating;
    }

    public Bookshelf(){}

    public int getId(){
        return id;
    }

    public
    void setId(int id){
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
