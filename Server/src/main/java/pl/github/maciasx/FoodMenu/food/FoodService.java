package pl.github.maciasx.FoodMenu.food;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.github.maciasx.FoodMenu.exception.ApiRequestException;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public Food addFood(Food food) {
        food.setWeight(100D);
        return foodRepository.save(food);
    }

    public List<Food> findAllFood() {
        return foodRepository.findAllFood();
    }

    public Food updateFood(Food food) {
        return foodRepository.save(food);
    }

    public Food findFoodById(Long id) {
        return foodRepository.findFoodById(id).orElseThrow(() -> new ApiRequestException("Nie znaleziono produktu"));
    }
    public Food findFoodByNameAndWeight(String name, Double weight) {

        return foodRepository.findFoodByNameAndWeight(name,weight);
    }

    public void deleteFood(Long id) {
        foodRepository.deleteFoodById(id);
    }
}
