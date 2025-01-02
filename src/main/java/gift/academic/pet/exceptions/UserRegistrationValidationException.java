package gift.academic.pet.exceptions;

import org.springframework.validation.BindingResult;

import java.util.Map;

public class UserRegistrationValidationException extends Exception{
    public UserRegistrationValidationException(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    private BindingResult bindingResult;

    public BindingResult getBindingResult() {
        return bindingResult;
    }
}
