package fr.mns.loctraining.controller.utils;

import fr.mns.loctraining.service.utils.EnumerationService;
import fr.mns.loctraining.vo.utils.EnumerationDetails;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "enumeration")
@AllArgsConstructor
public class EnumerationController {

    private final EnumerationService service;

    @GetMapping("gender")
    public List<EnumerationDetails> getGenders() {
        return service.getGenders();
    }
}
