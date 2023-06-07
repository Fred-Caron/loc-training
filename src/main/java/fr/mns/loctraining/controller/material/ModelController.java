package fr.mns.loctraining.controller.material;

import fr.mns.loctraining.service.material.ModelService;
import fr.mns.loctraining.vo.material.model.ModelCreateRequest;
import fr.mns.loctraining.vo.material.model.ModelDetails;
import fr.mns.loctraining.vo.material.model.ModelUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "model")
@AllArgsConstructor
public class ModelController {
    private final ModelService modelService;

    @GetMapping("{id}")
    public ModelDetails getDetails(@PathVariable Integer id) {
        return modelService.getDetails(id);
    }

    @GetMapping
    public List<ModelDetails> getList(@RequestParam Integer brandId) {
        return modelService.getList(brandId);
    }

    @PutMapping
    public ModelDetails create(@RequestBody ModelCreateRequest request) {
        return modelService.create(request);
    }

    @PostMapping("{id}")
    public ModelDetails update(@PathVariable Integer id, @RequestBody ModelUpdateRequest request) {
        return modelService.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        modelService.delete(id);
    }

}
