package com.example.bnta.bookshelf.models;

import java.util.List;

public
class UserDTO {

    private String username;
    private List<Long> bookshelvesIDs;

    public UserDTO(String username, List<Long> bookshelvesIDs){
        this.username = username;
        this.bookshelvesIDs = bookshelvesIDs;
    }

    public UserDTO(){}

    public
    String getUsername(){
        return username;
    }

    public
    void setUsername(String username){
        this.username = username;
    }

    public
    List<Long> getBookshelvesIDs(){
        return bookshelvesIDs;
    }

    public
    void setBookshelvesIDs(List<Long> bookshelvesIDs){
        this.bookshelvesIDs = bookshelvesIDs;
    }
}
