package technobel.bart.sandwichspring.models.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserDTO {
    private Long id;

    private String email;

    private String password;

    private String role;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;
}
