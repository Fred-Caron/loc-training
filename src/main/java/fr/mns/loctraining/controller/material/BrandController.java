package fr.mns.loctraining.controller.material;

import fr.mns.loctraining.dto.material.brand.BrandCreateRequest;
import fr.mns.loctraining.dto.material.brand.BrandDetails;
import fr.mns.loctraining.dto.material.brand.BrandUpdateRequest;
import fr.mns.loctraining.service.material.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "brand")
@AllArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping("{id}")
    public BrandDetails getDetails(@PathVariable Integer id) {
        return brandService.getDetails(id);
    }

    @GetMapping
    public List<BrandDetails> getList() {
        return brandService.getList();
    }

    @PutMapping
    public BrandDetails create(@RequestBody BrandCreateRequest request) {
        return brandService.create(request);
    }

    @PostMapping("{id}")
    public BrandDetails update(@PathVariable Integer id, @RequestBody BrandUpdateRequest request) {
        return brandService.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        brandService.delete(id);
    }
}
