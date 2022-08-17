package pl.github.maciasx.FoodMenu.food;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "food")
public class Food implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String name;

    private Double weight;

    private Double energy;

    private Double fat;

    private Double saturates;

    private Double carbohydrate;

    private Double sugars;

    private Double fibre;

    private Double protein;

    private Double salt;

}
