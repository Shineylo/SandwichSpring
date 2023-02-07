package technobel.bart.sandwichspring.service.impl;

import org.springframework.stereotype.Service;
import technobel.bart.sandwichspring.models.dto.SandwichDTO;
import technobel.bart.sandwichspring.models.entity.Sandwich;
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
        List<Sandwich> sandwiches = sandwichRepository.findAll();
        return sandwiches.stream()
                .map(mapper::toDTO)
                .toList();
    }
    
}
