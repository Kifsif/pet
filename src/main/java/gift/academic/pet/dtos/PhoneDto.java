package gift.academic.pet.dtos;


import gift.academic.pet.validation.constraints.PhoneConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PhoneDto {
    @NotNull
    @NotBlank
    @PhoneConstraint
    String phone;

    public PhoneDto(String phone) {
        this.phone = phone;
    }

    public @NotNull @NotBlank String getPhone() {
        return phone;
    }
}
