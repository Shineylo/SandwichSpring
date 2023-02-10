package technobel.bart.sandwichspring.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IngredientDTO {

    private Long id;
    private String name;

}
