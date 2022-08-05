package pl.github.maciasx.FoodMenu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.github.maciasx.FoodMenu.model.User;

public interface LoginRepo extends JpaRepository<User, Long> {

    User findLoginByEmailAndPassword(String email, String password);
}
