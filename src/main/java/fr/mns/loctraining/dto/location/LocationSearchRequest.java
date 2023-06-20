package fr.mns.loctraining.dto.location;

import fr.mns.loctraining.domain.model.location.LocationStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LocationSearchRequest {

    private Integer userId;
    private String search;
    private LocationStatus status;
    private Date previsionnalStartingDate;
    private Date creationDate;
}
