package fr.mns.loctraining.controller.material;

import fr.mns.loctraining.dto.material.storageArea.StorageAreaCreateRequest;
import fr.mns.loctraining.dto.material.storageArea.StorageAreaDetails;
import fr.mns.loctraining.dto.material.storageArea.StorageAreaUpdateRequest;
import fr.mns.loctraining.service.material.StorageAreaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "storageArea")
@AllArgsConstructor
public class StorageAreaController {
    private final StorageAreaService storageAreaService;

    @GetMapping("{id}")
    public StorageAreaDetails getDetails(@PathVariable Integer id) {
        return storageAreaService.getDetails(id);
    }

    @GetMapping
    public List<StorageAreaDetails> getList() {
        return storageAreaService.getList();
    }

    @PutMapping
    public StorageAreaDetails create(@RequestBody StorageAreaCreateRequest request) {
        return storageAreaService.create(request);
    }

    @PostMapping("{id}")
    public StorageAreaDetails update(@PathVariable Integer id, @RequestBody StorageAreaUpdateRequest request) {
        return storageAreaService.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        storageAreaService.delete(id);
    }
}
