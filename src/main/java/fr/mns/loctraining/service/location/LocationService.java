package fr.mns.loctraining.service.location;

import fr.mns.loctraining.dto.location.LocationCreateRequest;
import fr.mns.loctraining.dto.location.LocationDetails;
import fr.mns.loctraining.dto.location.LocationSearchRequest;
import fr.mns.loctraining.dto.location.LocationUpdateRequest;

import java.util.List;

public interface LocationService {

    LocationDetails getDetails(Integer id);

    List<LocationDetails> getList();

    LocationDetails create(LocationCreateRequest request);

    LocationDetails update(Integer id, LocationUpdateRequest request);

    void delete(Integer id);

    LocationDetails userValidation(Integer id);

    LocationDetails adminValidation(Integer id);

    LocationDetails adminRejection(Integer id);

    List<LocationDetails> search(LocationSearchRequest request);

    List<LocationDetails> searchToBeValidated(LocationSearchRequest request);

    List<LocationDetails> searchUserRental(Integer userId, LocationSearchRequest request);
}
