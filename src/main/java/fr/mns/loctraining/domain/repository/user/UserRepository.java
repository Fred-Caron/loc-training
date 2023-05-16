package fr.mns.loctraining.domain.repository.user;

import fr.mns.loctraining.domain.model.user.User;
import fr.mns.loctraining.domain.repository.common.BaseRepository;

public interface UserRepository extends BaseRepository<User> {
    
    User findFirstByEmail(String email);

    User findFirstByEmailLikeOrFirstNameLike(String email, String firstname);

    User findFirstByEmailAndFirstNameAndLastName(String email, String firstName, String lastName);
}
