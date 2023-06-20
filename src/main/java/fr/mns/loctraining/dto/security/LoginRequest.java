package fr.mns.loctraining.dto.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    private String username;
    private String password;
}
