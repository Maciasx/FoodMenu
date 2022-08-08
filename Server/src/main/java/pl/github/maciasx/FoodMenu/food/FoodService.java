package pl.github.maciasx.FoodMenu.food;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.github.maciasx.FoodMenu.exception.ApiRequestException;

import java.util.List;

@Service
@AllArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public Food addFood(Food food) {
        return foodRepository.save(food);
    }

    public List<Food> findAllFood() {
        return foodRepository.findAll();
    }

    public Food updateFood(Food food) {
        return foodRepository.save(food);
    }

    public Food findFoodById(Long id) {
        return foodRepository.findFoodById(id).orElseThrow(() -> new ApiRequestException(" Food by id" + id + " was not found"));
    }

    public void deleteFood(Long id) {
        foodRepository.deleteFoodById(id);
    }
}
