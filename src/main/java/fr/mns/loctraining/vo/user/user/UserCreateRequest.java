package fr.mns.loctraining.vo.user.user;

import fr.mns.loctraining.domain.model.user.UserAffiliation;
import fr.mns.loctraining.domain.model.user.UserGender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {
    private String lastname;
    private String firstname;
    private String email;
    private String password;
    private String login;
    private UserGender gender;
    private UserAffiliation affiliation;
    private String phone;
    // Ici on ajoute l'id du status dans la request
    private Integer statusId;
}
