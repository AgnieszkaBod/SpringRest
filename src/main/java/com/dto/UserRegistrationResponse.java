package com.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserRegistrationResponse {
    private String login;
    private UUID id;
}
