package gift.academic.pet.dtos;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmailDto {
    @NotNull
    @NotBlank
    @Email(message="Format is wrong.")
    String email;

    public EmailDto(String email) {
        this.email = email;
    }

    public @NotNull @NotBlank String getEmail() {
        return email;
    }
}
