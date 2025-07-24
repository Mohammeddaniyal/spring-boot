package com.daniyal.journalApp.controller;

import com.daniyal.journalApp.entity.User;
import com.daniyal.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void createUser(@RequestBody User user)
    {
        userService.saveEntry(user);
    }
    @GetMapping
    public List<User> getAllUsers()
    {
        return userService.getAll();
    }
    @PutMapping("/username/{username}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String username)
    {
        User userInDb=userService.findByUsername(username);
        if(userInDb!=null) {
            userInDb.setUsername(user.getUsername());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
