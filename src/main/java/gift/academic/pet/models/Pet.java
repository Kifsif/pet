package gift.academic.pet.models;

import gift.academic.pet.validation.constraints.ConfirmConstraint;
import gift.academic.pet.validation.constraints.PasswordConstraint;
import gift.academic.pet.validation.constraints.PhoneConstraint;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    @PhoneConstraint
    private String phone;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Transient
    @PasswordConstraint
    private String password;

    @NotNull
    @NotBlank
    @Transient
    private String password_confirmation;

    @NotNull
    @NotBlank
    @ConfirmConstraint
    @Transient
    private String confirm;

    @NotNull
    @NotBlank
    private String kind;

    @NotNull
    @NotBlank
    private String photo1;

    private String photo2;

    private String photo3;

    @NotNull
    @NotBlank
    private String mark;

    @NotNull
    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String description;
}
