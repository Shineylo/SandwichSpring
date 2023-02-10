package technobel.bart.sandwichspring.models.form.sandwich;

import jakarta.validation.constraints.Size;
import lombok.Data;
import technobel.bart.sandwichspring.validation.constraints.NotEquals;

import java.util.List;

@Data
public class SandwichInsertForm {

    @Size(min = 4)
    private String name;
    private String description;
    @NotEquals(value = 2, message = "should not be 2")
    private double price;

    @Size(min = 2)
    private List<Long> ingredientsId;
}
