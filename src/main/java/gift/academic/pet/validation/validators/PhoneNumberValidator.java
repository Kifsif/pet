package gift.academic.pet.validation.validators;

import gift.academic.pet.validation.constraints.PhoneConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneNumberValidator implements ConstraintValidator<PhoneConstraint, String> {
    @Override
    public void initialize(PhoneConstraint constraint) {
    }

    @Override
    public boolean isValid(String fieldText,
                           ConstraintValidatorContext cxt) {

        Pattern mypattern = Pattern.compile("^\\+?\\d+$");
        Matcher mymatcher= mypattern.matcher(fieldText);

        boolean result = mymatcher.matches();

        return result;
    }
}
