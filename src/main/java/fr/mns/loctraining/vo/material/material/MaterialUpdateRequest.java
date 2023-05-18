package fr.mns.loctraining.vo.material.material;

import fr.mns.loctraining.domain.model.material.Category;
import fr.mns.loctraining.domain.model.material.Documentation;
import fr.mns.loctraining.domain.model.material.Model;
import fr.mns.loctraining.domain.model.material.StorageArea;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialUpdateRequest {
    private Integer registrationNumber;

    private Integer modelId;

    private Integer categoryId;

    private Integer storageAreaId;

    private Integer documentationId;

}
