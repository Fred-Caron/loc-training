package fr.mns.loctraining.service.materialImpl;

import fr.mns.loctraining.domain.repository.material.StorageAreaRepository;
import fr.mns.loctraining.service.StorageAreaService;
import fr.mns.loctraining.vo.material.storageArea.StorageAreaCreateRequest;
import fr.mns.loctraining.vo.material.storageArea.StorageAreaDetails;
import fr.mns.loctraining.vo.material.storageArea.StorageAreaUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StorageAreaServiceImpl implements StorageAreaService {
    private final StorageAreaRepository storageAreaRepository;

    @Override
    public StorageAreaDetails getDetails(Integer id) {
        return null;
    }

    @Override
    public List<StorageAreaDetails> getList() {
        return null;
    }

    @Override
    public StorageAreaDetails create(StorageAreaCreateRequest request) {
        return null;
    }

    @Override
    public StorageAreaDetails update(Integer id, StorageAreaUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
