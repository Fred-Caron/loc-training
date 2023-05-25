package fr.mns.loctraining.controller.security;

import fr.mns.loctraining.domain.model.user.User;
import fr.mns.loctraining.domain.repository.user.UserRepository;
import fr.mns.loctraining.security.CustomUserDetailService;
import fr.mns.loctraining.security.CustomUserDetails;
import fr.mns.loctraining.security.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "authentication")
@AllArgsConstructor
public class AuthenticationController {
    AuthenticationManager authenticationManager;
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    JwtUtils jwtUtils;
    CustomUserDetailService customUserDetailService;

    CustomUserDetails customUserDetails;

    public String connection(@RequestBody User user) {
        return JwtUtils.generateJwt(customUserDetails);
    }
}
