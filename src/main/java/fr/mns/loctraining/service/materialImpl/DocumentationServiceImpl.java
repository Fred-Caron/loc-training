package fr.mns.loctraining.service.materialImpl;

import fr.mns.loctraining.domain.repository.material.DocumentationRepository;
import fr.mns.loctraining.service.DocumentationService;
import fr.mns.loctraining.vo.material.documentation.DocumentationCreateRequest;
import fr.mns.loctraining.vo.material.documentation.DocumentationDetails;
import fr.mns.loctraining.vo.material.documentation.DocumentationUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DocumentationServiceImpl implements DocumentationService {
    private final DocumentationRepository documentationRepository;

    @Override
    public DocumentationDetails getDetails(Integer id) {
        return null;
    }

    @Override
    public List<DocumentationDetails> getList() {
        return null;
    }

    @Override
    public DocumentationDetails create(DocumentationCreateRequest request) {
        return null;
    }

    @Override
    public DocumentationDetails update(Integer id, DocumentationUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
