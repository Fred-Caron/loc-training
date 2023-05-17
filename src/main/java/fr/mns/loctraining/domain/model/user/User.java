package fr.mns.loctraining.domain.model.user;

import fr.mns.loctraining.domain.model.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Entity
@Getter
@Setter
public class User extends BaseEntity {

    private String lastname;
    private String firstname;
    private String email;
    private String password;
    private String login;
    private String gender;
    private String phone;
    private String affiliation;

    // L'annotation ManyToOne indique une relation ManyToOne, ici on indique une relation ManyToOne entre User et Status
    @ManyToOne
    // L'annotation JoinColumn sert à faire la jointure, ici on fait la jointure sur la colonne 'statusId'
    @JoinColumn(name = "statusId")
    private Status status;
}
