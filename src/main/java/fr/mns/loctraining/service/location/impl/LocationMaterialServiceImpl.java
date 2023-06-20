package fr.mns.loctraining.service.location.impl;

import fr.mns.loctraining.domain.model.location.Location;
import fr.mns.loctraining.domain.model.location.LocationMaterial;
import fr.mns.loctraining.domain.model.location.LocationMaterialKey;
import fr.mns.loctraining.domain.model.material.Material;
import fr.mns.loctraining.domain.repository.location.LocationMaterialRepository;
import fr.mns.loctraining.domain.repository.location.LocationRepository;
import fr.mns.loctraining.domain.repository.material.MaterialRepository;
import fr.mns.loctraining.service.location.LocationMaterialService;
import fr.mns.loctraining.service.material.MaterialService;
import fr.mns.loctraining.tools.exception.BadRequestException;
import fr.mns.loctraining.tools.exception.NotFoundException;
import fr.mns.loctraining.tools.utils.MappingUtils;
import fr.mns.loctraining.vo.material.material.MaterialDetails;
import fr.mns.loctraining.vo.material.material.MaterialSearchRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LocationMaterialServiceImpl implements LocationMaterialService {

    private final LocationRepository locationRepository;
    private final LocationMaterialRepository locationMaterialRepository;
    private final MaterialRepository materialRepository;
    private final MaterialService materialService;

    @Override
    public List<MaterialDetails> getMaterials(Integer locationId) {
        Location location = locationRepository.findByIdNullSafe(locationId);
        if (location == null) {
            throw new NotFoundException();
        }
        List<MaterialDetails> materials = new ArrayList<>();
        for (LocationMaterial material : location.getMaterials()) {
            materials.add(MappingUtils.getMaterialDetails(material.getMaterial()));
        }
        return materials;
    }

    @Override
    public List<MaterialDetails> getAvailableMaterials(Integer locationId, MaterialSearchRequest request) {
        // Trouver tous les materials qui ne sont pas déjà dans la location
        // Pour ça il faut ajouter la possibilité de filter sur la location ID
        return materialService.search(request);
    }

    @Override
    public void addMaterial(Integer locationId, Integer materialId) {
        Location location = locationRepository.findByIdNullSafe(locationId);
        if (location == null) {
            throw new NotFoundException();
        }
        Material material = materialRepository.findByIdNullSafe(materialId);
        if (material == null) {
            throw new NotFoundException();
        }
        LocationMaterialKey key = new LocationMaterialKey();
        key.setLocationId(locationId);
        key.setMaterialId(materialId);

        LocationMaterial locationMaterial = locationMaterialRepository.findById(key).orElse(null);
        if (locationMaterial != null) {
            throw new BadRequestException("Material already added to the location");
        }
        locationMaterial = new LocationMaterial();
        locationMaterial.setId(key);
        locationMaterialRepository.save(locationMaterial);
    }

    @Override
    public void removeMaterial(Integer locationId, Integer materialId) {
        // Pareil que addMaterial sauf qu'on doit supprimer si le lien existe
        Location location = locationRepository.findByIdNullSafe(locationId);
        if (location == null) {
            throw new NotFoundException();
        }
        Material material = materialRepository.findByIdNullSafe(materialId);
        if (material == null) {
            throw new NotFoundException();
        }
        LocationMaterialKey key = new LocationMaterialKey();
        key.setLocationId(locationId);
        key.setMaterialId(materialId);

        LocationMaterial locationMaterial = locationMaterialRepository.findById(key).orElse(null);
        if (locationMaterial == null) {
            throw new BadRequestException("Bond between material and rental doesn't exist");
        }

        locationMaterial = new LocationMaterial();
        locationMaterial.setId(key);
        locationMaterialRepository.delete(locationMaterial);
    }
}
