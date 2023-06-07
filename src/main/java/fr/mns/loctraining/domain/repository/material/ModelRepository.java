package fr.mns.loctraining.domain.repository.material;

import fr.mns.loctraining.domain.model.material.Model;
import fr.mns.loctraining.domain.repository.common.NamedRepository;

import java.util.List;

public interface ModelRepository extends NamedRepository<Model> {

    List<Model> findByBrandId(Integer id);
}
