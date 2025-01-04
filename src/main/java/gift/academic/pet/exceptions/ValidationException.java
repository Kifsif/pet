package gift.academic.pet.exceptions;

import org.springframework.validation.BindingResult;

public class ValidationException extends Exception{
    public ValidationException(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    private BindingResult bindingResult;

    public BindingResult getBindingResult() {
        return bindingResult;
    }
}
