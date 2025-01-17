package gift.academic.pet.repositories;

import gift.academic.pet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailAndToken(String email, String token);
    Optional<User> findByEmail(String email);
}
