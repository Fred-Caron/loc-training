package fr.mns.loctraining.dto.material.material;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialSearchRequest {
    private String search;
    private Integer categoryId;

    private Integer storageAreaId;


}
