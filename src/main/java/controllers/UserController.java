package controllers;

import models.Bookshelf;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody String name){
        User user = userService.addUser(name);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}") //localhost8080:user/1
    public ResponseEntity<List<Bookshelf>> getBookshelfByUserId(@PathVariable Long id){
        List<Bookshelf> bookshelves = userService.getBookshelfByUserId(id);
        return new ResponseEntity<>(bookshelves, HttpStatus.FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        User user = userService.deleteUser(id);
        return new ResponseEntity<>(user, HttpStatus.GONE);
    }

}
