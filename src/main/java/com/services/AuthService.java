package com.services;

import com.dto.LoginRequest;
import com.dto.LoginResponse;
import com.entities.User;
import com.repository.UserRepository;
import com.tools.security.JwtUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtil;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtils jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByLogin(request.login())
                .orElseThrow(() -> new RuntimeException("Login or password incorrect"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new RuntimeException("Login or password incorrect");
        }

        String token = jwtUtil.generateToken(user.getLogin());
        return new LoginResponse(token);
    }
}
