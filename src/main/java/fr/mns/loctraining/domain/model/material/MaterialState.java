package fr.mns.loctraining.domain.model.material;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class MaterialState {
    @EmbeddedId
    private MaterialStateKey id;

    @ManyToOne
    @MapsId("materielId")
    @JoinColumn(name = "materialId")
    private Material material;

    @ManyToOne
    @MapsId("stateId")
    @JoinColumn(name = "stateId")
    private State state;

    private Date date;

}
