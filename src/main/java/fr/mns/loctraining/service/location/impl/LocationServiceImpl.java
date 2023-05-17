package fr.mns.loctraining.service.location.impl;

import fr.mns.loctraining.domain.model.location.Location;
import fr.mns.loctraining.domain.model.user.Status;
import fr.mns.loctraining.domain.model.user.User;
import fr.mns.loctraining.domain.repository.location.LocationRepository;
import fr.mns.loctraining.domain.repository.user.UserRepository;
import fr.mns.loctraining.service.location.LocationService;
import fr.mns.loctraining.tools.exception.BadRequestException;
import fr.mns.loctraining.tools.exception.NotFoundException;
import fr.mns.loctraining.vo.location.LocationCreateRequest;
import fr.mns.loctraining.vo.location.LocationDetails;
import fr.mns.loctraining.vo.location.LocationUpdateRequest;
import fr.mns.loctraining.vo.user.user.UserDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {
    private LocationRepository locationRepository;
    private UserRepository userRepository;

    @Override
    public LocationDetails getDetails(Integer id) {
        Location location = locationRepository.findByIdNullSafe(id);
        if(location == null){
            throw new NotFoundException();
        }
        return getDetails(location);
    }

    @Override
    public List<LocationDetails> getList() {
        List<Location> locationList = locationRepository.findAll();
        List<LocationDetails> locationDetailsList = new ArrayList<>();
        for (Location location : locationList) {
            LocationDetails details = getDetails(location);
            locationDetailsList.add(details);
        }
        return locationDetailsList;
    }

    @Override
    public LocationDetails create(LocationCreateRequest request) {
        if (!StringUtils.hasText(String.valueOf(request.getAskingDate()))) {
            throw new BadRequestException("Asking date should not be empty");
        }
        if (!StringUtils.hasText(request.getReason())) {
            throw new BadRequestException("Reason should not be empty");
        }
        if (!StringUtils.hasText(String.valueOf(request.getPrevisionnalStartingDate()))) {
            throw new BadRequestException("Previsionnal starting date should not be empty");
        }
        if (!StringUtils.hasText(String.valueOf(request.getPrevisionnalEndDate()))) {
            throw new BadRequestException("Previsionnal ending date should not be empty");
        }
        if (!StringUtils.hasText(String.valueOf(request.getExtentionDate()))) {
            throw new BadRequestException("Extention date should not be empty");
        }
        if (!StringUtils.hasText(String.valueOf(request.getExtendionDateValidation()))) {
            throw new BadRequestException("Extention date validation should not be empty");
        }
        if (!StringUtils.hasText(String.valueOf(request.getExtensionDuration()))) {
            throw new BadRequestException("Extention duration should not be empty");
        }
        if (!StringUtils.hasText(String.valueOf(request.getDecisionDate()))) {
            throw new BadRequestException("Decision date should not be empty");
        }
        if (!StringUtils.hasText(request.getDecision())) {
            throw new BadRequestException("Decision should not be empty");
        }

        User user = getUser(request.getUserId());

        Location location = new Location();
        location.setAskingDate(request.getAskingDate());
        location.setReason(request.getReason());
        location.setPrevisionnalStartingDate(request.getPrevisionnalStartingDate());
        location.setPrevisionnalEndDate(request.getPrevisionnalEndDate());
        location.setExtentionDate(request.getExtentionDate());
        location.setExtentionDateValidation(request.getExtendionDateValidation());
        location.setExtensionDuration(request.getExtensionDuration());
        location.setDecision(request.getDecision());
        location.setDecisionDate(request.getDecisionDate());
        location.setUser(user);
        location = locationRepository.save(location);
        return getDetails(location);
    }

    @Override
    public LocationDetails update(Integer id, LocationUpdateRequest request) {
        Location location = locationRepository.findByIdNullSafe(id);
        if(location == null){
            throw new NotFoundException();
        }
        if (!StringUtils.hasText(String.valueOf(request.getAskingDate()))) {
            throw new BadRequestException("Asking date should not be empty");
        }
        if (!StringUtils.hasText(request.getReason())) {
            throw new BadRequestException("Reason should not be empty");
        }
        if (!StringUtils.hasText(String.valueOf(request.getPrevisionnalStartingDate()))) {
            throw new BadRequestException("Previsionnal starting date should not be empty");
        }
        if (!StringUtils.hasText(String.valueOf(request.getPrevisionnalEndDate()))) {
            throw new BadRequestException("Previsionnal ending date should not be empty");
        }
        if (!StringUtils.hasText(String.valueOf(request.getExtentionDate()))) {
            throw new BadRequestException("Extention date should not be empty");
        }
        if (!StringUtils.hasText(String.valueOf(request.getExtendionDateValidation()))) {
            throw new BadRequestException("Extention date validation should not be empty");
        }
        if (!StringUtils.hasText(String.valueOf(request.getExtensionDuration()))) {
            throw new BadRequestException("Extention duration should not be empty");
        }
        if (!StringUtils.hasText(String.valueOf(request.getDecisionDate()))) {
            throw new BadRequestException("Decision date should not be empty");
        }
        if (!StringUtils.hasText(request.getDecision())) {
            throw new BadRequestException("Decision should not be empty");
        }

        User user = getUser(request.getUserId());

        location.setAskingDate(request.getAskingDate());
        location.setReason(request.getReason());
        location.setPrevisionnalStartingDate(request.getPrevisionnalStartingDate());
        location.setPrevisionnalEndDate(request.getPrevisionnalEndDate());
        location.setExtentionDate(request.getExtentionDate());
        location.setExtentionDateValidation(request.getExtendionDateValidation());
        location.setExtensionDuration(request.getExtensionDuration());
        location.setDecision(request.getDecision());
        location.setDecisionDate(request.getDecisionDate());
        location.setUser(user);
        location = locationRepository.save(location);
        return getDetails(location);
    }

    @Override
    public void delete(Integer id) {
        Location location = locationRepository.findByIdNullSafe(id);
        if(location == null){
            throw new NotFoundException();
        }
        locationRepository.delete(location);
    }

    private LocationDetails getDetails(Location location){
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
        details.setUser(getUserDetails(location.getUser()));
        return details;
    }

    private UserDetails getUserDetails(User user){
        UserDetails details = new UserDetails();
        details.setLastname(details.getLastname());
        details.setFirstname(details.getFirstname());
        details.setEmail(details.getEmail());
        details.setLogin(details.getLogin());
        details.setGender(details.getGender());
        details.setPhone(details.getPhone());
        details.setAffiliation(details.getAffiliation());
        details.setStatus(details.getStatus());
        return details;
    }

    private User getUser(Integer userId) {
        User user = userRepository.findByIdNullSafe(userId);
        if (user == null) {
            throw new BadRequestException("Incorrect user");
        }
        return user;
    }
}
