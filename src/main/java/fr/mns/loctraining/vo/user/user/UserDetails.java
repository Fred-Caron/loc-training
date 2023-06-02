package fr.mns.loctraining.vo.user.user;

import fr.mns.loctraining.domain.model.user.UserGender;
import fr.mns.loctraining.vo.user.status.StatusDetails;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetails {
    private int id;
    private String lastname;
    private String firstname;
    private String email;
    private String login;
    private UserGender gender;
    private String affiliation;
    private String phone;
    // Ici on ajoute le details du status (id + name)
    private StatusDetails status;
}
