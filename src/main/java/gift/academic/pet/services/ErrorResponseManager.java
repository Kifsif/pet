package gift.academic.pet.services;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.Map;

@Service
public class ErrorResponseManager {
    public Map<String, Map<String, Object>> getUserRegistrationErrors(BindingResult bindingResult){
        var allErrors = bindingResult.getAllErrors();

        Map<String, String> errors = new HashMap<>();

        for(ObjectError error: allErrors) {
            FieldError fieldError = (FieldError)error;
            errors.put(fieldError.getField(), fieldError.getDefaultMessage() );
        }

        Map<String, Object> tmpResponse = new HashMap<>();
        tmpResponse.put("code", 422);
        tmpResponse.put("message", "Validation error");
        tmpResponse.put("errors", errors);

        Map<String, Map<String, Object>> response = new HashMap<>();

        response.put("error", tmpResponse);

        return response;
    }
}
