package com.daniyal.journalApp.service;

import com.daniyal.journalApp.entity.User;
import com.daniyal.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveEntry(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("User"));
        userRepository.save(user);
    }

    

    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }
}


