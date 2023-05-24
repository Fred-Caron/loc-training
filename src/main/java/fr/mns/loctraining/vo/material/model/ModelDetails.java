package fr.mns.loctraining.vo.material.model;

import fr.mns.loctraining.vo.material.brand.BrandDetails;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelDetails {
    private int id;

    private String name;
    private BrandDetails brand;

}
