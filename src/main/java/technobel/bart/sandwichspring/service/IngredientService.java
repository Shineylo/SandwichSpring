package technobel.bart.sandwichspring.service;

import technobel.bart.sandwichspring.models.dto.IngredientDTO;

import java.util.List;

public interface IngredientService {

    List<IngredientDTO> getAll();
    IngredientDTO getOne(long id);

    void insert(String name);

    void delete(long id);

}