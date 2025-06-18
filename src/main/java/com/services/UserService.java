package com.services;

import com.dto.UserRegistrationRequest;
import com.dto.UserRegistrationResponse;
import com.entities.User;
import com.exceptions.UserAlreadyExistsExceptions;
import com.mapper.UserRegistrationMapper;
import com.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

public class UserService {
    private final UserRepository userRepository;
    private final UserRegistrationMapper userRegistrationMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserRegistrationMapper userRegistrationMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRegistrationMapper = userRegistrationMapper;
        this.passwordEncoder = passwordEncoder;

    }

    @Transactional
    public UserRegistrationResponse registerUser(UserRegistrationRequest request) {
        if (userRepository.findByLogin(request.login()).isPresent()) {
            throw new UserAlreadyExistsExceptions("User already exists");
        }
        String hashedPassword = encodePassword(request);
        User user = new User();
        user.setLogin(request.login());
        user.setPassword(hashedPassword);
        userRepository.save(user);

        return userRegistrationMapper.mapUserToUserDto(user);
    }

    private String encodePassword(UserRegistrationRequest request) {
        String hashedPassword = passwordEncoder.encode(request.password());
        return hashedPassword;
    }
}
