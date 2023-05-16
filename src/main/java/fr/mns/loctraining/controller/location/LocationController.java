package fr.mns.loctraining.controller.location;

import fr.mns.loctraining.service.LocationService;
import fr.mns.loctraining.vo.location.LocationCreateRequest;
import fr.mns.loctraining.vo.location.LocationDetails;
import fr.mns.loctraining.vo.location.LocationUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "location")
@AllArgsConstructor
public class LocationController {
    private final LocationService locationService;
    @GetMapping("{id}")
    public LocationDetails getDetails(@PathVariable Integer id){
        return locationService.getDetails(id);
    }

    @GetMapping
    public List<LocationDetails> getList(){
        return locationService.getList();
    }

    @PutMapping
    public LocationDetails create (@RequestBody LocationCreateRequest request){
        return locationService.create(request);
    }

    @PostMapping("{id}")
    public LocationDetails update(@PathVariable Integer id, LocationUpdateRequest request){
        return locationService.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        locationService.delete(id);
    }
}

