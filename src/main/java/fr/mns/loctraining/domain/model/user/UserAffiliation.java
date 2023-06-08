package fr.mns.loctraining.domain.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserAffiliation {
    MNS("Metz Numeric School"),

    IFA("IFA");
    private final String name;
}
