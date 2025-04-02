package th.ac.mahidol.ict.gemini7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ac.mahidol.ict.gemini7.model.User;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByNameAndPassword(String name, String password);
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
}
