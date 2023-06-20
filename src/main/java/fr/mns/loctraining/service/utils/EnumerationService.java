package fr.mns.loctraining.service.utils;

import fr.mns.loctraining.dto.utils.EnumerationDetails;

import java.util.List;

public interface EnumerationService {

    List<EnumerationDetails> getGenders();

    List<EnumerationDetails> getAffiliations();

    List<EnumerationDetails> getRentalStatus();

}
