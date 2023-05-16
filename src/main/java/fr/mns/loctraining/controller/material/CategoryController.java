package fr.mns.loctraining.controller.material;

import fr.mns.loctraining.service.material.CategoryService;
import fr.mns.loctraining.vo.material.category.CategoryCreateRequest;
import fr.mns.loctraining.vo.material.category.CategoryDetails;
import fr.mns.loctraining.vo.material.category.CategoryUpdateRequest;
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
