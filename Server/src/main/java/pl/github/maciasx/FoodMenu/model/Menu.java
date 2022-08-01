package pl.github.maciasx.FoodMenu.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "menu")
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @Enumerated(EnumType.STRING)
    @Column(name = "meal")
    private Meal meal;

    private Date dateMenu;

    public Menu() {
    }

    public Menu(Food food, Meal meal, Date dateMenu) {
        this.food = food;
        this.meal = meal;
        this.dateMenu = dateMenu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Food getFoods() {
        return food;
    }

    public void setFoods(Food foods) {
        this.food = foods;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Date getDateMenu() {
        return dateMenu;
    }

    public void setDateMenu(Date date) {
        this.dateMenu = date;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", food=" + food +
                ", meal=" + meal +
                ", date=" + dateMenu +
                '}';
    }
}
