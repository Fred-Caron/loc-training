package fr.mns.loctraining.dto.user.user;

import fr.mns.loctraining.domain.model.user.UserAffiliation;
import fr.mns.loctraining.domain.model.user.UserGender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchRequest {
    private String search;
    private UserGender gender;
    private UserAffiliation affiliation;
    private Integer statusId;
}
