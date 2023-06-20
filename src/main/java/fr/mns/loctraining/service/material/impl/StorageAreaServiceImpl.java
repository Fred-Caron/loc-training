package fr.mns.loctraining.service.material.impl;

import fr.mns.loctraining.domain.model.material.StorageArea;
import fr.mns.loctraining.domain.repository.material.StorageAreaRepository;
import fr.mns.loctraining.dto.material.storageArea.StorageAreaCreateRequest;
import fr.mns.loctraining.dto.material.storageArea.StorageAreaDetails;
import fr.mns.loctraining.dto.material.storageArea.StorageAreaUpdateRequest;
import fr.mns.loctraining.service.material.StorageAreaService;
import fr.mns.loctraining.tools.exception.BadRequestException;
import fr.mns.loctraining.tools.exception.NotFoundException;
import fr.mns.loctraining.tools.utils.MappingUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StorageAreaServiceImpl implements StorageAreaService {
    private final StorageAreaRepository storageAreaRepository;

    @Override
    public StorageAreaDetails getDetails(Integer id) {
        StorageArea storageArea = storageAreaRepository.findByIdNullSafe(id);
        if (storageArea == null) {
            throw new NotFoundException();
        }
        return MappingUtils.getStorageAreaDetails(storageArea);
    }

    @Override
    public List<StorageAreaDetails> getList() {
        List<StorageArea> storageAreaList = storageAreaRepository.findAll();
        List<StorageAreaDetails> storageAreaDetailsList = new ArrayList<>();
        for (StorageArea storageArea : storageAreaList) {
            StorageAreaDetails details = MappingUtils.getStorageAreaDetails(storageArea);
            storageAreaDetailsList.add(details);
        }
        return storageAreaDetailsList;
    }

    @Override
    public StorageAreaDetails create(StorageAreaCreateRequest request) {
        if (!StringUtils.hasText(request.getName())) {
            throw new BadRequestException("Name should not be empty");
        }
        StorageArea storageArea = new StorageArea();
        storageArea.setName(request.getName());
        storageArea = storageAreaRepository.save(storageArea);
        return MappingUtils.getStorageAreaDetails(storageArea);
    }

    @Override
    public StorageAreaDetails update(Integer id, StorageAreaUpdateRequest request) {
        StorageArea storageArea = storageAreaRepository.findByIdNullSafe(id);
        if (storageArea == null) {
            throw new NotFoundException();
        }
        if (!StringUtils.hasText(request.getName())) {
            throw new BadRequestException("Name should not be empty");
        }
        storageArea.setName(request.getName());
        storageArea = storageAreaRepository.save(storageArea);
        return MappingUtils.getStorageAreaDetails(storageArea);
    }

    @Override
    public void delete(Integer id) {
        StorageArea storageArea = storageAreaRepository.findByIdNullSafe(id);
        if (storageArea == null) {
            throw new NotFoundException();
        }
        storageAreaRepository.delete(storageArea);
    }
}
