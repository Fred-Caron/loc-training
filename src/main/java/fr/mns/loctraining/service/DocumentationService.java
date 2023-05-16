package fr.mns.loctraining.service;

import fr.mns.loctraining.vo.material.documentation.DocumentationCreateRequest;
import fr.mns.loctraining.vo.material.documentation.DocumentationDetails;
import fr.mns.loctraining.vo.material.documentation.DocumentationUpdateRequest;

import java.util.List;

public interface DocumentationService {
    DocumentationDetails getDetails(Integer id);

    List<DocumentationDetails> getList();

    DocumentationDetails create(DocumentationCreateRequest request);

    DocumentationDetails update(Integer id, DocumentationUpdateRequest request);

    void delete(Integer id);
}
