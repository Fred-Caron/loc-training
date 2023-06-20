package fr.mns.loctraining.service.material.impl;

import fr.mns.loctraining.domain.model.material.Documentation;
import fr.mns.loctraining.domain.repository.material.DocumentationRepository;
import fr.mns.loctraining.dto.material.documentation.DocumentationCreateRequest;
import fr.mns.loctraining.dto.material.documentation.DocumentationDetails;
import fr.mns.loctraining.dto.material.documentation.DocumentationUpdateRequest;
import fr.mns.loctraining.service.material.DocumentationService;
import fr.mns.loctraining.tools.exception.BadRequestException;
import fr.mns.loctraining.tools.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DocumentationServiceImpl implements DocumentationService {
    private final DocumentationRepository documentationRepository;

    @Override
    public DocumentationDetails getDetails(Integer id) {
        Documentation documentation = documentationRepository.findByIdNullSafe(id);
        if (documentation == null) {
            throw new NotFoundException();
        }
        return getDetails(documentation);
    }

    @Override
    public List<DocumentationDetails> getList() {
        List<Documentation> documentationList = documentationRepository.findAll();
        List<DocumentationDetails> documentationDetailsList = new ArrayList<>();
        for (Documentation documentation : documentationList) {
            DocumentationDetails details = getDetails(documentation);
            documentationDetailsList.add(details);
        }
        return documentationDetailsList;
    }

    @Override
    public DocumentationDetails create(DocumentationCreateRequest request) {
        if (!StringUtils.hasText(request.getDescription())) {
            throw new BadRequestException("Description should not be empty");
        }
        Documentation documentation = new Documentation();
        documentation.setDescription(request.getDescription());
        documentation = documentationRepository.save(documentation);
        return getDetails(documentation);
    }

    @Override
    public DocumentationDetails update(Integer id, DocumentationUpdateRequest request) {
        Documentation documentation = documentationRepository.findByIdNullSafe(id);
        if (documentation == null) {
            throw new NotFoundException();
        }
        if (!StringUtils.hasText(request.getDescription())) {
            throw new BadRequestException("Documentation should not be empty");
        }
        documentation.setDescription(request.getDescription());
        documentation = documentationRepository.save(documentation);
        return getDetails(documentation);
    }

    @Override
    public void delete(Integer id) {
        Documentation documentation = documentationRepository.findByIdNullSafe(id);
        if (documentation == null) {
            throw new NotFoundException();
        }
        documentationRepository.delete(documentation);
    }

    private DocumentationDetails getDetails(Documentation documentation) {
        DocumentationDetails details = new DocumentationDetails();
        details.setId(documentation.getId());
        details.setDescription(documentation.getDescription());
        return details;
    }
}
