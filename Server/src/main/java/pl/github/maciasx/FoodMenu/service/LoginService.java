package pl.github.maciasx.FoodMenu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.github.maciasx.FoodMenu.model.User;
import pl.github.maciasx.FoodMenu.repo.LoginRepo;


@Service
public class LoginService {

    private final LoginRepo loginRepo;

    @Autowired
    public LoginService(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }

    public User addLogin(User user) {
        return loginRepo.save(user);
    }

    public User getLogin(User user) {return loginRepo.findLoginByEmailAndPassword(user.getEmail(), user.getPassword());}
}
