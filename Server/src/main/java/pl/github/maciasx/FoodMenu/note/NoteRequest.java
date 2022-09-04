package pl.github.maciasx.FoodMenu.note;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.github.maciasx.FoodMenu.model.Meal;
import pl.github.maciasx.FoodMenu.user.User;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteRequest {

    private Long id;

    private Long user;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String note;

    private Meal meal;

    private Date dateMenu;

}
