package pl.github.maciasx.FoodMenu.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    void deleteFoodById(Long id);

    Optional<Food> findFoodById(Long id);
    Optional<Food> findFoodByName(String name);
}
