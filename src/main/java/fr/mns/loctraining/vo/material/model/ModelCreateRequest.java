package fr.mns.loctraining.vo.material.model;

import fr.mns.loctraining.domain.model.material.Brand;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelCreateRequest {
    private String name;

    private Integer brandId;
}
