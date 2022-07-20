package pl.github.maciasx.FoodMenu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.github.maciasx.FoodMenu.exception.UserNotFoundException;
import pl.github.maciasx.FoodMenu.model.Food;
import pl.github.maciasx.FoodMenu.repo.FoodRepo;

import java.util.List;

@Service
public class FoodService {
    private final FoodRepo foodRepo;

    @Autowired
    public FoodService(FoodRepo foodRepo) {
        this.foodRepo = foodRepo;
    }

    public Food addFood(Food food)
    {
        return foodRepo.save(food);
    }

    public List<Food> findAllFood()
    {
        return foodRepo.findAll();
    }

    public Food updateFood(Food food)
    {
        return foodRepo.save(food);
    }

    public Food findFoodById(Long id)
    {
        return foodRepo.findFoodById(id).orElseThrow(() -> new UserNotFoundException(" Food by id" + id + " was not found"));
    }

    public void deleteFood(Long id)
    {
        foodRepo.deleteFoodById(id);
    }
}
