package fr.mns.loctraining.service;

import fr.mns.loctraining.vo.material.category.CategoryCreateRequest;
import fr.mns.loctraining.vo.material.category.CategoryDetails;
import fr.mns.loctraining.vo.material.category.CategoryUpdateRequest;

import java.util.List;

public interface CategoryService {
    CategoryDetails getDetails(Integer id);

    List<CategoryDetails> getList();

    CategoryDetails create(CategoryCreateRequest request);

    CategoryDetails update(Integer id, CategoryUpdateRequest request);

    void delete(Integer id);
}
