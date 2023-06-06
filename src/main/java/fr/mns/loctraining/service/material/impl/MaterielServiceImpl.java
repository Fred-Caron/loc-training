package fr.mns.loctraining.service.material.impl;

import fr.mns.loctraining.domain.model.material.Category;
import fr.mns.loctraining.domain.model.material.Documentation;
import fr.mns.loctraining.domain.model.material.Material;
import fr.mns.loctraining.domain.model.material.Model;
import fr.mns.loctraining.domain.model.material.StorageArea;
import fr.mns.loctraining.domain.repository.material.BrandRepository;
import fr.mns.loctraining.domain.repository.material.CategoryRepository;
import fr.mns.loctraining.domain.repository.material.DocumentationRepository;
import fr.mns.loctraining.domain.repository.material.MaterialRepository;
import fr.mns.loctraining.domain.repository.material.ModelRepository;
import fr.mns.loctraining.domain.repository.material.StorageAreaRepository;
import fr.mns.loctraining.service.material.MaterialService;
import fr.mns.loctraining.tools.exception.BadRequestException;
import fr.mns.loctraining.tools.exception.NotFoundException;
import fr.mns.loctraining.tools.utils.MappingUtils;
import fr.mns.loctraining.vo.material.material.MaterialCreateRequest;
import fr.mns.loctraining.vo.material.material.MaterialDetails;
import fr.mns.loctraining.vo.material.material.MaterialUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MaterielServiceImpl implements MaterialService {
    private final MaterialRepository materialRepository;
    private final ModelRepository modelRepository;
    private final CategoryRepository categoryRepository;
    private final DocumentationRepository documentationRepository;
    private final BrandRepository brandRepository;
    private final StorageAreaRepository storageAreaRepository;

    @Override
    public MaterialDetails getDetails(Integer id) {
        Material material = materialRepository.findByIdNullSafe(id);
        if (material == null) {
            throw new NotFoundException();
        }
        return MappingUtils.getMaterialDetails(material);
    }

    @Override
    public List<MaterialDetails> getList() {
        List<Material> materialList = materialRepository.findAll();
        List<MaterialDetails> materialDetailsList = new ArrayList<>();
        for (Material material : materialList) {
            MaterialDetails details = MappingUtils.getMaterialDetails(material);
            materialDetailsList.add(details);
        }
        return materialDetailsList;
    }

    @Override
    public MaterialDetails create(MaterialCreateRequest request) {
        if (request.getRegistrationNumber() == null) {
            throw new BadRequestException("Registration number should not be empty");
        }
        Category category = getCategory(request.getCategoryId(), request.getCategory());
        Documentation documentation = getDocumentation(request.getDocumentationId());
        Model model = getModel(request.getModelId());
        StorageArea storageArea = getStorageArea(request.getStorageAreaId());

        Material material = new Material();
        material.setRegistrationNumber(request.getRegistrationNumber());
        material.setCategory(category);
        material.setDocumentation(documentation);
        material.setModel(model);
        material.setStorageArea(storageArea);
        material = materialRepository.save(material);
        return MappingUtils.getMaterialDetails(material);
    }

    @Override
    public MaterialDetails update(Integer id, MaterialUpdateRequest request) {
        Material material = materialRepository.findByIdNullSafe(id);
        if (request.getRegistrationNumber() == null) {
            throw new BadRequestException("Registration number should not be empty");
        }
        Category category = getCategory(request.getCategoryId(), null);
        Documentation documentation = getDocumentation(request.getDocumentationId());
        Model model = getModel(request.getModelId());
        StorageArea storageArea = getStorageArea(request.getStorageAreaId());

        material.setCategory(category);
        material.setDocumentation(documentation);
        material.setRegistrationNumber(request.getRegistrationNumber());
        material.setModel(model);
        material.setStorageArea(storageArea);
        material = materialRepository.save(material);
        return MappingUtils.getMaterialDetails(material);
    }

    @Override
    public void delete(Integer id) {
        Material material = materialRepository.findByIdNullSafe(id);
        if (material == null) {
            throw new NotFoundException();
        }
        materialRepository.delete(material);
    }

    private StorageArea getStorageArea(Integer storageAreaId) {
        return storageAreaRepository.findByIdWithException(storageAreaId, "storage area");
    }

    private Model getModel(Integer modelId) {
        return modelRepository.findByIdWithException(modelId, "model");
    }

    private Category getCategory(Integer categoryId, String category) {
        if (categoryId != null) {
            return categoryRepository.findByIdWithException(categoryId, "category");
        }

        if (!StringUtils.hasText(category)) {
            throw new BadRequestException("Category cannot be null");
        }

        Category newCategory = new Category();
        newCategory.setName(category);

        return categoryRepository.save(newCategory);
    }

    private Documentation getDocumentation(Integer documentationId) {
        return documentationRepository.findByIdWithException(documentationId, "documentation");
    }

}
