package fr.mns.loctraining.service.user.impl;


import fr.mns.loctraining.domain.model.user.User;
import fr.mns.loctraining.domain.repository.user.UserRepository;

import fr.mns.loctraining.service.user.UserService;
import fr.mns.loctraining.tools.exception.BadRequestException;
import fr.mns.loctraining.tools.exception.NotFoundException;
import fr.mns.loctraining.vo.user.user.UserCreateRequest;
import fr.mns.loctraining.vo.user.user.UserDetails;
import fr.mns.loctraining.vo.user.user.UserUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDetails getDetail(Integer id) {
        User user = userRepository.findByIdNullSafe(id);
        if(user == null){
            throw new NotFoundException();
        }
        return getDetail(id);
    }

    @Override
    public List<UserDetails> getList() {
        List<User> userList = userRepository.findAll();
        List<UserDetails> userDetailsList = new ArrayList<>();
        for (User user : userList) {
            UserDetails details = getDetail(user.getId());
            userDetailsList.add(details);
        }
        return userDetailsList;
    }

    @Override
    public UserDetails create(UserCreateRequest request) {
        if(!StringUtils.hasText(request.getLastname()) || !StringUtils.hasText(request.getFirstname())){
            throw new BadRequestException("Firstname or lastname should not be empty");
        }
        if(!StringUtils.hasText(request.getEmail())){
            throw new BadRequestException("Email should not be empty");
        }
        if(!StringUtils.hasText(request.getPassword())){
            throw new BadRequestException("Password should not be empty");
        }
        if(!StringUtils.hasText(request.getLogin())){
            throw new BadRequestException("Login should not be empty");
        }
        if(!StringUtils.hasText(request.getGender())){
            throw new BadRequestException("Gender should not be empty");
        }
        if(!StringUtils.hasText(request.getAffiliation())){
            throw new BadRequestException("Affiliation should not be empty");
        }
        if(!StringUtils.hasText(request.getPhone())){
            throw new BadRequestException("Phone should not be empty");
        }
        //le status ?
        User user = new User();
        user.setFirstName(request.getFirstname());
        user.setLastName(request.getLastname());
        user.setEmail(request.getEmail());
        user.setLogin(request.getLogin());
        user.setGender(request.getGender());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setAffiliation(request.getAffiliation());
        user = userRepository.save(user);
        return getDetail(user.getId());
    }

    @Override
    public UserDetails update(Integer id, UserUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
