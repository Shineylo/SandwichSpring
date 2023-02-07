package technobel.bart.sandwichspring.models.form;

import lombok.Data;

@Data
public class SandwichInsertForm {
    private String name;
    private String desc;
    private double price;
}
