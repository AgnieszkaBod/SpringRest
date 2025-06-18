package com.services;

import com.mapper.ItemMapper;
import com.mapper.UserRegistrationMapper;
import com.repository.ItemRepository;
import com.repository.UserRepository;
import com.tools.security.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ServicesConfiguration {
    @Bean
    public UserService userService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        UserRegistrationMapper userRegistrationMapper = new UserRegistrationMapper();
        return new UserService(userRepository, userRegistrationMapper, passwordEncoder);
    }

    @Bean
    public ItemService itemService(ItemRepository itemRepository, UserRepository userRepository) {
        ItemMapper itemMapper = new ItemMapper();
        return new ItemService(itemRepository, itemMapper, userRepository);
    }

    @Bean
    AuthService authService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtil) {
        return new AuthService(userRepository, passwordEncoder, jwtUtil);
    }
}
