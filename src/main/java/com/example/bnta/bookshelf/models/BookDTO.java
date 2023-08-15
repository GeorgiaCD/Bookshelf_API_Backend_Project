package com.example.bnta.bookshelf.models;

import java.util.List;

public class BookDTO {

    private String title;
    private Long authorId;
    private Genre genre;
    private List<Long> bookshelfIds;
    private int yearPublished;
    private int numberOfPages;

    public BookDTO(String title, Long authorId, Genre genre, int yearPublished, int numberOfPages) {
        this.title = title;
        this.authorId = authorId;
        this.genre = genre;
        this.yearPublished = yearPublished;
        this.numberOfPages = numberOfPages;
    }

    public BookDTO(){
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Long> getBookshelfIds() {
        return bookshelfIds;
    }

    public void setBookshelfIds(List<Long> bookshelfIds) {
        this.bookshelfIds = bookshelfIds;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
