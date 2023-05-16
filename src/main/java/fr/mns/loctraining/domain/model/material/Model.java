package fr.mns.loctraining.domain.model.material;

import fr.mns.loctraining.domain.model.common.NamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Model extends NamedEntity {


    @ManyToOne
    @JoinColumn(name = "brandId" )
    private Brand brand;
}
