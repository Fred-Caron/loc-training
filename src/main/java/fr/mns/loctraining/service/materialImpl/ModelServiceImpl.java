package fr.mns.loctraining.service.materialImpl;

import fr.mns.loctraining.domain.repository.material.ModelRepository;
import fr.mns.loctraining.service.ModelService;
import fr.mns.loctraining.vo.material.model.ModelCreateRequest;
import fr.mns.loctraining.vo.material.model.ModelDetails;
import fr.mns.loctraining.vo.material.model.ModelUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    @Override
    public ModelDetails getDetails(Integer id) {
        return null;
    }

    @Override
    public List<ModelDetails> getList() {
        return null;
    }

    @Override
    public ModelDetails create(ModelCreateRequest request) {
        return null;
    }

    @Override
    public ModelDetails update(Integer id, ModelUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
