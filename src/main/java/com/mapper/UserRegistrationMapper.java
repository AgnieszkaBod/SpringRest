package com.mapper;

import com.dto.UserRegistrationResponse;
import com.entities.User;


public class UserRegistrationMapper {

    public UserRegistrationResponse mapUserToUserDto(User user) {
        return new UserRegistrationResponse(user.getLogin(), user.getUuid());
    }
}
