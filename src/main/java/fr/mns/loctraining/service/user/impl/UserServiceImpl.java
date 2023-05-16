package fr.mns.loctraining.service.userImpl;


import fr.mns.loctraining.domain.repository.user.UserRepository;

import fr.mns.loctraining.service.user.UserService;
import fr.mns.loctraining.vo.user.user.UserCreateRequest;
import fr.mns.loctraining.vo.user.user.UserDetails;
import fr.mns.loctraining.vo.user.user.UserUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDetails getDetail(Integer id) {
        return null;
    }

    @Override
    public List<UserDetails> getList() {
        return null;
    }

    @Override
    public UserDetails create(UserCreateRequest request) {
        return null;
    }

    @Override
    public UserDetails update(Integer id, UserUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
