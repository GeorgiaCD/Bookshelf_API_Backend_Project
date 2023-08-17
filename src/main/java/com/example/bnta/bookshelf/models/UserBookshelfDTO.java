package com.example.bnta.bookshelf.models;

public class UserBookshelfDTO {

    private String bookTitle;
    private String author;
    private Genre genre;
    private int year;
    private int numberOfPages;
    private Status status;
    private int rating;


    public UserBookshelfDTO(Book book, Status status, int rating) {
        this.bookTitle = book.getTitle();
        this.author = book.getAuthor().getName();
        this.genre = book.getGenre();
        this.year = book.getYear();
        this.numberOfPages = book.getNumberOfPages();
        this.status = status;
        this.rating = rating;
    }

    public UserBookshelfDTO(){

    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
