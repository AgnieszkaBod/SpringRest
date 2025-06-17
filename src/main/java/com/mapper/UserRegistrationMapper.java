package com.mapper;

import com.dto.UserRegistrationResponse;
import com.entities.User;


public class UserRegistrationMapper {

    public UserRegistrationResponse mapUserToUserDto(User user) {
        UserRegistrationResponse userRegistrationResponse = new UserRegistrationResponse();
        userRegistrationResponse.setLogin(user.getLogin());
        userRegistrationResponse.setId(user.getUuid());
        return userRegistrationResponse;
    }
}
