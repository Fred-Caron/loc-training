package fr.mns.loctraining.domain.repository.material;

import fr.mns.loctraining.domain.model.material.MaterialState;
import fr.mns.loctraining.domain.model.material.MaterialStateKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialStateRepository  extends JpaRepository<MaterialState, MaterialStateKey> {
}
