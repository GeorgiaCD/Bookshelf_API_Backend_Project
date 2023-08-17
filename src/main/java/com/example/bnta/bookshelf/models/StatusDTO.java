package com.example.bnta.bookshelf.models;

public class StatusDTO {

    private Status status;

    public StatusDTO(Status status) {
        this.status = status;
    }

    public StatusDTO(){

    }
//
//    public Long getBookshelfId() {
//        return bookshelfId;
//    }
//
//    public void setBookshelfId(Long bookshelfId) {
//        this.bookshelfId = bookshelfId;
//    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
