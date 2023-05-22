package fr.mns.loctraining.domain.model.material;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class MaterialStateKey implements Serializable {
    @Column
    private Integer materialId;
    @Column
    private Integer stateId;
}
