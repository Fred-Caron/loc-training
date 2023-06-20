package fr.mns.loctraining.domain.model.location;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LocationStatus {

    DRAFT("DRAFT"),
    PENDING("PENDING"),
    VALIDATED("VALIDATED"),
    REJECTED("REJECTED"),
    DONE("DONE");

    private final String name;
}
