package fr.mns.loctraining.service.materialImpl;

import fr.mns.loctraining.domain.repository.material.MaterialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MaterielServiceImpl {
    private final MaterialRepository materialRepository;
}
