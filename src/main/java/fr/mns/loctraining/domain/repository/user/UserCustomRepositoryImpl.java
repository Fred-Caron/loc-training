package fr.mns.loctraining.domain.repository.user;

import fr.mns.loctraining.domain.model.user.User;
import fr.mns.loctraining.vo.user.user.UserSearchRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserCustomRepositoryImpl implements UserCustomRepository {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<User> search(UserSearchRequest request) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(request.getSearch())) {
            predicates.add(criteriaBuilder.or(
                    criteriaBuilder.like(root.get("lastname"), getLikeValue(request.getSearch())),
                    criteriaBuilder.like(root.get("firstname"), getLikeValue(request.getSearch())),
                    criteriaBuilder.like(root.get("email"), getLikeValue(request.getSearch())),
                    criteriaBuilder.like(root.get("login"), getLikeValue(request.getSearch()))
            ));
        }

        if (request.getGender() != null) {
            predicates.add(criteriaBuilder.equal(root.get("gender"), request.getGender()));
        }
        Predicate finalPredicate = criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        criteriaQuery.where(finalPredicate);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    private String getLikeValue(String value) {
        return "%" + value + "%";
    }
}
