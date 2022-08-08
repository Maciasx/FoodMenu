package pl.github.maciasx.FoodMenu.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findLoginByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);
}
