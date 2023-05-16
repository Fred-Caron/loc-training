package fr.mns.loctraining.service;

import fr.mns.loctraining.vo.material.storageArea.StorageAreaCreateRequest;
import fr.mns.loctraining.vo.material.storageArea.StorageAreaDetails;
import fr.mns.loctraining.vo.material.storageArea.StorageAreaUpdateRequest;
import fr.mns.loctraining.vo.user.status.StatusCreateRequest;
import fr.mns.loctraining.vo.user.status.StatusDetails;
import fr.mns.loctraining.vo.user.status.StatusUpdateRequest;

import java.util.List;

public interface StorageAreaService {
    StorageAreaDetails getDetails(Integer id);

    List<StorageAreaDetails> getList();

    StorageAreaDetails create(StorageAreaCreateRequest request);

    StorageAreaDetails update(Integer id, StorageAreaUpdateRequest request);

    void delete(Integer id);
}
