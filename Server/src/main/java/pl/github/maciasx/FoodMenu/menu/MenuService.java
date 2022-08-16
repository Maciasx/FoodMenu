package pl.github.maciasx.FoodMenu.menu;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.github.maciasx.FoodMenu.exception.ApiRequestException;
import pl.github.maciasx.FoodMenu.food.Food;
import pl.github.maciasx.FoodMenu.food.FoodService;
import pl.github.maciasx.FoodMenu.user.User;
import pl.github.maciasx.FoodMenu.user.UserService;

import java.sql.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    private final FoodService foodService;
    private final UserService userService;

    public Menu addMenu(MenuRequest menu) {

        Food food = foodService.findFoodByName(menu.getFood());
        User user = userService.getUserById(menu.getUser());

        Menu newMenu = new Menu();
        newMenu.setUser(user);
        newMenu.setFood(food);
        newMenu.setDateMenu(menu.getDateMenu());
        newMenu.setMeal(menu.getMeal());

        return menuRepository.save(newMenu);
    }

    public List<Menu> findAllMenu() {
        return menuRepository.findAll();
    }

    public List<Menu> findMenu() {
        return menuRepository.findAll();
    }

    public Menu updateMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu findMenuById(Long id) {
        return menuRepository.findMenuById(id).orElseThrow(() -> new ApiRequestException(" Menu by id" + id + " was not found"));
    }

    public List<Menu> findMenuByDateMenu(Date dateMenu) {

        List<Menu> allMenu = menuRepository.findAllMenuByDateMenu(dateMenu);
        return allMenu;
    }

    public void deleteMenu(Long id) {
        menuRepository.deleteMenuById(id);
    }
}
