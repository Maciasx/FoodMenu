package pl.github.maciasx.FoodMenu.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.github.maciasx.FoodMenu.model.Menu;
import pl.github.maciasx.FoodMenu.model.MenuRequest;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuResouce {


    private final MenuService menuService;

    public MenuResouce(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Menu>> getAllMenu ()
    {
        List<Menu> menu = menuService.findAllMenu();
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    @GetMapping("/find/{dateMenu}")
    public ResponseEntity<List<Menu>> getMenu (@PathVariable("dateMenu") Date dateMenu)
    {
        List<Menu> menu = menuService.findMenuByDateMenu(dateMenu);
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    /*@GetMapping("/find/{id}")
    public ResponseEntity<Menu> getMenuById (@PathVariable("id") Long id)
    {
        Menu menu = menuService.findMenuById(id);
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }*/

    @PostMapping("/add")
    public ResponseEntity<Menu> addMenu (@RequestBody MenuRequest menu)
    {
        Menu newMenu = menuService.addMenu(menu);
        return new ResponseEntity<>(newMenu, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Menu> updateMenu (@RequestBody MenuRequest menu)
    {
        Menu updateMenu = menuService.addMenu(menu);
        return new ResponseEntity<>(updateMenu, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMenu (@PathVariable ("id") Long id)
    {
        menuService.deleteMenu(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
