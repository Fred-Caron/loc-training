package fr.mns.loctraining.domain.model.material;

import fr.mns.loctraining.domain.model.common.BaseEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Material extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int registrationNumberMaterial;
}
