package fr.mns.loctraining.service.material;

import fr.mns.loctraining.dto.material.state.StateCreateRequest;
import fr.mns.loctraining.dto.material.state.StateDetails;
import fr.mns.loctraining.dto.material.state.StateUpdateRequest;

import java.util.List;

public interface StateService {
    StateDetails getDetails(Integer id);

    List<StateDetails> getList();

    StateDetails create(StateCreateRequest request);

    StateDetails update(Integer id, StateUpdateRequest request);

    void delete(Integer id);
}
