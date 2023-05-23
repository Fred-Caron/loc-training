package fr.mns.loctraining.security;

import fr.mns.loctraining.domain.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

// Vo qui implémente UserDetails de Spring Security, elle permet d'avoir tous les détails nécessaires à l'utilisateur connecté
@AllArgsConstructor
@Getter
@Setter
public class CustomUserDetails implements UserDetails {

    // Ici c'est notre User de DB qui contient toutes les données nécessaires
    // UserDetails est Serializable et on ne veut pas sérializé ce champ donc on ajoute le mot clé transient
    private final transient User user;

    // On remplit ensuite les méthodes provenant de UserDetails avec les infos que l'on peut avoir de notre user
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(user.getStatus().getName()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    // Pour les méthodes suivantes, on ne peut pas extraire l'info de User, on met donc true partout
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
