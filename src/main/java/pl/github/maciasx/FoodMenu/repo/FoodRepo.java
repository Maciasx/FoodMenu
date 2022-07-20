package pl.github.maciasx.FoodMenu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.github.maciasx.FoodMenu.model.Food;

import java.util.Optional;

public interface FoodRepo extends JpaRepository<Food,Long> {
    void deleteFoodById(Long id);

    Optional<Food> findFoodById(Long id);
}
