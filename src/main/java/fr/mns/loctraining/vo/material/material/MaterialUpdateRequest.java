package fr.mns.loctraining.vo.material.material;

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
