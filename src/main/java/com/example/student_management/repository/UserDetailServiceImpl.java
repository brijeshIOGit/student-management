package com.example.student_management.repository;

import com.example.student_management.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {


    private final UserRepository userRepository;
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        // Convert your User roles to Spring Security's GrantedAuthority
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword()) // Password is already encoded
                .roles(user.getRoles().stream()
                        .map(Enum::name) // Convert Role enum to String name
                        .toList()
                        .toArray(new String[0])) // Convert to String array for .roles()
                .build();


    }
}
