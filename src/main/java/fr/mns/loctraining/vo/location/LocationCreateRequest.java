package fr.mns.loctraining.vo.location;

import fr.mns.loctraining.domain.model.user.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LocationCreateRequest {
    private String reason;
    private Date previsionnalStartingDate;
    private Date previsionnalEndDate;
    private Integer userId;
}
