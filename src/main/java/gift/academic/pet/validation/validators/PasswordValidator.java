package gift.academic.pet.validation.validators;

import gift.academic.pet.validation.constraints.PasswordConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {
    @Override
    public void initialize(PasswordConstraint constraint) {
    }

    @Override
    public boolean isValid(String fieldText,
                           ConstraintValidatorContext cxt) {

        Pattern mypattern = Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z]).{7,}$");
        Matcher mymatcher= mypattern.matcher(fieldText);

        boolean result = mymatcher.matches();

        return result;
    }
}
