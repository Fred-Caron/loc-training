package fr.mns.loctraining.dto.material.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelCreateRequest {
    private String name;

    private Integer brandId;
}
