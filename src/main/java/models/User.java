package models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User { // K & R

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @OneToMany(mappedBy = "user")
    private List<Bookshelf> bookshelf;

    public User(String userName, List<Bookshelf> bookshelf) {
        this.userName = userName;
        this.bookshelf = bookshelf;
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
        return bookshelf;
    }

    public void setBookshelf(List<Bookshelf> bookshelf) {
        this.bookshelf = bookshelf;
    }
}
