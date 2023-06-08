package fr.mns.loctraining.domain.repository.user;

import fr.mns.loctraining.domain.model.user.User;
import fr.mns.loctraining.domain.repository.common.BaseRepository;

public interface UserRepository extends BaseRepository<User>, UserCustomRepository {

    User findFirstByEmail(String email);

    User findFirstByEmailLikeOrFirstnameLike(String email, String firstname);

    User findFirstByEmailAndFirstnameAndLastname(String email, String firstname, String lastname);
}
