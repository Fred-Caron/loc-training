package fr.mns.loctraining.controller.material;

import fr.mns.loctraining.service.material.MaterialService;
import fr.mns.loctraining.vo.material.material.MaterialCreateRequest;
import fr.mns.loctraining.vo.material.material.MaterialDetails;
import fr.mns.loctraining.vo.material.material.MaterialUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "material")
@AllArgsConstructor
public class MaterialController {

    private final MaterialService materialService;

    @GetMapping("{id}")
    public MaterialDetails getDetails(@PathVariable Integer id) {
        return materialService.getDetails(id);
    }

    @GetMapping
    public List<MaterialDetails> getList() {
        return materialService.getList();
    }

    @PutMapping
    public MaterialDetails create(@RequestBody MaterialCreateRequest request) {
        return materialService.create(request);
    }

    @PostMapping("{id}")
    public MaterialDetails update(@PathVariable Integer id, @RequestBody MaterialUpdateRequest request) {
        return materialService.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        materialService.delete(id);
    }
}
