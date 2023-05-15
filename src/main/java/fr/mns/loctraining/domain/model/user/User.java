package fr.mns.loctraining.domain.model.user;

import fr.mns.loctraining.domain.model.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Entity
@Getter
@Setter
public class User extends BaseEntity {

    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String login;
    private String sexe;
    private String phone;
    private File picture;
}
