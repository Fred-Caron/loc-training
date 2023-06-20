package fr.mns.loctraining.dto.location;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LocationUpdateRequest {
    private String reason;
    private Date previsionnalStartingDate;
    private Date previsionnalEndDate;
    private Date extensionDate;

}
