package technobel.bart.sandwichspring.models.form.user;

import jakarta.validation.constraints.*;
import lombok.Data;
import technobel.bart.sandwichspring.validation.constraints.EmailNotTaken;
import technobel.bart.sandwichspring.validation.constraints.InPast;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
public class RegisterForm {
    @NotBlank
    @Email
    @EmailNotTaken
    private String email;
    @NotBlank
    @Size(min=4)
    private String password;
    @NotBlank
    private String confirm;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    @InPast(amount = 1, unit = ChronoUnit.YEARS)
    private LocalDate birthDate;
}
