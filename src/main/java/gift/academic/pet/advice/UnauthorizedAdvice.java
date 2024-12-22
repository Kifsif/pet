package gift.academic.pet.advice;

import gift.academic.pet.exceptions.UnauthorizedException;
import gift.academic.pet.services.UnauthorizedResponseManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class UnauthorizedAdvice {
    private final UnauthorizedResponseManager unauthorizedResponseManager;

    public UnauthorizedAdvice(UnauthorizedResponseManager unauthorizedResponseManager) {
        this.unauthorizedResponseManager = unauthorizedResponseManager;
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    Map<String, Map<String, Object>> employeeNotFoundHandler(UnauthorizedException ex) {
        return unauthorizedResponseManager.getUnoathorizedResponse();
    }
}
