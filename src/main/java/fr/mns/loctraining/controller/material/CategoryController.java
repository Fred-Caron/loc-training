package fr.mns.loctraining.controller.material;

import fr.mns.loctraining.dto.material.category.CategoryCreateRequest;
import fr.mns.loctraining.dto.material.category.CategoryDetails;
import fr.mns.loctraining.dto.material.category.CategoryUpdateRequest;
import fr.mns.loctraining.service.material.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("{id}")
    public CategoryDetails getDetails(@PathVariable Integer id) {
        return categoryService.getDetails(id);
    }

    @GetMapping
    public List<CategoryDetails> getList() {
        return categoryService.getList();
    }

    @PutMapping
    public CategoryDetails create(@RequestBody CategoryCreateRequest request) {
        return categoryService.create(request);
    }

    @PostMapping("{id}")
    public CategoryDetails update(@PathVariable Integer id, @RequestBody CategoryUpdateRequest request) {
        return categoryService.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        categoryService.delete(id);
    }
}
