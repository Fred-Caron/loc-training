package fr.mns.loctraining.domain.repository.material;

import fr.mns.loctraining.domain.model.material.Material;
import fr.mns.loctraining.vo.material.material.MaterialSearchRequest;

import java.util.List;

public interface MaterialCustomRepository {
    List<Material> search(MaterialSearchRequest request);
}
