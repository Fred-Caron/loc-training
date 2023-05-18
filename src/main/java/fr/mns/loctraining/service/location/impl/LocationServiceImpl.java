package fr.mns.loctraining.service.location.impl;

import fr.mns.loctraining.domain.model.location.Location;
import fr.mns.loctraining.domain.model.material.StorageArea;
import fr.mns.loctraining.domain.model.user.User;
import fr.mns.loctraining.domain.repository.location.LocationRepository;
import fr.mns.loctraining.domain.repository.user.UserRepository;
import fr.mns.loctraining.service.location.LocationService;
import fr.mns.loctraining.tools.exception.BadRequestException;
import fr.mns.loctraining.tools.exception.NotFoundException;
import fr.mns.loctraining.tools.utils.MappingUtils;
import fr.mns.loctraining.vo.location.LocationCreateRequest;
import fr.mns.loctraining.vo.location.LocationDetails;
import fr.mns.loctraining.vo.location.LocationUpdateRequest;
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
        return MappingUtils.getLocationDetails(location);
    }

    @Override
    public List<LocationDetails> getList() {
        List<Location> locationList = locationRepository.findAll();
        List<LocationDetails> locationDetailsList = new ArrayList<>();
        for (Location location : locationList) {
            LocationDetails details = MappingUtils.getLocationDetails(location);
            locationDetailsList.add(details);
        }
        return locationDetailsList;
    }

    @Override
    public LocationDetails create(LocationCreateRequest request) {
        if (request.getAskingDate() == null) {
            throw new BadRequestException("Asking date should not be empty");
        }
        if (!StringUtils.hasText(request.getReason())) {
            throw new BadRequestException("Reason should not be empty");
        }
        if (request.getPrevisionnalStartingDate() == null) {
            throw new BadRequestException("Previsionnal starting date should not be empty");
        }
        if (request.getPrevisionnalEndDate() == null) {
            throw new BadRequestException("Previsionnal ending date should not be empty");
        }
        if (request.getExtentionDate() == null) {
            throw new BadRequestException("Extention date should not be empty");
        }
        if (request.getExtendionDateValidation() == null) {
            throw new BadRequestException("Extention date validation should not be empty");
        }
        if (request.getExtensionDuration() == null) {
            throw new BadRequestException("Extention duration should not be empty");
        }
        if (request.getDecisionDate() == null) {
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
        return MappingUtils.getLocationDetails(location);
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
        return MappingUtils.getLocationDetails(location);
    }

    @Override
    public void delete(Integer id) {
        Location location = locationRepository.findByIdNullSafe(id);
        if(location == null){
            throw new NotFoundException();
        }
        locationRepository.delete(location);
    }

    private User getUser(Integer userId) {
        return userRepository.findByIdWithException(userId, "user");
    }
}
