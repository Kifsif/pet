package gift.academic.pet.advice;


import gift.academic.pet.exceptions.UserRegistrationValidationException;
import gift.academic.pet.services.ErrorResponseManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ValidationAdvice {
    public ValidationAdvice(ErrorResponseManager errorResponseManager) {
        this.errorResponseManager = errorResponseManager;
    }

    private final ErrorResponseManager errorResponseManager;

    @ExceptionHandler(UserRegistrationValidationException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    Map<String, Map<String, Object>> employeeNotFoundHandler(UserRegistrationValidationException ex) {
        return errorResponseManager.getUserRegistrationErrors(ex.getBindingResult());
    }
}
