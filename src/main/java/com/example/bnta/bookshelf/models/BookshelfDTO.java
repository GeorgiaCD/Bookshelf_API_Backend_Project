package com.example.bnta.bookshelf.models;

public class BookshelfDTO {

    private Long userId;
    private Long bookId;
//    private Status status;
//    private int rating;

    public
    BookshelfDTO(Long userId, Long bookId){
        this.userId = userId;
        this.bookId = bookId;
    }

    public BookshelfDTO(){}

    public
    Long getUserId(){
        return userId;
    }

    public
    void setUserId(Long userId){
        this.userId = userId;
    }

    public
    Long getBookId(){
        return bookId;
    }

    public
    void setBookId(Long bookId){
        this.bookId = bookId;
    }

//    public
//    int getRating(){
//        return rating;
//    }
//
//    public
//    void setRating(int rating){
//        this.rating = rating;
//    }
}
