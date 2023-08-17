package com.example.bnta.bookshelf.models;

public
class RatingDTO {

    private int rating;

    public
    RatingDTO(int rating){
        this.rating = rating;
    }

    public RatingDTO(){}

    public
    int getRating(){
        return rating;
    }

    public
    void setRating(int rating){
        this.rating = rating;
    }
}
