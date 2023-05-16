package fr.mns.loctraining.service.material.impl;

import fr.mns.loctraining.domain.repository.material.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelServiceImpl {
    private final ModelRepository modelRepository;
}
