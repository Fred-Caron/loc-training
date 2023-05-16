package fr.mns.loctraining.vo.user.user;

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
    private String gender;
    private String affiliation;
    private int phone;
}
