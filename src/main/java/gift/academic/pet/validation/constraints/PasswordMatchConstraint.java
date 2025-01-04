package gift.academic.pet.validation.constraints;

import gift.academic.pet.validation.validators.PasswordMatchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordMatchValidator.class)
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordMatchConstraint {
    String message() default "Confirmation is obligatory (permitted 1 or \"on\".)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}