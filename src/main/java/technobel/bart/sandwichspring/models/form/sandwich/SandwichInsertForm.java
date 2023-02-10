package technobel.bart.sandwichspring.models.form.sandwich;

import lombok.Data;

@Data
public class SandwichInsertForm {
    private String name;
    private String description;
    private double price;
}
