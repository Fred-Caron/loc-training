package fr.mns.loctraining.service.materialImpl;

import fr.mns.loctraining.domain.repository.material.StateRepository;
import fr.mns.loctraining.service.StateService;
import fr.mns.loctraining.vo.material.state.StateCreateRequest;
import fr.mns.loctraining.vo.material.state.StateDetails;
import fr.mns.loctraining.vo.material.state.StateUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StateServiceImpl implements StateService {
    private final StateRepository stateRepository;

    @Override
    public StateDetails getDetails(Integer id) {
        return null;
    }

    @Override
    public List<StateDetails> getList() {
        return null;
    }

    @Override
    public StateDetails create(StateCreateRequest request) {
        return null;
    }

    @Override
    public StateDetails update(Integer id, StateUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
