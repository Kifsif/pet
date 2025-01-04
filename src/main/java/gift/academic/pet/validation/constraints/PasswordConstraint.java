package gift.academic.pet.validation.constraints;

import gift.academic.pet.validation.validators.PasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordConstraint {
    String message() default "Not less than 7 symbols, at least 1 number, " +
            "at least 1 uppercase letter, at least 1 lowercase letter.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
