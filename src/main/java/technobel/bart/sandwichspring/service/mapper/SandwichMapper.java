package technobel.bart.sandwichspring.service.mapper;

import org.springframework.stereotype.Service;
import technobel.bart.sandwichspring.models.dto.SandwichDTO;
import technobel.bart.sandwichspring.models.entity.Sandwich;
import technobel.bart.sandwichspring.models.form.sandwich.SandwichInsertForm;

@Service
public class SandwichMapper {
    public SandwichDTO toDto(Sandwich entity){

        if( entity == null )
            return null;

        return SandwichDTO.builder()
                .id( entity.getId() )
                .name( entity.getName() )
                .description( entity.getDescription() )
                .price( entity.getPrice() )
                .build();

    }

    public Sandwich toEntity(SandwichInsertForm form){
        if( form == null )
            return null;

        Sandwich sandwich = new Sandwich();

        sandwich.setName(form.getName() );
        sandwich.setPrice(form.getPrice());
        sandwich.setDescription(form.getDescription());

        return sandwich;
    }
}
