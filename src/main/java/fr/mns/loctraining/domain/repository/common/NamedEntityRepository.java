package fr.mns.loctraining.domain.repository.common;

import fr.mns.loctraining.domain.model.common.NamedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NamedEntityRepository<T extends NamedEntity> extends JpaRepository<T, Long> {
    NamedEntity findFirstByName(String name);
}
