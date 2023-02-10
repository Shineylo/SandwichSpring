package technobel.bart.sandwichspring.models.form.user;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterForm {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min=4)
    private String password;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    @Past
    private LocalDate birthDate;
}
