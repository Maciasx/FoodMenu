package pl.github.maciasx.FoodMenu.menu;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.github.maciasx.FoodMenu.model.Meal;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuRequest {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String food;

    private Long user;

    private Meal meal;

    private Double weight;

    private Date dateMenu;

}
