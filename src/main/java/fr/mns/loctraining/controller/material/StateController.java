package fr.mns.loctraining.controller.material;

import fr.mns.loctraining.service.StateService;
import fr.mns.loctraining.vo.material.state.StateCreateRequest;
import fr.mns.loctraining.vo.material.state.StateDetails;
import fr.mns.loctraining.vo.material.state.StateUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "state")
@AllArgsConstructor
public class StateController {
    private final StateService stateService;

    @GetMapping("{id}")
    public StateDetails getDetail(@PathVariable Integer id){
        return stateService.getDetails(id);
    }

    @GetMapping
    public List<StateDetails> getList(){
        return stateService.getList();
    }

    @PutMapping
    public StateDetails create(@RequestBody StateCreateRequest request){
        return stateService.create(request);
    }

    @PostMapping("{id}")
    public StateDetails update(@PathVariable Integer id, @RequestBody StateUpdateRequest request){
        return stateService.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        stateService.delete(id);
    }
}
