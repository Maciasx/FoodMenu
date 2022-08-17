package pl.github.maciasx.FoodMenu.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    void deleteFoodById(Long id);

    Optional<Food> findFoodById(Long id);
    Food findFoodByNameAndWeight(String name, Double weight);

    @Query(value = "SELECT f FROM Food  f WHERE f.weight = 100 ")
    List<Food> findAllFood();

    @Query(value = "SELECT f FROM Food  f WHERE f.name = ?1 ")
    Food findFood(String name);
}
