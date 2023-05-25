package fr.mns.loctraining.service.security;

import fr.mns.loctraining.vo.security.LoginRequest;

public interface AuthenticationService {
    String login(LoginRequest request);

}
