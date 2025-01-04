package gift.academic.pet.validation.validators;

import gift.academic.pet.models.User;
import gift.academic.pet.validation.constraints.PasswordMatchConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class PasswordMatchValidator implements ConstraintValidator<PasswordMatchConstraint, User> {
    @Override
    public void initialize(PasswordMatchConstraint constraint) {
    }

    @Override
    public boolean isValid(User user,
                           ConstraintValidatorContext cxt) {

        Boolean result = user.getPassword().equals(user.getPasswordConfirmation());

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
