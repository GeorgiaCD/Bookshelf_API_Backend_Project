package com.example.bnta.bookshelf.controllers;

import com.example.bnta.bookshelf.models.Author;
import com.example.bnta.bookshelf.models.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bnta.bookshelf.services.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

// GET by name (else)
// GET all author
    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(@RequestParam(required = false, name = "name") String name){
        if(name!= null){
            return new ResponseEntity(authorService.getAuthorByName(name), HttpStatus.OK);
        }
        List<Author> allAuthors = authorService.getAllAuthors();
        return new ResponseEntity<>(allAuthors, HttpStatus.OK);
    }


// GET by author id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id){
        Author author = authorService.getAuthorById(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

// POST add an author
   @PostMapping
   public ResponseEntity<List<Author>> addAuthor(@RequestBody AuthorDTO authorDTO){
        authorService.saveAuthor(authorDTO);
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.CREATED);
   }

//   UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Author> updateAuthor(@RequestBody AuthorDTO authorDTO, @PathVariable Long id){
        Author updatedAuthor = authorService.updateAuthor(authorDTO, id);
        return new ResponseEntity(updatedAuthor, HttpStatus.OK);
    }



// DELETE delete an author
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
