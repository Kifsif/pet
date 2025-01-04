package gift.academic.pet.dtos;

import jakarta.validation.constraints.Email;

public class LoginDto {
    @Email
    String email;

    String password;
}
