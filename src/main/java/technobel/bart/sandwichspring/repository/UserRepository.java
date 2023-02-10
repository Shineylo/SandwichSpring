package technobel.bart.sandwichspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.bart.sandwichspring.models.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
}
