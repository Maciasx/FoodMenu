package pl.github.maciasx.FoodMenu.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.github.maciasx.FoodMenu.exception.ApiRequestException;
import pl.github.maciasx.FoodMenu.exception.EmailValidator;
import pl.github.maciasx.FoodMenu.model.Sex;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private EmailValidator emailValidator;

    public User signUpUser(User user) {

        boolean isValidEmail = emailValidator.test(user.getEmail());
        if (!isValidEmail) {
            throw new ApiRequestException("Nieprawidłowy email");
        }

        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();

        if (userExists) {
            throw new ApiRequestException("email jest już zajęty");
        }

        return userRepository.save(user);
    }

    public User getLogin(User user) {
        return userRepository.findLoginByEmailAndPassword(user.getEmail(), user.getPassword());
    }

    public User update(User user) {
        User updateUser = userRepository.findById(user.getId()).orElseThrow(() -> new ApiRequestException("Nie znaleziono użytkownika"));
        if (user.getHeight() != null)
            updateUser.setHeight(user.getHeight());
        if (user.getAge() != null)
            updateUser.setAge(user.getAge());
        if (user.getWeight() != null)
            updateUser.setWeight(user.getWeight());
        if (user.getSex() != null)
            updateUser.setSex(user.getSex());
        return userRepository.save(updateUser);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ApiRequestException("Nie znaleziono użytkownika"));
    }

    public Double getDailyEnergy(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ApiRequestException("Nie znaleziono użytkownika"));

        Double calculations = 0D;

        if (user.getHeight() != null && user.getAge() != null && user.getWeight() != null)
            calculations = (10.0 * user.getWeight()) + (6.25 * user.getHeight()) - (5.0 * user.getAge());

        if (user.getSex() == Sex.male) {
            return calculations + 5;
        } else if (user.getSex() == Sex.female) {
            return calculations - 161;
        } else
            return 0D;


    }
}
