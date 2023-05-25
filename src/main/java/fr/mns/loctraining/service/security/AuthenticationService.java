package fr.mns.loctraining.service.security;

import fr.mns.loctraining.domain.model.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationService {
    String connection(User user);

}
