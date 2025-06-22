package com.example.HNDShopBackEnd.controller;

import com.example.HNDShopBackEnd.entity.User;
import com.example.HNDShopBackEnd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> UserRegister(@Validated @RequestBody User user) {
        ResponseEntity<?> response = userService.UserRegister(user);
        return response;
    }
}
