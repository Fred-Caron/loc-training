package fr.mns.loctraining.vo.material.material;

import fr.mns.loctraining.domain.model.material.Category;
import fr.mns.loctraining.domain.model.material.Documentation;
import fr.mns.loctraining.domain.model.material.Model;
import fr.mns.loctraining.domain.model.material.StorageArea;
import fr.mns.loctraining.vo.material.brand.BrandDetails;
import fr.mns.loctraining.vo.material.category.CategoryDetails;
import fr.mns.loctraining.vo.material.documentation.DocumentationDetails;
import fr.mns.loctraining.vo.material.model.ModelDetails;
import fr.mns.loctraining.vo.material.storageArea.StorageAreaDetails;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialDetails {
    private int id;
    private int registrationNumber;

    private ModelDetails model;

    private CategoryDetails category;

    private StorageAreaDetails storageArea;

    private DocumentationDetails documentation;


}
