package pl.github.maciasx.FoodMenu.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Food implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private Double calorie;
    private Double protein;
    private Double fat;
    private Double sugar;
    private Double fiber;

    public Food() {
    }

    public Food(String name, Double calorie, Double protein, Double fat, Double sugar, Double fiber) {
        this.name = name;
        this.calorie = calorie;
        this.protein = protein;
        this.fat = fat;
        this.sugar = sugar;
        this.fiber = fiber;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCalorie() {
        return calorie;
    }

    public void setCalorie(Double calorie) {
        this.calorie = calorie;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getSugar() {
        return sugar;
    }

    public void setSugar(Double sugar) {
        this.sugar = sugar;
    }

    public Double getFiber() {
        return fiber;
    }

    public void setFiber(Double fiber) {
        this.fiber = fiber;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calorie=" + calorie +
                ", protein=" + protein +
                ", fat=" + fat +
                ", sugar=" + sugar +
                ", fiber=" + fiber +
                '}';
    }
}
