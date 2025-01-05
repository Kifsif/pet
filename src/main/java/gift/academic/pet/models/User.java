package gift.academic.pet.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gift.academic.pet.validation.constraints.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "user_account")
@PasswordMatchConstraint
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @NotBlank
    @Column(unique=true)
    @PhoneConstraint
    private String phone;

    @NotNull
    @NotBlank
    @Column(unique=true)
    @Email(message="Format is wrong.")
    private String email;

    @NotNull
    @NotBlank
    @NameConstraint
    private String name;

    @NotNull
    @NotBlank
    @PasswordConstraint
    @Transient
    private String password;

    @NotNull
    @NotBlank
    @Transient
    private String password_confirmation;

    @NotNull
    @NotBlank
    @ConfirmConstraint
    String confirm;

    @CreationTimestamp
    private LocalDate registrationDate;

    private String token;

    public User() {
    }

    public User(String phone,
                String email,
                String name,
                String password,
                String password_confirmation,
                String confirm
    ) {
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.password = password;
        this.password_confirmation=password_confirmation;
        this.confirm = confirm;
    }


    // Только для целей отладки.
    public User(String phone,
                String email,
                String name,
                String password,
                String password_confirmation,
                String confirm,
                String token) {
        this(phone, email, name, password, password_confirmation, confirm);
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getOrdersCount() {
        return 1;
    }

    public int getPetsCount() {
        return 1;
    }

    @JsonIgnore
    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    @JsonIgnore
    public @NotNull String getConfirm() {
        return confirm;
    }

    public void setConfirm(@NotNull String confirm) {
        this.confirm = confirm;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @JsonIgnore
    public String getPasswordConfirmation() {
        return password_confirmation;
    }

    public void setPassword_confirmation(@NotNull @NotBlank String password_confirmation) {
        this.password_confirmation = password_confirmation;
    }
}
