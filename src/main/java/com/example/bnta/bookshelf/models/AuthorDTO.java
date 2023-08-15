package com.example.bnta.bookshelf.models;

import java.util.ArrayList;
import java.util.List;

public class AuthorDTO {

    private String name;
    private List<Long> bookIds;

    public AuthorDTO(String name){
        this.name = name;
        this.bookIds = new ArrayList<>();
    }

    public AuthorDTO(){
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<Long> bookIds) {
        this.bookIds = bookIds;
    }
}
