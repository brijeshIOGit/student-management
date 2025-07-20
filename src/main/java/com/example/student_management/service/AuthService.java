package com.example.student_management.service;

import com.example.student_management.dto.AuthRequest;
import com.example.student_management.exception.ResourceNotFoundException;
import com.example.student_management.model.User;
import com.example.student_management.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service
public class AuthService {
    public final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(AuthRequest authRequest){
        if(userRepository.existsByUsername(authRequest.getUsername())){
            throw new ResourceNotFoundException("Username '" + authRequest.getUsername() + "' already exists.");
        }

        User user = new User();
        user.setUsername(authRequest.getUsername());
        user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        user.setRoles(new HashSet<>(Collections.singletonList(User.UserRole.USER)));

        return userRepository.save(user);


    }

}
