package pl.github.maciasx.FoodMenu.menu;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.github.maciasx.FoodMenu.food.Food;
import pl.github.maciasx.FoodMenu.model.Meal;
import pl.github.maciasx.FoodMenu.user.User;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuRequest {

    private Long id;

    private Food food;

    private User user;

    private Meal meal;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateMenu;

}
