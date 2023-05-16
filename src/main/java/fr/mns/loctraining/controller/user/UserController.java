package fr.mns.loctraining.controller.user;

import fr.mns.loctraining.service.UserService;
import fr.mns.loctraining.vo.user.user.UserCreateRequest;
import fr.mns.loctraining.vo.user.user.UserDetails;
import fr.mns.loctraining.vo.user.user.UserUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("{id}")
    public UserDetails getDetails(@PathVariable Integer id){
        return userService.getDetail(id);
    }

    @GetMapping
    public List<UserDetails> getList(){ return userService.getList();}

    @PutMapping
    public UserDetails create(@RequestBody UserCreateRequest request){
        return userService.create(request);
    }
    @PostMapping("{id}")
    public UserDetails update(@PathVariable Integer id, @RequestBody UserUpdateRequest request){
        return userService.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        userService.delete(id);
    }



}
