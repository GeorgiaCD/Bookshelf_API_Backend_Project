package com.example.bnta.bookshelf.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "books")
public class Book { // F & G
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonIgnoreProperties({"books"})
    private Author author;

    @Column
    private Genre genre;

    @Column
    private int year;

    @Column(name = "number_of_pages")
    private int numberOfPages;

    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties({"book","user"})
    private List<Bookshelf> bookshelves;

    public Book(String title, Author author, Genre genre, int year, int numberOfPages){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.numberOfPages = numberOfPages;
        this.bookshelves = new ArrayList<>();
    }

    public Book(){}

//    Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public List<Bookshelf> getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(List<Bookshelf> bookshelves) {
        this.bookshelves = bookshelves;
    }

    public void addBookshelf(Bookshelf bookshelf){
        this.bookshelves.add(bookshelf);
    }
}
