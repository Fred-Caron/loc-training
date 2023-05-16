package fr.mns.loctraining.service;

import fr.mns.loctraining.vo.material.material.MaterialCreateRequest;
import fr.mns.loctraining.vo.material.material.MaterialDetails;
import fr.mns.loctraining.vo.material.material.MaterialUpdateRequest;

import java.util.List;

public interface MaterialService {
    MaterialDetails getDetails(Integer id);

    List<MaterialDetails> getList();

    MaterialDetails create(MaterialCreateRequest request);

    MaterialDetails update(Integer id, MaterialUpdateRequest request);

    void delete(Integer id);
}
