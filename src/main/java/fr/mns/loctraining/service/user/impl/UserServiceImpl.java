package fr.mns.loctraining.service.user.impl;

import fr.mns.loctraining.domain.model.user.Status;
import fr.mns.loctraining.domain.model.user.User;
import fr.mns.loctraining.domain.repository.user.StatusRepository;
import fr.mns.loctraining.domain.repository.user.UserRepository;
import fr.mns.loctraining.service.user.UserService;
import fr.mns.loctraining.tools.exception.BadRequestException;
import fr.mns.loctraining.tools.exception.NotFoundException;
import fr.mns.loctraining.tools.utils.MappingUtils;
import fr.mns.loctraining.vo.user.user.UserCreateRequest;
import fr.mns.loctraining.vo.user.user.UserDetails;
import fr.mns.loctraining.vo.user.user.UserUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final StatusRepository statusRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails getDetails(Integer id) {
        User user = userRepository.findByIdNullSafe(id);
        if (user == null) {
            throw new NotFoundException();
        }
        return MappingUtils.getUserDetails(user);
    }

    @Override
    public List<UserDetails> getList() {
        List<User> userList = userRepository.findAll();
        List<UserDetails> userDetailsList = new ArrayList<>();
        for (User user : userList) {
            UserDetails details = MappingUtils.getUserDetails(user);
            userDetailsList.add(details);
        }
        return userDetailsList;
    }

    @Override
    public UserDetails create(UserCreateRequest request) {
        if (!StringUtils.hasText(request.getLastname()) || !StringUtils.hasText(request.getFirstname())) {
            throw new BadRequestException("Firstname or lastname should not be empty");
        }
        if (!StringUtils.hasText(request.getEmail())) {
            throw new BadRequestException("Email should not be empty");
        }
        if (!StringUtils.hasText(request.getPassword())) {
            throw new BadRequestException("Password should not be empty");
        }
        if (!StringUtils.hasText(request.getLogin())) {
            throw new BadRequestException("Login should not be empty");
        }
        if (!StringUtils.hasText(request.getGender())) {
            throw new BadRequestException("Gender should not be empty");
        }
        if (!StringUtils.hasText(request.getAffiliation())) {
            throw new BadRequestException("Affiliation should not be empty");
        }
        if (!StringUtils.hasText(request.getPhone())) {
            throw new BadRequestException("Phone should not be empty");
        }
        // On récupère le status sur base de l'id de la request
        Status status = getStatus(request.getStatusId());

        User user = new User();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setLogin(request.getLogin());
        user.setGender(request.getGender());
        String hashPassword = passwordEncoder.encode(request.getPassword());
        user.setPassword(hashPassword);
        user.setPhone(request.getPhone());
        user.setAffiliation(request.getAffiliation());
        // On set le status
        user.setStatus(status);
        user = userRepository.save(user);
        return MappingUtils.getUserDetails(user);
    }

    @Override
    public UserDetails update(Integer id, UserUpdateRequest request) {
        User user = userRepository.findByIdNullSafe(id);
        if (user == null) {
            throw new NotFoundException();
        }
        if (!StringUtils.hasText(request.getLastname()) || !StringUtils.hasText(request.getFirstname())) {
            throw new BadRequestException("Firstname or lastname should not be empty");
        }
        if (!StringUtils.hasText(request.getEmail())) {
            throw new BadRequestException("Email should not be empty");
        }
        if (!StringUtils.hasText(request.getLogin())) {
            throw new BadRequestException("Login should not be empty");
        }
        if (!StringUtils.hasText(request.getGender())) {
            throw new BadRequestException("Gender should not be empty");
        }
        if (!StringUtils.hasText(request.getAffiliation())) {
            throw new BadRequestException("Affiliation should not be empty");
        }
        if (!StringUtils.hasText(request.getPhone())) {
            throw new BadRequestException("Phone should not be empty");
        }

        Status status = getStatus(request.getStatusId());

        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setLogin(request.getLogin());
        user.setGender(request.getGender());
        if (StringUtils.hasText(request.getPassword())) {
            String hashPassword = passwordEncoder.encode(request.getPassword());
            user.setPassword(hashPassword);
        }
        user.setPhone(request.getPhone());
        user.setAffiliation(request.getAffiliation());
        user.setStatus(status);
        user = userRepository.save(user);
        return MappingUtils.getUserDetails(user);

    }

    @Override
    public void delete(Integer id) {
        User user = userRepository.findByIdNullSafe(id);
        if (user == null) {
            throw new NotFoundException();
        }
        userRepository.delete(user);
    }

    // Méthode pour retrouver le status sur base de l'id
    // Si pas de status alors BadRequest
    private Status getStatus(Integer statusId) {
        return statusRepository.findByIdWithException(statusId, "status");
    }
}
