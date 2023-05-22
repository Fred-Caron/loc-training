package fr.mns.loctraining.vo.location;

import fr.mns.loctraining.domain.model.location.LocationStatus;
import fr.mns.loctraining.domain.model.user.User;
import fr.mns.loctraining.vo.user.user.UserDetails;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LocationDetails {
    private int id;
    private Date creationDate;
    private String reason;
    private Date previsionnalStartingDate;
    private Date previsionnalEndDate;
    private Date extensionDate;
    private Date extensionValidationDate;
    private Integer extensionDuration;
    private LocationStatus status;
    private Date decisionDate;

    private UserDetails user;
}
