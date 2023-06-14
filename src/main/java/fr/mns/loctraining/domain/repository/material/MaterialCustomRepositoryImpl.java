package fr.mns.loctraining.domain.repository.material;

import fr.mns.loctraining.domain.model.material.Material;
import fr.mns.loctraining.vo.material.material.MaterialSearchRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MaterialCustomRepositoryImpl implements MaterialCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Material> search(MaterialSearchRequest request) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Material> criteriaQuery = criteriaBuilder.createQuery(Material.class);
        Root<Material> root = criteriaQuery.from(Material.class);
        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(request.getSearch())) {
            predicates.add(criteriaBuilder.or(
                    criteriaBuilder.like(root.get("model").get("name"), getLikeValue(request.getSearch())),
                    criteriaBuilder.like(root.get("category").get("name"), getLikeValue(request.getSearch()))
            ));
        }
        if (request.getCategoryId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("category").get("id"), request.getCategoryId()));
        }
        if (request.getStorageAreaId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("storageArea").get("id"), request.getStorageAreaId()));
        }
        Predicate finalPredicate = criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
        criteriaQuery.where(finalPredicate);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    private String getLikeValue(String value) {
        return "%" + value + "%";
    }
}
