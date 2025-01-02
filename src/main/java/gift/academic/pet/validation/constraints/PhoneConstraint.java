package gift.academic.pet.validation.constraints;

import gift.academic.pet.validation.validators.PhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneConstraint {
    String message() default "Only figures, may start with a plus sign.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}



