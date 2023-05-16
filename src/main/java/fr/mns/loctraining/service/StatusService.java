package fr.mns.loctraining.service;

import fr.mns.loctraining.vo.user.status.StatusCreateRequest;
import fr.mns.loctraining.vo.user.status.StatusDetails;
import fr.mns.loctraining.vo.user.status.StatusUpdateRequest;

import java.util.List;

public interface StatusService {

    StatusDetails getDetails(Integer id);

    List<StatusDetails> getList();

    StatusDetails create(StatusCreateRequest request);

    StatusDetails update(Integer id, StatusUpdateRequest request);

    void delete(Integer id);
}
