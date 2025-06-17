package com.services;

import com.dto.UserRegistrationRequest;
import com.dto.UserRegistrationResponse;
import com.entities.User;
import com.exceptions.UserAlreadyExistsExceptions;
import com.mapper.UserRegistrationMapper;
import com.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    public UserRegistrationResponse registerUser(UserRegistrationRequest request) {
        if (userRepository.findByLogin(request.getLogin()).isPresent()) {
            throw new UserAlreadyExistsExceptions("Login już istnieje.");
        }
        UserRegistrationMapper userRegistrationMapper = new UserRegistrationMapper();
        String hashedPassword = passwordEncoder.encode(request.getPassword());
        User user = new User();
        user.setLogin(request.getLogin());
        user.setPassword(hashedPassword);
        userRepository.save(user);

        return userRegistrationMapper.mapUserToUserDto(user);
    }
}
