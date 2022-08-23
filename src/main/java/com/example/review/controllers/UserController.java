package com.example.review.controllers;

import com.example.review.models.User;
import com.example.review.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("save")
    public ResponseEntity<?> saveUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok().body(userService.saveUser(user));
    }
}
