package fr.mns.loctraining.service;

import fr.mns.loctraining.domain.model.user.User;
import fr.mns.loctraining.vo.user.user.UserCreateRequest;
import fr.mns.loctraining.vo.user.user.UserDetails;
import fr.mns.loctraining.vo.user.user.UserUpdateRequest;

import java.util.List;

public interface UserService {
    UserDetails getDetail(Integer id);
    List<UserDetails> getList();
    UserDetails create (UserCreateRequest request);
    UserDetails update (Integer id, UserUpdateRequest request);
    void delete(Integer id);
}
