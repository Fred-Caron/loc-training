package fr.mns.loctraining.service.material.impl;

import fr.mns.loctraining.domain.repository.material.CategoryRepository;
import fr.mns.loctraining.service.material.CategoryService;
import fr.mns.loctraining.vo.material.category.CategoryCreateRequest;
import fr.mns.loctraining.vo.material.category.CategoryDetails;
import fr.mns.loctraining.vo.material.category.CategoryUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDetails getDetails(Integer id) {
        return null;
    }

    @Override
    public List<CategoryDetails> getList() {
        return null;
    }

    @Override
    public CategoryDetails create(CategoryCreateRequest request) {
        return null;
    }

    @Override
    public CategoryDetails update(Integer id, CategoryUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
