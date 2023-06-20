package fr.mns.loctraining.controller.location;

import fr.mns.loctraining.dto.location.LocationCreateRequest;
import fr.mns.loctraining.dto.location.LocationDetails;
import fr.mns.loctraining.dto.location.LocationSearchRequest;
import fr.mns.loctraining.dto.location.LocationUpdateRequest;
import fr.mns.loctraining.service.location.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "rental")
@AllArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @GetMapping("{id}")
    public LocationDetails getDetails(@PathVariable Integer id) {
        return locationService.getDetails(id);
    }

    @GetMapping
    public List<LocationDetails> getList() {
        return locationService.getList();
    }

    @PutMapping
    public LocationDetails create(@RequestBody LocationCreateRequest request) {
        return locationService.create(request);
    }

    @PostMapping("{id}")
    public LocationDetails update(@PathVariable Integer id, LocationUpdateRequest request) {
        return locationService.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        locationService.delete(id);
    }

    @GetMapping("{id}/user/validate")
    public LocationDetails userValidation(@PathVariable Integer id) {
        return locationService.userValidation(id);
    }

    @GetMapping("{id}/admin/validate")
    public LocationDetails adminValidation(@PathVariable Integer id) {
        return locationService.adminValidation(id);
    }

    @GetMapping("{id}/admin/rejecte")
    public LocationDetails adminRejection(@PathVariable Integer id) {
        return locationService.adminRejection(id);
    }

    @PostMapping
    public List<LocationDetails> search(@RequestBody LocationSearchRequest request) {
        return locationService.search(request);
    }

    @PostMapping("/search/toBeValidated")
    public List<LocationDetails> searchToBeValidated(@RequestBody LocationSearchRequest request) {
        return locationService.searchToBeValidated(request);
    }

    @PostMapping("/search/byUser/{id}")
    public List<LocationDetails> searchUserRental(@PathVariable Integer userId, @RequestBody LocationSearchRequest request) {
        return locationService.searchUserRental(userId, request);
    }
}

