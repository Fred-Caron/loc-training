package fr.mns.loctraining.controller.security;

import fr.mns.loctraining.service.security.AuthenticationService;
import fr.mns.loctraining.vo.security.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "authentication")
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("login")
    public String login(@RequestBody LoginRequest request) {
        return authenticationService.login(request);
    }
}
