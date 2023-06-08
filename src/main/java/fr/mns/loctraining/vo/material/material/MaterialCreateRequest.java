package fr.mns.loctraining.vo.material.material;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialCreateRequest {

    private Integer registrationNumber;

    private String newBrand;

    private Integer modelId;
    private String newModel;

    private Integer categoryId;
    private String newCategory;

    private Integer storageAreaId;
    private String newStorageArea;

    private Integer documentationId;
    private String newDocumentation;

}
