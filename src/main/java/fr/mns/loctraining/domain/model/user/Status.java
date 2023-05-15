package fr.mns.loctraining.domain.model.user;

import fr.mns.loctraining.domain.model.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Status extends BaseEntity {
    private String name;
}
