package fr.mns.loctraining.controller.material;

import fr.mns.loctraining.service.material.BrandService;
import fr.mns.loctraining.vo.material.brand.BrandCreateRequest;
import fr.mns.loctraining.vo.material.brand.BrandDetails;
import fr.mns.loctraining.vo.material.brand.BrandUpdateRequest;
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
