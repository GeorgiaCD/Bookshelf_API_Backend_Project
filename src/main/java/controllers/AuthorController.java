package controllers;

import models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

// get by name
// GET all author
    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> allAuthors = authorService.getAllAuthors();
        return new ResponseEntity<>(allAuthors, HttpStatus.OK);
    }


// GET by author id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Author> getAuthorById(Long id){
        Author author = authorService.getAuthorById(id);
        return new ResponseEntity<>(author, HttpStatus.OK)
    }

// POST add an author
   @PostMapping
   public ResponseEntity<List<Author>> addAuthor(Author author){
        authorService.saveAuthor(author);
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.CREATED);
   }


// DELETE delete an author
    @GetMapping(value = "/{id}")
    public ResponseEntity<Long> deleteAuthor(Long id){
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
