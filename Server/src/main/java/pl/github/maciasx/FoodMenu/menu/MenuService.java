package pl.github.maciasx.FoodMenu.menu;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.github.maciasx.FoodMenu.food.Food;
import pl.github.maciasx.FoodMenu.food.FoodRepository;
import pl.github.maciasx.FoodMenu.food.FoodService;
import pl.github.maciasx.FoodMenu.user.User;
import pl.github.maciasx.FoodMenu.user.UserService;

import java.sql.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final FoodRepository foodRepository;
    private final FoodService foodService;
    private final UserService userService;

    public Menu addMenu(MenuRequest menu) {

        Menu newMenu = new Menu();

        User user = userService.getUserById(menu.getUser());
        Food getFood = foodService.findFoodByNameAndWeight(menu.getFood(), menu.getWeight());

        if (getFood == null) {
            Double calculations = menu.getWeight() / 100;
            getFood = foodService.findFoodByNameAndWeight(menu.getFood(), 100D);
            Food food = new Food();
            food.setName(getFood.getName());
            food.setEnergy(getFood.getEnergy() * calculations);
            food.setFat(getFood.getFat() * calculations);
            food.setCarbohydrate(getFood.getCarbohydrate() * calculations);
            food.setFibre(getFood.getFibre() * calculations);
            food.setProtein(getFood.getProtein() * calculations);
            food.setSaturates(getFood.getSaturates() * calculations);
            food.setSugars(getFood.getSugars() * calculations);
            food.setWeight(getFood.getWeight() * calculations);
            foodRepository.save(food);
            newMenu.setFood(food);
        } else newMenu.setFood(getFood);
        newMenu.setUser(user);
        newMenu.setDateMenu(menu.getDateMenu());
        newMenu.setMeal(menu.getMeal());

        return menuRepository.save(newMenu);
    }

    public List<Menu> findAllMenu(Date date, Long id) {
        return menuRepository.findAllMenu(date, id);
    }

    public void deleteMenu(Long id) {
        menuRepository.deleteMenuById(id);
    }
}
