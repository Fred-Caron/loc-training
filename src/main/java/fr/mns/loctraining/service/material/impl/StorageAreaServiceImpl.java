package fr.mns.loctraining.service.material.impl;

import fr.mns.loctraining.domain.repository.material.StorageAreaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StorageAreaServiceImpl {
    private final StorageAreaRepository storageAreaRepository;
}
