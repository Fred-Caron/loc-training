package fr.mns.loctraining.service.materialImpl;

import fr.mns.loctraining.domain.repository.material.DocumentationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DocumentationServiceImpl {
    private final DocumentationRepository documentationRepository;
}
