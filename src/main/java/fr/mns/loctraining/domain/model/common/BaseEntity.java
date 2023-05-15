package fr.mns.loctraining.domain.model.common;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

// L'annotation sert à faire de l'héritage avec hibernate. Elle permet à une classe enfant Entity d'étendre cette classe parente
// Attention une classe @MappedSuperclass ne peut pas être Entity en même temps
// Ici on définit une classe de base qui va permettre d'harmoniser les ID de toutes les autres classes Entity, on aura toujours comme ID un int nommé 'id'
@MappedSuperclass
public class BaseEntity {

    // L'annotion Id sert à définir la clé primaire
    // Important de mettre un Integer et pas un int car à la création l'id est null
    @Id
    // L'annotation sert à spécifier comment cette valeur est générée automatiquement
    // IDENTITY = auto-increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
