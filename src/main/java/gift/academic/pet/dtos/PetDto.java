package gift.academic.pet.dtos;

import gift.academic.pet.interfaces.PasswordInterface;
import gift.academic.pet.validation.constraints.ConfirmConstraint;
import gift.academic.pet.validation.constraints.PasswordConstraint;
import gift.academic.pet.validation.constraints.PasswordMatchConstraint;
import gift.academic.pet.validation.constraints.PhoneConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;



public class PetDto {

    @NotNull
    private MultipartFile photo1;


    private MultipartFile photo2;


    private MultipartFile photo3;

    @NotNull
    @NotBlank
    private String mark;

    @NotNull
    @NotBlank
    private String description;

    ///////////////////////////////////////////////////////////////////


    public @NotNull MultipartFile getPhoto1() {
        return photo1;
    }

    public void setPhoto1(@NotNull MultipartFile photo1) {
        this.photo1 = photo1;
    }

    public MultipartFile getPhoto2() {
        return photo2;
    }

    public void setPhoto2(MultipartFile photo2) {
        this.photo2 = photo2;
    }

    public MultipartFile getPhoto3() {
        return photo3;
    }

    public void setPhoto3(MultipartFile photo3) {
        this.photo3 = photo3;
    }

    public @NotNull @NotBlank String getMark() {
        return mark;
    }

    public void setMark(@NotNull @NotBlank String mark) {
        this.mark = mark;
    }

    public @NotNull @NotBlank String getDescription() {
        return description;
    }

    public void setDescription(@NotNull @NotBlank String description) {
        this.description = description;
    }
}
