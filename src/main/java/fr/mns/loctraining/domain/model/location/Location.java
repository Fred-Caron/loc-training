package fr.mns.loctraining.domain.model.location;

import fr.mns.loctraining.domain.model.common.BaseEntity;
import fr.mns.loctraining.domain.model.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private Date extentionDateValidation;
    private Date extensionDuration;
    private String decision;
    private Date decisionDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
