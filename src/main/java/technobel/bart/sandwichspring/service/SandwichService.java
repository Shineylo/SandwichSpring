package technobel.bart.sandwichspring.service;

import technobel.bart.sandwichspring.models.dto.SandwichDTO;

import java.util.List;

public interface SandwichService {
    
    List<SandwichDTO> getAll();
    
}
