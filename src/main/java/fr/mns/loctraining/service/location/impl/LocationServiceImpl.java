package fr.mns.loctraining.service.location.impl;

import fr.mns.loctraining.domain.repository.location.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocationServiceImpl {
    private LocationRepository locationRepository;

}
