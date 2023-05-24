package fr.mns.loctraining.tools.utils;

import fr.mns.loctraining.domain.model.location.Location;
import fr.mns.loctraining.domain.model.material.*;
import fr.mns.loctraining.domain.model.user.Status;
import fr.mns.loctraining.domain.model.user.User;
import fr.mns.loctraining.vo.location.LocationDetails;
import fr.mns.loctraining.vo.material.brand.BrandDetails;
import fr.mns.loctraining.vo.material.category.CategoryDetails;
import fr.mns.loctraining.vo.material.documentation.DocumentationDetails;
import fr.mns.loctraining.vo.material.material.MaterialDetails;
import fr.mns.loctraining.vo.material.model.ModelDetails;
import fr.mns.loctraining.vo.material.state.StateDetails;
import fr.mns.loctraining.vo.material.storageArea.StorageAreaDetails;
import fr.mns.loctraining.vo.user.status.StatusDetails;
import fr.mns.loctraining.vo.user.user.UserDetails;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.TimeUnit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MappingUtils {

    // Méthode pour convertir le Status en StatusDetails (identique à celle dans StatusServiceImpl)
    public static StatusDetails getStatusDetails(Status status) {
        StatusDetails details = new StatusDetails();
        details.setId(status.getId());
        details.setName(status.getName());

        return details;
    }

    public static LocationDetails getLocationDetails(Location location) {
        LocationDetails details = new LocationDetails();
        details.setId(location.getId());
        details.setCreationDate(location.getCreationDate());
        details.setReason(location.getReason());
        details.setPrevisionnalStartingDate(location.getPrevisionnalStartingDate());
        details.setPrevisionnalEndDate(location.getPrevisionnalEndDate());
        details.setExtensionDate(location.getExtensionDate());
        details.setExtensionValidationDate(location.getExtensionValidationDate());
        details.setStatus(location.getStatus());
        details.setDecisionDate(location.getDecisionDate());
        details.setUser(getUserDetails(location.getUser()));
        if(location.getExtensionDate() != null){
            long diff = TimeUnit.DAYS.toDays(location.getExtensionDate().getTime()-location.getPrevisionnalEndDate().getTime());
            details.setExtensionDuration(Math.toIntExact(diff));
        }
        return details;
    }

    public static UserDetails getUserDetails(User user) {
        UserDetails details = new UserDetails();
        details.setId(user.getId());
        details.setFirstname(user.getFirstname());
        details.setLastname(user.getLastname());
        details.setEmail(user.getEmail());
        details.setLogin(user.getLogin());
        details.setGender(user.getGender());
        details.setAffiliation(user.getAffiliation());
        details.setPhone(user.getPhone());
        // On ajoute les infos du status sous forme de StatusDetails
        details.setStatus(getStatusDetails(user.getStatus()));
        return details;
    }
    public static ModelDetails getModelDetails(Model model) {
        ModelDetails details = new ModelDetails();
        details.setId(model.getId());
        details.setBrand(getBrandDetails(model.getBrand()));
        return details;
    }

    public static StateDetails getStateDetails(State state) {
        StateDetails details = new StateDetails();
        details.setId(state.getId());
        details.setName(state.getName());
        return details;
    }

    public static BrandDetails getBrandDetails(Brand brand){
        BrandDetails details = new BrandDetails();
        details.setId(brand.getId());
        details.setName(brand.getName());
        return details;
    }

    public static StorageAreaDetails getStorageAreaDetails(StorageArea storageArea){
        StorageAreaDetails details = new StorageAreaDetails();
        details.setId(storageArea.getId());
        details.setName(storageArea.getName());
        return details;
    }

    public static CategoryDetails getCategoryDetails(Category category){
        CategoryDetails details = new CategoryDetails();
        details.setId(category.getId());
        details.setName(category.getName());
        return details;
    }

    public static DocumentationDetails getDocumentationDetails(Documentation documentation){
        DocumentationDetails details = new DocumentationDetails();
        details.setId(documentation.getId());
        details.setDescription(documentation.getDescription());
        return details;
    }

    public static MaterialDetails getMaterialDetails(Material material){
        MaterialDetails details = new MaterialDetails();
        details.setId(material.getId());
        details.setCategory(getCategoryDetails(material.getCategory()));
        details.setModel(getModelDetails(material.getModel()));
        details.setDocumentation(getDocumentationDetails(material.getDocumentation()));
        details.setStorageArea(getStorageAreaDetails(material.getStorageArea()));
        details.setRegistrationNumber(material.getRegistrationNumber());
        return details;
    }
}
