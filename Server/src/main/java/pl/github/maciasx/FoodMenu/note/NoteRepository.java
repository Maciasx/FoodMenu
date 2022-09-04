package pl.github.maciasx.FoodMenu.note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.github.maciasx.FoodMenu.model.Meal;
import pl.github.maciasx.FoodMenu.user.User;


import java.sql.Date;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

/*
    @Query(value = "SELECT n FROM Note n WHERE TRUNC(n.dateMenu) = ?1 and n.user.id = ?2 and n.meal = ?3")
*/
    Note findNoteByDateMenuAndUserAndMeal(Date dateMenu, User user, Meal meal);
}
