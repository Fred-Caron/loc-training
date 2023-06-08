package fr.mns.loctraining.domain.repository.user;

import fr.mns.loctraining.domain.model.user.User;
import fr.mns.loctraining.vo.user.user.UserSearchRequest;

import java.util.List;

public interface UserCustomRepository {
    List<User> search(UserSearchRequest request);
}
