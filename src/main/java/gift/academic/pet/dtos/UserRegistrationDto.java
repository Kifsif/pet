package gift.academic.pet.dtos;

import gift.academic.pet.validation.constraints.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



@PasswordMatchConstraint
public class UserRegistrationDto {
    @NotNull
    @NotBlank
    @PhoneConstraint
    String phone;

    @NotNull
    @NotBlank
    @Email(message="Format is wrong.")
    String email;

    @NotNull
    @NotBlank
    @NameConstraint
    String name;

    @NotNull
    @NotBlank
    @PasswordConstraint
    String password;

    @NotNull
    @NotBlank
    String password_confirmation;

    @NotNull
    @NotBlank
    @ConfirmConstraint
    String confirm;

    public UserRegistrationDto(String phone,
                               String email,
                               String name,
                               String password,
                               String password_confirmation,
                               String confirm) {
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.password = password;
        this.password_confirmation = password_confirmation;
        this.confirm = confirm;
    }

    public @NotBlank String getPhone() {
        return phone;
    }

    public @NotBlank String getEmail() {
        return email;
    }

    public @NotBlank String getName() {
        return name;
    }

    public @NotBlank String getPassword() {
        return password;
    }

    public @NotBlank String getConfirm() {
        return confirm;
    }

    public @NotNull @NotBlank String getPasswordConfirmation() {
        return password_confirmation;
    }
}
