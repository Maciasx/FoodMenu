package pl.github.maciasx.FoodMenu.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class ApiException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
}
