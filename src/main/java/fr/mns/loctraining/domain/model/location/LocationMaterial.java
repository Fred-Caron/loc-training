package fr.mns.loctraining.domain.model.location;

import fr.mns.loctraining.domain.model.material.Material;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LocationMaterial {

    // Annotation qui permet de spécifier l'id composite
    @EmbeddedId
    private LocationMaterialKey id;

    @ManyToOne
    // Permet de préciser que cette relation fait partie de la clé composite et donc
    // doit prendre le même nom que dans la clé composite de LocationMaterialKey
    @MapsId("locationId")
    //join column traditionnel qui va prendre le nom de la colone en bdd
    @JoinColumn(name = "locationId")
    private Location location;

    @ManyToOne
    @MapsId("materialId")
    @JoinColumn(name = "materialId")
    private Material material;
}
