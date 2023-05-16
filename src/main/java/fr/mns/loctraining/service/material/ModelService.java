package fr.mns.loctraining.service.material;

import fr.mns.loctraining.vo.material.model.ModelCreateRequest;
import fr.mns.loctraining.vo.material.model.ModelDetails;
import fr.mns.loctraining.vo.material.model.ModelUpdateRequest;

import java.util.List;

public interface ModelService {
    ModelDetails getDetails(Integer id);

    List<ModelDetails> getList();

    ModelDetails create(ModelCreateRequest request);

    ModelDetails update(Integer id, ModelUpdateRequest request);

    void delete(Integer id);
}
