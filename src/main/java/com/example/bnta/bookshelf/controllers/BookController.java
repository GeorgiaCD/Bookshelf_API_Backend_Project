package com.example.bnta.bookshelf.controllers;


import com.example.bnta.bookshelf.models.Book;
import com.example.bnta.bookshelf.models.BookDTO;
import com.example.bnta.bookshelf.models.Genre;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bnta.bookshelf.services.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

//    Handles following:
//    * GET /books
//    * GET /books?genre="cooking"
//    * GET / books?author_id = 1
//    * GET / books?year = 1991
//    * GET / books?length > 200

//    INDEX
    @GetMapping
    public ResponseEntity<List<Book>> getAllFilteredBooks(@RequestParam(required = false, name ="genre") Genre genre,
                                                           @RequestParam(required = false, name ="authorId") Long authorId,
                                                           @RequestParam(required = false, name ="year") Integer year,
                                                           @RequestParam(required = false, name ="length") Integer length)
    {
        if(genre != null){
            List<Book> booksByGenre = bookService.getByGenre(genre);
            return new ResponseEntity<>(booksByGenre, HttpStatus.OK);
        }
        if(authorId != null){
            List<Book> bookByAuthor = bookService.getByAuthorId(authorId);
            return new ResponseEntity<>(bookByAuthor, HttpStatus.OK);
        }
        if(year != null){
            List<Book> booksByYear = bookService.getByYear(year);
            return new ResponseEntity<>(booksByYear, HttpStatus.OK);
        }
        if(length != null){
            List<Book> booksByLength = bookService.getByLength(length);
            return new ResponseEntity<>(booksByLength, HttpStatus.OK);
        }

        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }


    //    SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Book>> getBook(@PathVariable Long id) {
        Book foundBook = bookService.findBookById(id);
        return new ResponseEntity(foundBook, HttpStatus.OK);
    }

    //    CREATE
    @PostMapping
    public ResponseEntity<List<Book>> addBook(@RequestBody BookDTO bookDTO) {
        bookService.saveBook(bookDTO);
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.CREATED);
    }

    //    UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody BookDTO bookDTO, @PathVariable Long id) {
        Book updatedBook = bookService.updateBook(bookDTO, id);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    //    DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
