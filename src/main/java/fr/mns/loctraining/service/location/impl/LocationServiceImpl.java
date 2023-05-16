package fr.mns.loctraining.service.locationImpl;

import fr.mns.loctraining.domain.repository.location.LocationRepository;

import fr.mns.loctraining.service.location.LocationService;
import fr.mns.loctraining.vo.location.LocationCreateRequest;
import fr.mns.loctraining.vo.location.LocationDetails;
import fr.mns.loctraining.vo.location.LocationUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service@AllArgsConstructor
public class LocationServiceImpl implements LocationService {
    private LocationRepository locationRepository;

    @Override
    public LocationDetails getDetails(Integer id) {
        return null;
    }

    @Override
    public List<LocationDetails> getList() {
        return null;
    }

    @Override
    public LocationDetails create(LocationCreateRequest request) {
        return null;
    }

    @Override
    public LocationDetails update(Integer id, LocationUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
