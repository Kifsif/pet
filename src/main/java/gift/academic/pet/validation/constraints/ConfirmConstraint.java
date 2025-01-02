package gift.academic.pet.validation.constraints;

import gift.academic.pet.validation.validators.ConfirmValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ConfirmValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfirmConstraint {
    String message() default "Confirmation is obligatory (permitted 1 or \"on\".)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}