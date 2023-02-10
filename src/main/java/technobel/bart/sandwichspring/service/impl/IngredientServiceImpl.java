package technobel.bart.sandwichspring.service.impl;

import org.springframework.stereotype.Service;
import technobel.bart.sandwichspring.exception.NotFoundException;
import technobel.bart.sandwichspring.models.dto.IngredientDTO;
import technobel.bart.sandwichspring.models.entity.Ingredient;
import technobel.bart.sandwichspring.repository.IngredientRepository;
import technobel.bart.sandwichspring.service.IngredientService;
import technobel.bart.sandwichspring.service.mapper.IngredientMapper;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    public IngredientServiceImpl(IngredientRepository ingredientRepository, IngredientMapper ingredientMapper) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientMapper = ingredientMapper;
    }

    @Override
    public List<IngredientDTO> getAll() {
        return ingredientRepository.findAll().stream()
                .map(ingredientMapper::toDto)
                .toList();
    }

    @Override
    public IngredientDTO getOne(long id) {
        return ingredientRepository.findById(id)
                .map( ingredientMapper::toDto )
                .orElseThrow(() -> new NotFoundException("Ingredient not found"));
    }

    @Override
    public void insert(String name) {
        Ingredient entity = new Ingredient();
        entity.setName(name);
        ingredientRepository.save(entity);
    }

    @Override
    public void delete(long id) {
        if( !ingredientRepository.existsById(id) )
            throw new NotFoundException("Ingredient not found");

        ingredientRepository.deleteById(id);
    }
}