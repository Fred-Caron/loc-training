package fr.mns.loctraining.service.material.impl;

import fr.mns.loctraining.domain.repository.material.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandServiceImpl {
    private final BrandRepository brandRepository;
}
