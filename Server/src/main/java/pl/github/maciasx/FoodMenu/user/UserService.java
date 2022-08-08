package pl.github.maciasx.FoodMenu.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.github.maciasx.FoodMenu.exception.ApiRequestException;
import pl.github.maciasx.FoodMenu.exception.EmailValidator;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private EmailValidator emailValidator;

    public User signUpUser(User user) {

        boolean isValidEmail = emailValidator.test(user.getEmail());
        if(!isValidEmail)
        {
            throw new ApiRequestException("Nieprawidłowy email");
        }

        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();

        if(userExists){
            throw new ApiRequestException("email jest już zajęty");
        }

        return userRepository.save(user);
    }

    public User getLogin(User user) {return userRepository.findLoginByEmailAndPassword(user.getEmail(), user.getPassword());}


}