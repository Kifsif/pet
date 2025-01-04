package gift.academic.pet.models;

import gift.academic.pet.dtos.UserRegistrationDto;
import gift.academic.pet.services.sanitizers.PhoneSanitizer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_account")

public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @NotNull
    @Column(unique=true)
    String phone;

    @NotNull
    @Column(unique=true)
    String email;

    @NotNull
    String name;

    @NotNull
    String password;

    @NotNull
    Boolean confirm;

    @CreationTimestamp
    private Instant registrationDate;

    String token;

    public User() {
    }

    public User(String phone,
                String email,
                String name,
                String password,
                Boolean confirm
    ) {
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.password = password;
        this.confirm = confirm;
    }


    // Только для целей отладки.
    public User(String phone,
                String email,
                String name,
                String password,
                Boolean confirm,
                String token) {
        this(phone, email, name, password, confirm);
        this.token = token;
    }

    public User(UserRegistrationDto userRegistrationDto) {
        this(userRegistrationDto.getPhone(),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getName(),
                userRegistrationDto.getPassword(),
                Boolean.valueOf(userRegistrationDto.getConfirm()));
    }

    public Integer getId() {
        return id;
    }

    public Instant getRegistrationDate() {
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

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public @NotNull Boolean getConfirm() {
        return confirm;
    }

    public void setConfirm(@NotNull Boolean confirm) {
        this.confirm = confirm;
    }

    public void setRegistrationDate(Instant registrationDate) {
        this.registrationDate = registrationDate;
    }
}
