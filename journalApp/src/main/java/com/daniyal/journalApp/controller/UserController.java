package com.daniyal.journalApp.controller;

import com.daniyal.journalApp.entity.User;
import com.daniyal.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
}
