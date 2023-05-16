package fr.mns.loctraining.service.materialImpl;

import fr.mns.loctraining.domain.repository.material.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl {
    private final CategoryRepository categoryRepository;
}
