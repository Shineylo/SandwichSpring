package technobel.bart.sandwichspring.models.form.sandwich;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class SandwichUpdateForm {
    @NotNull
    @Size(min = 4,max = 20)
    private String name;
    @NotNull
    private String description;
    @Positive(message = "doit être positif")
    @Digits(integer = 2, fraction = 2)
    private double price;

    private List<Long> ingredientsId;
}
