package fr.mns.loctraining.dto.material.model;

import fr.mns.loctraining.dto.material.brand.BrandDetails;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelDetails {
    private int id;

    private String name;
    private BrandDetails brand;

}
