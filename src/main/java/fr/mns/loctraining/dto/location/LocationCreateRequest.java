package fr.mns.loctraining.dto.location;

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
