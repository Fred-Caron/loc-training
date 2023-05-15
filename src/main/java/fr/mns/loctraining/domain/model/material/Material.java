package fr.mns.loctraining.domain.model.material;

import fr.mns.loctraining.domain.model.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.Banner;

@Entity
@Getter
@Setter

public class Material extends BaseEntity {

    private int registrationNumber;

    @ManyToOne
    @JoinColumn(name = "modelId")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "storageAreaId")
    private StorageArea storageArea;

    @ManyToOne
    @JoinColumn(name = "documentationId")
    private Documentation documentation;
}
