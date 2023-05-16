package fr.mns.loctraining.service.materialImpl;

import fr.mns.loctraining.domain.repository.material.StateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StateServiceImpl {
    private final StateRepository stateRepository;
}
