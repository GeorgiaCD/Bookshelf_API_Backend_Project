package com.example.bnta.bookshelf.models;

public class UserBookshelfDTO {

    private Book book;
    private Status status;

    public UserBookshelfDTO(Book book, Status status) {
        this.book = book;
        this.status = status;
    }

    public UserBookshelfDTO(){

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
