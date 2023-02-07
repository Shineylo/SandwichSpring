package technobel.bart.sandwichspring.service.impl;

import org.springframework.stereotype.Service;
import technobel.bart.sandwichspring.models.dto.SandwichDTO;
import technobel.bart.sandwichspring.models.entity.Sandwich;
import technobel.bart.sandwichspring.models.form.SandwichInsertForm;
import technobel.bart.sandwichspring.repository.SandwichRepository;
import technobel.bart.sandwichspring.service.SandwichService;
import technobel.bart.sandwichspring.service.mapper.SandwichMapper;

import java.util.List;

@Service
public class SandwichServiceImpl implements SandwichService {

    private final SandwichRepository sandwichRepository;
    private final SandwichMapper mapper;

    public SandwichServiceImpl(SandwichRepository sandwichRepository, SandwichMapper mapper) {
        this.sandwichRepository = sandwichRepository;
        this.mapper = mapper;
    }

    @Override
    public List<SandwichDTO> getAll() {
        return sandwichRepository.findAll().stream()
                .map( mapper::toDto )
                .toList();
    }


    @Override
    public SandwichDTO getOne(Long id) {
        return sandwichRepository.findById(id)
                .map( mapper::toDto )
                .orElseThrow( () -> new RuntimeException("Sandwich not found") );
    }

    @Override
    public void insert(SandwichInsertForm form) {
        if( form == null )
            throw new IllegalArgumentException("form should not be null");

        Sandwich entity = mapper.toEntity(form);
        sandwichRepository.save( entity );
    }

}
