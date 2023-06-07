package fr.mns.loctraining.service.material.impl;

import fr.mns.loctraining.domain.model.material.Brand;
import fr.mns.loctraining.domain.model.material.Model;
import fr.mns.loctraining.domain.repository.material.BrandRepository;
import fr.mns.loctraining.domain.repository.material.ModelRepository;
import fr.mns.loctraining.service.material.ModelService;
import fr.mns.loctraining.tools.exception.BadRequestException;
import fr.mns.loctraining.tools.exception.NotFoundException;
import fr.mns.loctraining.tools.utils.MappingUtils;
import fr.mns.loctraining.vo.material.model.ModelCreateRequest;
import fr.mns.loctraining.vo.material.model.ModelDetails;
import fr.mns.loctraining.vo.material.model.ModelUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    private final BrandRepository brandRepository;

    @Override
    public ModelDetails getDetails(Integer id) {
        Model model = modelRepository.findByIdNullSafe(id);
        if (model == null) {
            throw new NotFoundException();
        }
        return MappingUtils.getModelDetails(model);
    }

    @Override
    public List<ModelDetails> getList(Integer brandId) {
        List<Model> modelList = modelRepository.findByBrandId(brandId);
        List<ModelDetails> modelDetailsList = new ArrayList<>();
        for (Model model : modelList) {
            ModelDetails details = MappingUtils.getModelDetails(model);
            modelDetailsList.add(details);
        }
        return modelDetailsList;
    }

    // ici ça ne veut pas prendre request.getName() tout seul alors que ça extends de NamedEntity
    @Override
    public ModelDetails create(ModelCreateRequest request) {
        if (!StringUtils.hasText(request.getName())) {
            throw new BadRequestException("Name should not be empty");
        }

        Brand brand = getBrand(request.getBrandId());

        Model model = new Model();
        model.setName(request.getName());
        model.setBrand(brand);
        model = modelRepository.save(model);
        return MappingUtils.getModelDetails(model);
    }

    @Override
    public ModelDetails update(Integer id, ModelUpdateRequest request) {
        Model model = modelRepository.findByIdNullSafe(id);
        if (model == null) {
            throw new NotFoundException();
        }
        if (!StringUtils.hasText(request.getName())) {
            throw new BadRequestException("Name should not be empty");
        }
        model.setName(request.getName());
        model = modelRepository.save(model);
        return MappingUtils.getModelDetails(model);
    }

    @Override
    public void delete(Integer id) {
        Model model = modelRepository.findByIdNullSafe(id);
        if (model == null) {
            throw new NotFoundException();
        }
        modelRepository.delete(model);
    }

    private Model getModel(Integer brandId) {
        Model model = modelRepository.findByIdNullSafe(brandId);
        if (model == null) {
            throw new BadRequestException("Incorrect brand");
        }
        return model;
    }

    private Brand getBrand(Integer brandId) {
        return brandRepository.findByIdWithException(brandId, "brand");
    }
}
