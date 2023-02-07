package technobel.bart.sandwichspring.service.mapper;

import org.springframework.stereotype.Service;
import technobel.bart.sandwichspring.models.dto.SandwichDTO;
import technobel.bart.sandwichspring.models.entity.Sandwich;

@Service
public class SandwichMapper {
    public SandwichDTO toDTO(Sandwich entity){

        if(entity == null)
            return null;

        return SandwichDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .build();

    }
}
