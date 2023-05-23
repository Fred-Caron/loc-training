package fr.mns.loctraining.vo.material.model;

import fr.mns.loctraining.domain.model.material.Brand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelDetails {
    private int id;

    private String name;
    private Brand brand;
}
