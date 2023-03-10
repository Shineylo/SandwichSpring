package technobel.bart.sandwichspring.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class SandwichDTO {
    private Long id;
    private String name;
    private String description;
    private double price;

    private Set<IngredientDTO> ingredients;
}
