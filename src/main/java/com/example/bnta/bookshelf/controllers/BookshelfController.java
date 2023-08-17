package com.example.bnta.bookshelf.controllers;

import com.example.bnta.bookshelf.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bnta.bookshelf.services.BookshelfService;

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

//    @PatchMapping(value = "/{id}") //localhost8080:bookshelf/{id}
//    public ResponseEntity<Bookshelf> updateBookshelf(@RequestBody BookshelfDTO bookshelfDTO, @PathVariable Long id){
//        Bookshelf bookshelf = bookshelfService.updateBookshelf(bookshelfDTO, id);
//        return new ResponseEntity<>(bookshelf, HttpStatus.OK);
//    }

    @PutMapping(value = "/{id}") //completeness
    public ResponseEntity<Bookshelf> updateBookshelf(@RequestBody BookshelfDTO bookshelfDTO, @PathVariable Long id){
        Bookshelf updatedBookshelf = bookshelfService.updateBookshelf(bookshelfDTO, id);
        return new ResponseEntity<>(updatedBookshelf, HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}/status")
    public ResponseEntity<Bookshelf> updateStatus(@RequestBody StatusDTO statusDTO, @PathVariable Long id){
        Bookshelf updatedStatus = bookshelfService.updateStatus(statusDTO, id);
        return new ResponseEntity<>(updatedStatus, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Bookshelf> deleteBookFromBookshelf(@PathVariable Long id){
        Bookshelf bookshelf = bookshelfService.deleteBookFromBookshelf(id);
        return new ResponseEntity<>(bookshelf, HttpStatus.GONE);
    }

    @GetMapping
    public ResponseEntity<?> findBookshelfByUserId(@RequestParam(required = true, name = "userId") Long userId,
                                                                        @RequestParam(required = false, name ="status") Status status){
        if(status!= null){
            List<Bookshelf> filteredBookshelf = bookshelfService.getStatusByUser(status, userId);
            return new ResponseEntity(filteredBookshelf, HttpStatus.FOUND);
        }

        List<UserBookshelfDTO> userBookshelves = bookshelfService.findBookshelfById(userId);
        return new ResponseEntity(userBookshelves, HttpStatus.FOUND);
    }

//    @GetMapping
//    public ResponseEntity<List<Bookshelf>> findBookshelfByUserId(@RequestParam Long userId){
//        List<Bookshelf> userBookshelves = bookshelfService.findBookshelfById(userId);
//        return new ResponseEntity<>(userBookshelves, HttpStatus.FOUND);
//    }

    @PatchMapping(value = "/{id}/rating")
    public ResponseEntity<Bookshelf> updateRating(@RequestBody RatingDTO ratingDTO, @PathVariable Long id){
        if (ratingDTO.getRating()<=10 && (ratingDTO.getRating()>=0)){
            Bookshelf updateRating = bookshelfService.updateRating(ratingDTO, id);
            return new ResponseEntity<>(updateRating, HttpStatus.OK);
        }
        else {
            throw new IllegalArgumentException("Rating must be less that or equal to 10");
        }

    }









}
