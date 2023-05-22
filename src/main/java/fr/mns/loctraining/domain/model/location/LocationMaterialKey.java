package fr.mns.loctraining.domain.model.location;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

// Classe qui permet de définir la clé composite (ici Location + Material)
// Criètres à respecter :
// 1. Doit avoir l'annotation Embeddable
// 2. Doit implémenter Serializable
// 3. Doit avoir les méthodes Equals et HashCode

// Annotation qui permet de définir le fait que c'est une classe "key"
@Embeddable
@Getter
@Setter
// Lombok : génère les méthodes EqualsAndHashCode (obligatoire dans le cas d'une clé composite)
@EqualsAndHashCode
public class LocationMaterialKey implements Serializable {

    // Annotation qui permet de définir une partie de la clé composite
    @Column
    private Integer locationId;

    @Column
    private Integer materialId;

}
