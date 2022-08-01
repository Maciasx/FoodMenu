package pl.github.maciasx.FoodMenu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.github.maciasx.FoodMenu.model.Food;
import pl.github.maciasx.FoodMenu.model.Meal;
import pl.github.maciasx.FoodMenu.model.Menu;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface MenuRepo extends JpaRepository<Menu,Long> {
    void deleteMenuById(Long id);

    Optional<Menu> findMenuById(Long id);

    @Query(value = "SELECT m FROM Menu  m WHERE TRUNC(m.dateMenu) = ?1 ")
    List<Menu> findAllMenuByDateMenu(Date dateMenu);
}
