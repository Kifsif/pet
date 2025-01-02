package gift.academic.pet.validation.constraints;

import gift.academic.pet.validation.validators.NameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NameValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NameConstraint {
    String message() default "Only cyryllic letters, the white space and the hyphen.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}