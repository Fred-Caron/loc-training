package fr.mns.loctraining.service.material;

import fr.mns.loctraining.domain.repository.material.BrandRepository;
import fr.mns.loctraining.domain.repository.material.CategoryRepository;
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
