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
    private Date askingDateLocation;
    private String reasonLocation;
    private Date previsionnalStartingDateLocation;
    private Date previsionnalEndDateLocation;
    private Date extentionDate;
    private Date extendionDateValidation;
    private Date extensionDuration;
    private String decision;
    private Date decisionDate;
}
