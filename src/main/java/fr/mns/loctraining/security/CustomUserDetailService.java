package fr.mns.loctraining.security;

import fr.mns.loctraining.domain.model.user.User;
import fr.mns.loctraining.domain.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Cette classe permet de surcharger le comportement par défaut de Spring Security
// C'est un service comme un autre qui implémente l'interface Spring UserDetailsService
@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    // Méthodé qui provider de UserDetailsService qui permet de charger les détails d'un user sur base du username (ici username = email)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findFirstByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with email %s does not exist", username));
        }
        return new CustomUserDetails(user);
    }
}
