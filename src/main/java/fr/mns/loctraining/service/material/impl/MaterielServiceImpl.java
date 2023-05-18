package fr.mns.loctraining.service.material.impl;

import fr.mns.loctraining.domain.model.common.BaseEntity;
import fr.mns.loctraining.domain.model.material.*;
import fr.mns.loctraining.domain.repository.common.BaseRepository;
import fr.mns.loctraining.domain.repository.material.*;

import fr.mns.loctraining.service.material.CategoryService;
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

import javax.print.Doc;
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
        if(material == null){
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
        if(request.getRegistrationNumber() == null){
            throw new BadRequestException("Registration number should not be empty");
        }
        Category category = getCategory(request.getCategoryId());
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
        if(request.getRegistrationNumber() == null){
            throw new BadRequestException("Registration number should not be empty");
        }
        Category category = getCategory(request.getCategoryId());
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
        if(material == null){
            throw new NotFoundException();
        }
        materialRepository.delete(material);
    }

    private StorageArea getStorageArea(Integer storageAreaId){
        return storageAreaRepository.findByIdWithException(storageAreaId, "storage area");
    }

    private Model getModel(Integer modelId){
        return modelRepository.findByIdWithException(modelId, "model");
    }
    private Category getCategory(Integer categoryId){
        return categoryRepository.findByIdWithException(categoryId, "category");
    }

    private Documentation getDocumentation(Integer documentationId){
        return documentationRepository.findByIdWithException(documentationId, "documentation");
    }



}
