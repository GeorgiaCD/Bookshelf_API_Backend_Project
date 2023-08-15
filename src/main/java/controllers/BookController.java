package controllers;

import models.Book;
import models.BookDTO;
import models.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.BookService;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.RecursiveTask;

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
    public ResponseEntity<List<Book>> getALlBooksAndGenres(@RequestParam(required = false, name ="genre") int genreId,
                                                           @RequestParam(required = false, name ="author") Long authorId,
                                                           @RequestParam(required = false, name ="year") int year,
                                                           @RequestParam(required = false, name ="length") int length)
    {
        List<Book> filteredBooks = bookService.getFilteredBooks(genreId, authorId, year, length);

        if(filteredBooks.isEmpty()){
            List<Book> allBooks = bookService.getAllBooks();
            return new ResponseEntity<>(allBooks, HttpStatus.OK);
        }
        return new ResponseEntity<>(filteredBooks, HttpStatus.OK);
    }



//    SHOW
    @GetMapping(value = "/{id")
    public ResponseEntity<Optional<Book>> getBook(@PathVariable Long id){
        Book foundBook = bookService.findBookById(id);
        return new ResponseEntity(foundBook, HttpStatus.OK);
    }

//    CREATE
    @PostMapping
    public ResponseEntity<List<Book>> addBook(@RequestBody BookDTO bookDTO){
        bookService.saveBook(bookDTO);
        return new RequestBody(bookService.getAllBooks(), HttpStatus.CREATED);
    }

//    UPDATE
    @PutMapping(value = "/{id")
    public ResponseEntity<Book> updateBook(@RequestBody BookDTO bookDTO, @PathVariable Long id){
        Book updatedBook = bookService.updateBook(bookDTO, id);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    //    DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}
