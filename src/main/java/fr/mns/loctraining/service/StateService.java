package fr.mns.loctraining.service;

import fr.mns.loctraining.vo.material.state.StateCreateRequest;
import fr.mns.loctraining.vo.material.state.StateDetails;
import fr.mns.loctraining.vo.material.state.StateUpdateRequest;
import fr.mns.loctraining.vo.user.status.StatusCreateRequest;
import fr.mns.loctraining.vo.user.status.StatusDetails;
import fr.mns.loctraining.vo.user.status.StatusUpdateRequest;

import java.util.List;

public interface StateService {
    StateDetails getDetails(Integer id);

    List<StateDetails> getList();

    StateDetails create(StateCreateRequest request);

    StateDetails update(Integer id, StateUpdateRequest request);

    void delete(Integer id);
}
