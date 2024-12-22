package gift.academic.pet.validators;

import gift.academic.pet.exceptions.UnauthorizedException;
import gift.academic.pet.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserValidator {
    public void validateUser(User user, String token){
        if (!token.equals(user.getToken())) {
            throw new UnauthorizedException();
        }
    }
}
