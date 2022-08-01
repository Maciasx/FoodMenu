package pl.github.maciasx.FoodMenu.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.util.List;

public class MenuRequest {
    private Long id;
    private List<Food> foods;
    private Meal meal;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateMenu;

    public MenuRequest(Long id,  List<Food> foods, Meal meal, Date dateMenu) {
        this.id = id;
        this.foods = foods;
        this.meal = meal;
        this.dateMenu = dateMenu;
    }

    public MenuRequest() {
    }

    public MenuRequest(List<Food> foods, Meal meal, Date dateMenu) {
        this.foods = foods;
        this.meal = meal;
        this.dateMenu = dateMenu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Food> getFoodId() {
        return foods;
    }

    public void setFoodId(List<Food> foods) {
        this.foods = foods;
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

    public void setDateMenu(Date dateMenu) {
        this.dateMenu = dateMenu;
    }
}
