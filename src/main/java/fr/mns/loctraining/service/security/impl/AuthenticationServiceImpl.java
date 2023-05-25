package fr.mns.loctraining.service.security.impl;

import fr.mns.loctraining.security.CustomUserDetailService;
import fr.mns.loctraining.security.CustomUserDetails;
import fr.mns.loctraining.security.JwtUtils;
import fr.mns.loctraining.service.security.AuthenticationService;
import fr.mns.loctraining.vo.security.LoginRequest;
import fr.mns.loctraining.vo.user.user.UserCreateRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailService customUserDetailService;

    @Override
    public String login(LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    ));
        } catch (BadCredentialsException e) {
            throw new IllegalArgumentException("Fail to connect : email or password incorrect");
        }
        CustomUserDetails customUserDetail = (CustomUserDetails) customUserDetailService.loadUserByUsername(request.getUsername());
        return JwtUtils.generateJwt(customUserDetail);
    }

    @Override
    public boolean registration(UserCreateRequest request) {
        // 1. Faire appel au service UserService > create
        // 2. Si tout s'est bien passé (on reçoit bien un UserDetails) alors on retourne true
        // 3. Sinon on retourne false
        return true;
    }

}
