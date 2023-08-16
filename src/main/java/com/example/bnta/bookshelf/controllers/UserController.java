package com.example.bnta.bookshelf.controllers;

import com.example.bnta.bookshelf.models.User;
import com.example.bnta.bookshelf.models.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bnta.bookshelf.services.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    UserService userService;

    //SHOW

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @GetMapping(value = "/{id}") //localhost8080:users/1/bookshelf
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    //UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id){
        User updatedUser = userService.updateUser(userDTO, id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }


    //CREATE

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    //DELETE

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id){
        User user = userService.deleteUser(id);
        return new ResponseEntity<>(id, HttpStatus.GONE);
    }

}
