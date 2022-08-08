package pl.github.maciasx.FoodMenu.user;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<User> getLogin(@RequestBody User user) {
        User getUser = userService.getLogin(user);
        return new ResponseEntity<>(getUser, HttpStatus.OK);
    }
}
