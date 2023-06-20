package fr.mns.loctraining.controller.user;

import fr.mns.loctraining.dto.user.user.UserCreateRequest;
import fr.mns.loctraining.dto.user.user.UserDetails;
import fr.mns.loctraining.dto.user.user.UserSearchRequest;
import fr.mns.loctraining.dto.user.user.UserUpdateRequest;
import fr.mns.loctraining.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("{id}")
    public UserDetails getDetails(@PathVariable Integer id) {
        return userService.getDetails(id);
    }

    @GetMapping
    public List<UserDetails> getList() {
        return userService.getList();
    }

    @PutMapping
    public UserDetails create(@RequestBody UserCreateRequest request) {
        return userService.create(request);
    }

    @PostMapping("{id}")
    public UserDetails update(@PathVariable Integer id, @RequestBody UserUpdateRequest request) {
        return userService.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }

    @PostMapping
    public List<UserDetails> search(@RequestBody UserSearchRequest request) {
        return userService.search(request);
    }
}
