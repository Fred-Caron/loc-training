package fr.mns.loctraining.service.security.impl;

import fr.mns.loctraining.domain.model.user.User;
import fr.mns.loctraining.domain.repository.user.UserRepository;
import fr.mns.loctraining.security.CustomUserDetailService;
import fr.mns.loctraining.security.CustomUserDetails;
import fr.mns.loctraining.security.JwtUtils;
import fr.mns.loctraining.service.security.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    CustomUserDetailService customUserDetailService;

    @PostMapping("/connection")
    public String connection(@RequestBody User user) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getEmail(),
                            user.getPassword()
                    ));
        } catch (BadCredentialsException e) {
            throw new IllegalArgumentException("Fail to connect : email or password incorrect");
        }
        CustomUserDetails customUserDetail = (CustomUserDetails) customUserDetailService.loadUserByUsername(user.getEmail());
        return JwtUtils.generateJwt(customUserDetail);
    }

}
