package fr.mns.loctraining.vo.location;

import fr.mns.loctraining.domain.model.user.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LocationUpdateRequest {
    private Date askingDate;
    private String reason;
    private Date previsionnalStartingDate;
    private Date previsionnalEndDate;
    private Date extentionDate;
    private Date extendionDateValidation;
    private Date extensionDuration;
    private String decision;
    private Date decisionDate;
    private User user;
}
