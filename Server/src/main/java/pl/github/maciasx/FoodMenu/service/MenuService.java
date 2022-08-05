package pl.github.maciasx.FoodMenu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.github.maciasx.FoodMenu.exception.UserNotFoundException;
import pl.github.maciasx.FoodMenu.model.Food;
import pl.github.maciasx.FoodMenu.model.Menu;
import pl.github.maciasx.FoodMenu.model.MenuRequest;
import pl.github.maciasx.FoodMenu.repo.MenuRepo;

import java.sql.Date;
import java.util.List;

@Service
public class MenuService {
    private final MenuRepo menuRepo;
    private final FoodService foodService;

    @Autowired
    public MenuService(MenuRepo menuRepo, FoodService foodService) {
        this.menuRepo = menuRepo;
        this.foodService = foodService;
    }

    public Menu addMenu(MenuRequest menuRequest) {
        for (Food foods : menuRequest.getFoodId()) {
            Food food = foodService.findFoodById(foods.getId());
            Menu menu = new Menu();
            menu.setFoods(food);
            menu.setDateMenu(menuRequest.getDateMenu());
            menu.setMeal(menuRequest.getMeal());
            return menuRepo.save(menu);
        }
        return null;
    }

    public List<Menu> findAllMenu() {
        return menuRepo.findAll();
    }

    public List<Menu> findMenu() {
        return menuRepo.findAll();
    }

    public Menu updateMenu(Menu menu) {
        return menuRepo.save(menu);
    }

    public Menu findMenuById(Long id) {
        return menuRepo.findMenuById(id).orElseThrow(() -> new UserNotFoundException(" Menu by id" + id + " was not found"));
    }

    public List<Menu> findMenuByDateMenu(Date dateMenu) {

        List<Menu> allMenu = menuRepo.findAllMenuByDateMenu(dateMenu);
        return allMenu;
    }

    public void deleteMenu(Long id) {
        menuRepo.deleteMenuById(id);
    }
}
