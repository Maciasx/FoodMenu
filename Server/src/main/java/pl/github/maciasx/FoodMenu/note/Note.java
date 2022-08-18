package pl.github.maciasx.FoodMenu.note;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.github.maciasx.FoodMenu.model.Meal;
import pl.github.maciasx.FoodMenu.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "note")
public class Note implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String note;

    private Meal meal;

    private Date dateMenu;

    @ManyToOne
    private User user;

}