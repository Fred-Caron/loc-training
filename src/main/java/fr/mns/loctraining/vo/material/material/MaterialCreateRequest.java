package fr.mns.loctraining.vo.material.material;

import fr.mns.loctraining.domain.model.material.Category;
import fr.mns.loctraining.domain.model.material.Documentation;
import fr.mns.loctraining.domain.model.material.Model;
import fr.mns.loctraining.domain.model.material.StorageArea;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialCreateRequest {
    private Integer registrationNumber;

    private Integer modelId;

    private Integer categoryId;

    private Integer storageAreaId;

    private Integer documentationId;

}
