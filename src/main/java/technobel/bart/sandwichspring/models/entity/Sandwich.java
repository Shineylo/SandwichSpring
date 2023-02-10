package technobel.bart.sandwichspring.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Setter @Getter
public class Sandwich {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sandwich_id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private double price;

    @ManyToMany
    @JoinTable(
            name = "sandwich_ingredients",
            joinColumns = @JoinColumn(name = "sandwich_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<Ingredient> ingredients = new LinkedHashSet<>();

}
