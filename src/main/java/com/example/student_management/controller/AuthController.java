package com.example.student_management.controller;

import com.example.student_management.dto.AuthRequest;
import com.example.student_management.dto.RegisterUserResponse;
import com.example.student_management.model.User;
import com.example.student_management.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private  AuthService authService;




    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> registerUser(@Valid @RequestBody AuthRequest user) {
        User registeredUser = authService.registerUser(user);
        RegisterUserResponse response = new RegisterUserResponse(
                "User registered successfully",
                registeredUser.getUsername()
        );
        return ResponseEntity.ok(response);
    }

}
