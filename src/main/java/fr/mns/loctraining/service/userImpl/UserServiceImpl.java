package fr.mns.loctraining.service.userImpl;

import fr.mns.loctraining.domain.model.user.User;
import fr.mns.loctraining.domain.repository.user.UserRepository;
import fr.mns.loctraining.vo.user.user.UserDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl {
    private final UserRepository userRepository;

}
