package gift.academic.pet.validation.validators;

import gift.academic.pet.validation.constraints.ConfirmConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfirmValidator implements ConstraintValidator<ConfirmConstraint, String> {
    @Override
    public void initialize(ConfirmConstraint constraint) {
    }

    @Override
    public boolean isValid(String fieldText,
                           ConstraintValidatorContext cxt) {

        Pattern mypattern = Pattern.compile("^1|on$");
        Matcher mymatcher= mypattern.matcher(fieldText);

        boolean result = mymatcher.matches();

        return result;
    }
}
