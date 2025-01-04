package gift.academic.pet.validation.validators;

import gift.academic.pet.validation.constraints.NameConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator implements ConstraintValidator<NameConstraint, String> {
    @Override
    public void initialize(NameConstraint constraint) {
    }

    @Override
    public boolean isValid(String fieldText,
                           ConstraintValidatorContext cxt) {

        Pattern mypattern = Pattern.compile("^[а-яё\\-\\s]+$", Pattern.CASE_INSENSITIVE
                | Pattern.UNICODE_CHARACTER_CLASS);
        Matcher mymatcher= mypattern.matcher(fieldText.trim());

        boolean result = mymatcher.matches();

        return result;
    }
}
