package pl.github.maciasx.FoodMenu.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.github.maciasx.FoodMenu.model.User;

@RestController
@RequestMapping("/login")
public class LoginResource {

    private final LoginService loginService;

    public LoginResource(LoginService loginService) {
        this.loginService = loginService;
    }


    @PostMapping("/add")
    public ResponseEntity<User> addLogin(@RequestBody User user) {
        User newUser = loginService.addLogin(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> getLogin(@RequestBody User user) {
        User getUser = loginService.getLogin(user);
        return new ResponseEntity<>(getUser, HttpStatus.OK);
    }

}
