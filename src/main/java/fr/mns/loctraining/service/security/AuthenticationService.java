package fr.mns.loctraining.service.security;

import fr.mns.loctraining.vo.security.LoginRequest;
import fr.mns.loctraining.vo.user.user.UserCreateRequest;

public interface AuthenticationService {

    String login(LoginRequest request);

    boolean registration(UserCreateRequest request);
}
