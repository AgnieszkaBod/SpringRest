package com.services;

import com.dto.UserRegistrationRequest;
import com.dto.UserRegistrationResponse;
import com.entities.User;
import com.exceptions.UserAlreadyExistsExceptions;
import com.mapper.UserRegistrationMapper;
import com.repository.UserRepository;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Setter
public class UserService {
    private UserRepository userRepository;
    private UserRegistrationMapper userRegistrationMapper;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserRegistrationMapper userRegistrationMapper, PasswordEncoder passwordEncoder) {

    }

    public UserRegistrationResponse registerUser(UserRegistrationRequest request) {
        if (userRepository.findByLogin(request.getLogin()).isPresent()) {
            throw new UserAlreadyExistsExceptions("Login już istnieje.");
        }
        String hashedPassword = encodePassword(request);
        User user = new User();
        user.setLogin(request.getLogin());
        user.setPassword(hashedPassword);
        userRepository.save(user);

        return userRegistrationMapper.mapUserToUserDto(user);
    }

    private String encodePassword(UserRegistrationRequest request) {
        String hashedPassword = passwordEncoder.encode(request.getPassword());
        return hashedPassword;
    }
}
