package fr.mns.loctraining.domain.model.user;

import fr.mns.loctraining.domain.model.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends BaseEntity {

    private String lastname;
    private String firstname;
    private String email;
    private String password;
    private String login;
    @Enumerated(EnumType.STRING)
    private UserGender gender;
    private String phone;
    @Enumerated(EnumType.STRING)
    private UserAffiliation affiliation;

    // L'annotation ManyToOne indique une relation ManyToOne, ici on indique une relation ManyToOne entre User et Status
    @ManyToOne
    // L'annotation JoinColumn sert à faire la jointure, ici on fait la jointure sur la colonne 'statusId'
    @JoinColumn(name = "statusId")
    private Status status;
}
