package pl.github.maciasx.FoodMenu.menu;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("menu")
@AllArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/{dataSelected}/{user}")
    public ResponseEntity<List<Menu>> getAllMenu(@PathVariable("dataSelected") Date date, @PathVariable("user") Long id) {
        List<Menu> menu = menuService.findAllMenu(date,id);
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Menu> addMenu(@RequestBody MenuRequest menu) {
        Menu newMenu = menuService.addMenu(menu);
        return new ResponseEntity<>(newMenu,HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable("id") Long id) {
        menuService.deleteMenu(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
