package fr.mns.loctraining.controller.material;

import fr.mns.loctraining.service.material.DocumentationService;
import fr.mns.loctraining.vo.material.documentation.DocumentationCreateRequest;
import fr.mns.loctraining.vo.material.documentation.DocumentationDetails;
import fr.mns.loctraining.vo.material.documentation.DocumentationUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "documentation")
@AllArgsConstructor
public class DocumentationController {

    private final DocumentationService documentationService;

    @GetMapping("{id}")
    public DocumentationDetails getDetails(@PathVariable Integer id) {
        return documentationService.getDetails(id);
    }

    @GetMapping
    public List<DocumentationDetails> getList() {
        return documentationService.getList();
    }

    @PutMapping
    public DocumentationDetails create(@RequestBody DocumentationCreateRequest request) {
        return documentationService.create(request);
    }

    @PostMapping("{id}")
    public DocumentationDetails update(@PathVariable Integer id, @RequestBody DocumentationUpdateRequest request) {
        return documentationService.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        documentationService.delete(id);
    }
}
