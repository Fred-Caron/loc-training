package fr.mns.loctraining.tools.utils;

import fr.mns.loctraining.domain.model.location.Location;
import fr.mns.loctraining.domain.model.material.State;
import fr.mns.loctraining.domain.model.user.Status;
import fr.mns.loctraining.domain.model.user.User;
import fr.mns.loctraining.vo.location.LocationDetails;
import fr.mns.loctraining.vo.material.state.StateDetails;
import fr.mns.loctraining.vo.user.status.StatusDetails;
import fr.mns.loctraining.vo.user.user.UserDetails;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MappingUtils {

    // Méthode pour convertir le Status en StatusDetails (identique à celle dans StatusServiceImpl)
    public static StatusDetails getDetails(Status status) {
        StatusDetails details = new StatusDetails();
        details.setId(status.getId());
        details.setName(status.getName());

        return details;
    }

    public static LocationDetails getDetails(Location location) {
        LocationDetails details = new LocationDetails();
        details.setId(location.getId());
        details.setAskingDate(location.getAskingDate());
        details.setReason(location.getReason());
        details.setPrevisionnalStartingDate(location.getPrevisionnalStartingDate());
        details.setPrevisionnalEndDate(location.getPrevisionnalEndDate());
        details.setExtentionDate(location.getExtentionDate());
        details.setExtendionDateValidation(location.getExtentionDateValidation());
        details.setExtensionDuration(location.getExtensionDuration());
        details.setDecision(location.getDecision());
        details.setDecisionDate(location.getDecisionDate());
        details.setUser(getDetails(location.getUser()));
        return details;
    }

    public static UserDetails getDetails(User user) {
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
        details.setStatus(getDetails(user.getStatus()));
        return details;
    }

    public static StateDetails getDetails(State state) {
        StateDetails details = new StateDetails();
        details.setId(state.getId());
        details.setName(state.getName());
        return details;
    }
}
