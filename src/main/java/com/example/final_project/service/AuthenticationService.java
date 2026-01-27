package com.example.final_project.service;

import com.example.final_project.dto.AuthResponse;
import com.example.final_project.dto.LoginRequest;
import com.example.final_project.dto.RegisterRequest;
import com.example.final_project.model.Role;
import com.example.final_project.model.User;
import com.example.final_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;

        public AuthResponse register(RegisterRequest request) {
                var user = User.builder()
                                .name(request.getName())
                                .email(request.getEmail())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(request.getRole() != null ? request.getRole() : Role.USER)
                                .build();
                userRepository.save(user);
                return AuthResponse.builder()
                                .message("User registered successfully")
                                .build();
        }

        public AuthResponse login(LoginRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                request.getEmail(),
                                                request.getPassword()));
                // var user = userRepository.findByEmail(request.getEmail())
                // .orElseThrow();
                // In a real app, generate JWT here
                return AuthResponse.builder()
                                .message("Login successful")
                                .token("BASIC_AUTH_ENABLED")
                                .build();
        }
}
