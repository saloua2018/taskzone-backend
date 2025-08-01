package com.example.project.service;

import com.example.project.dto.AuthRequest;
import com.example.project.dto.AuthResponse;
import com.example.project.model.User;
import com.example.project.repository.UserRepository;
import com.example.project.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepo, PasswordEncoder encoder, JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse login(AuthRequest req) {
        User user = userRepo.findByUsername(req.username);
        if (user != null && encoder.matches(req.password, user.password)) {
            String token = jwtUtil.generateToken(user.username);
            return new AuthResponse(token);
        }
        throw new RuntimeException("Invalid credentials");
    }

    public void register(AuthRequest req) {
        User user = new User();
        user.username = req.username;
        user.password = encoder.encode(req.password);
        user.role = "USER";
        userRepo.save(user);
    }
}
