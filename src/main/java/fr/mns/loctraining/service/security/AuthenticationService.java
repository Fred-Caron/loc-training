package fr.mns.loctraining.service.security;

import fr.mns.loctraining.domain.model.user.User;

public interface AuthenticationService {
    String connection(User user);

}
