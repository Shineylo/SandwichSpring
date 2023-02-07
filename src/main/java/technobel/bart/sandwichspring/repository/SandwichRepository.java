package technobel.bart.sandwichspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.bart.sandwichspring.models.entity.Sandwich;

public interface SandwichRepository extends JpaRepository<Sandwich,Long> {
}
