package fr.mns.loctraining.domain.repository.common;

import fr.mns.loctraining.domain.model.common.NamedEntity;

public interface NamedRepository<T extends NamedEntity> extends BaseRepository<T> {
    T findFirstByName(String name);

}
