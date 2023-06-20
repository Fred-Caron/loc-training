package fr.mns.loctraining.service.material;

import fr.mns.loctraining.dto.material.brand.BrandCreateRequest;
import fr.mns.loctraining.dto.material.brand.BrandDetails;
import fr.mns.loctraining.dto.material.brand.BrandUpdateRequest;

import java.util.List;

public interface BrandService {
    BrandDetails getDetails(Integer id);

    List<BrandDetails> getList();

    BrandDetails create(BrandCreateRequest request);

    BrandDetails update(Integer id, BrandUpdateRequest request);

    void delete(Integer id);
}
