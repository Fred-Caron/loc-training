package fr.mns.loctraining.service.user.impl;

import fr.mns.loctraining.domain.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl {
    private final UserRepository userRepository;

}
