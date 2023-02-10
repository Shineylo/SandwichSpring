package technobel.bart.sandwichspring.service;

import technobel.bart.sandwichspring.models.dto.SandwichDTO;
import technobel.bart.sandwichspring.models.form.sandwich.SandwichInsertForm;
import technobel.bart.sandwichspring.models.form.sandwich.SandwichUpdateForm;

import java.util.List;

public interface SandwichService {
    List<SandwichDTO> getAll();
    SandwichDTO getOne(Long id);
    void insert(SandwichInsertForm form);
    void update(Long id, SandwichUpdateForm form);
}
