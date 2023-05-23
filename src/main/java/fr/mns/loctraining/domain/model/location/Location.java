package fr.mns.loctraining.domain.model.location;

import fr.mns.loctraining.domain.model.common.BaseEntity;
import fr.mns.loctraining.domain.model.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Location extends BaseEntity {

    private String reason;
    private Date previsionnalStartingDate;
    private Date previsionnalEndDate;
    private Date extensionDate;
    private Date extensionValidationDate;
    private LocationStatus status;
    private Date decisionDate;

    @CreatedDate
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
