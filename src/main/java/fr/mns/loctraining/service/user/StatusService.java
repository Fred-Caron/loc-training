package fr.mns.loctraining.service.user;

import fr.mns.loctraining.dto.user.status.StatusCreateRequest;
import fr.mns.loctraining.dto.user.status.StatusDetails;
import fr.mns.loctraining.dto.user.status.StatusUpdateRequest;

import java.util.List;

public interface StatusService {

    StatusDetails getDetails(Integer id);

    List<StatusDetails> getList();

    StatusDetails create(StatusCreateRequest request);

    StatusDetails update(Integer id, StatusUpdateRequest request);

    void delete(Integer id);
}
