package fr.mns.loctraining.vo.user.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequest {
    private String lastname;
    private String firstname;
    private String email;
    private String password;
    private String login;
    private String gender;
    private String affiliation;
    private String phone;
    // Ici on ajoute l'id du status dans la request
    private Integer statusId;
}
