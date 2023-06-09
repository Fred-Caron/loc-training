package fr.mns.loctraining.domain.repository.material;

import fr.mns.loctraining.domain.model.material.Material;
import fr.mns.loctraining.domain.repository.common.BaseRepository;

public interface MaterialRepository extends BaseRepository<Material>, MaterialCustomRepository {
}
