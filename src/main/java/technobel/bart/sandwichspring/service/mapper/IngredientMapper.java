package technobel.bart.sandwichspring.service.mapper;

import org.springframework.stereotype.Service;
import technobel.bart.sandwichspring.models.dto.IngredientDTO;
import technobel.bart.sandwichspring.models.entity.Ingredient;

@Service
public class IngredientMapper {

    public IngredientDTO toDto(Ingredient ingredient){
        if( ingredient == null )
            return null;

        return IngredientDTO.builder()
                .id(ingredient.getId())
                .name(ingredient.getName())
                .build();
    }

}