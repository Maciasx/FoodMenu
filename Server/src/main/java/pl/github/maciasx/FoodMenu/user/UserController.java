package pl.github.maciasx.FoodMenu.user;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/registration")
    public ResponseEntity<User> registration(@RequestBody User user) {
        User newUser = userService.signUpUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Long> getLogin(@RequestBody User user) {
        User getUser = userService.getLogin(user);
        return new ResponseEntity<>(getUser.getId(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {
        User getUser = userService.update(user);
        return new ResponseEntity<>(getUser, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
