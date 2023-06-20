package fr.mns.loctraining.service.security;

import fr.mns.loctraining.dto.security.LoginRequest;

public interface AuthenticationService {

    String login(LoginRequest request);

}
