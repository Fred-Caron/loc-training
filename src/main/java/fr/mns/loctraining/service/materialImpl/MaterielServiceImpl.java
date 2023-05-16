package fr.mns.loctraining.service.materialImpl;

import fr.mns.loctraining.domain.repository.material.MaterialRepository;
import fr.mns.loctraining.service.MaterialService;
import fr.mns.loctraining.vo.material.material.MaterialCreateRequest;
import fr.mns.loctraining.vo.material.material.MaterialDetails;
import fr.mns.loctraining.vo.material.material.MaterialUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MaterielServiceImpl implements MaterialService {
    private final MaterialRepository materialRepository;

    @Override
    public MaterialDetails getDetails(Integer id) {
        return null;
    }

    @Override
    public List<MaterialDetails> getList() {
        return null;
    }

    @Override
    public MaterialDetails create(MaterialCreateRequest request) {
        return null;
    }

    @Override
    public MaterialDetails update(Integer id, MaterialUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
