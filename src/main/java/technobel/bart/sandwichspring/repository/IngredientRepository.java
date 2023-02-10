package technobel.bart.sandwichspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.bart.sandwichspring.models.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
