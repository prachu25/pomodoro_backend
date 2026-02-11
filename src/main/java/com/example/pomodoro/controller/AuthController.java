package com.example.pomodoro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pomodoro.dto.LoginRequest;
import com.example.pomodoro.dto.RegisterRequest;
import com.example.pomodoro.entity.User;
import com.example.pomodoro.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authServ;

    // Register API
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest request) {

        if (authServ.emailExists(request.getEmail())) {
            return ResponseEntity.ok("Email already registered");
        }

        authServ.register(
                request.getName(),
                request.getEmail(),
                request.getPassword());

        return ResponseEntity.ok("User registered successfully");
    }

    // Login API
    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {
        return authServ.login(
                request.getEmail(),
                request.getPassword());
    }

}
