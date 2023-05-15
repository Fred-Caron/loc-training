package fr.mns.loctraining.domain.model.location;

import fr.mns.loctraining.domain.model.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Location extends BaseEntity {
    private Date askingDate;
    private String reason;
    private Date previsionnalStartingDate;
    private Date previsionnalEndDate;
    private Date extentionDate;
    private Date extendionDateValidation;
    private Date extensionDuration;
    private String decision;
    private Date decisionDate;
}
