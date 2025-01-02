package gift.academic.pet.validation.validators;

import gift.academic.pet.dtos.UserRegistrationDto;
import gift.academic.pet.validation.constraints.PasswordMatchConstraint;
import gift.academic.pet.validation.constraints.PhoneConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;


import java.net.BindException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PasswordMatchValidator implements ConstraintValidator<PasswordMatchConstraint, UserRegistrationDto> {
    @Override
    public void initialize(PasswordMatchConstraint constraint) {
    }

    @Override
    public boolean isValid(UserRegistrationDto userRegistrationDto,
                           ConstraintValidatorContext cxt) {

        Boolean result = userRegistrationDto.getPassword().equals(userRegistrationDto.getPasswordConfirmation());

        if (!result) {
            // Disable the default constraint violation.
            cxt.disableDefaultConstraintViolation();

            // Add a custom violation tied to the `password_confirmation` field.
            cxt.buildConstraintViolationWithTemplate("Passwords do not match.")
                    .addPropertyNode("password_confirmation")
                    .addConstraintViolation();
        }

        return result;
    }
}
