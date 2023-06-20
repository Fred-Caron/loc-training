package fr.mns.loctraining.domain.repository.location;

import fr.mns.loctraining.domain.model.location.Location;
import fr.mns.loctraining.dto.location.LocationSearchRequest;

import java.util.List;

public interface LocationCustomRepository {
    List<Location> search(LocationSearchRequest request);
}
