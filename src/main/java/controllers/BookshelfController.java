package controllers;

import models.Bookshelf;
import models.BookshelfDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.BookshelfService;

import java.util.List;

@RestController
@RequestMapping(value = "bookshelf")
public class BookshelfController {

    @Autowired
    BookshelfService bookshelfService;

    @PostMapping
    public ResponseEntity<Bookshelf> addToBookshelf(@RequestBody BookshelfDTO bookshelfDTO){
        Bookshelf bookshelf = bookshelfService.addToBookshelf(bookshelfDTO);
        return new ResponseEntity<>(bookshelf, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}") //localhost8080:
    public ResponseEntity<Bookshelf> updateBookshelf(@RequestBody BookshelfDTO bookshelfDTO, @PathVariable Long id){
        Bookshelf bookshelf = bookshelfService.updateBookshelf(bookshelfDTO, id);
        return new ResponseEntity<>(bookshelf, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Bookshelf> deleteBookFromBookshelf(@PathVariable Long id){
        Bookshelf bookshelf = bookshelfService.deleteBookFromBookshelf(id);
        return new ResponseEntity<>(bookshelf, HttpStatus.GONE);
    }



}
