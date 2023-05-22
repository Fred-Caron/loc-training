package fr.mns.loctraining.domain.model.material;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MaterialState {
    @EmbeddedId
    private MaterialStateKey id;

    @ManyToOne
    @MapsId("materielId")
    @JoinColumn(name = "material_id")
    private Material material;

    @ManyToOne
    @MapsId("stateId")
    @JoinColumn(name = "state_id")
    private State state;

}
