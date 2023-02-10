package technobel.bart.sandwichspring.validation.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import technobel.bart.sandwichspring.service.UserService;
import technobel.bart.sandwichspring.validation.constraints.EmailNotTaken;
import technobel.bart.sandwichspring.validation.constraints.NotEquals;

@Component
public class EmailNotTakenValidator implements ConstraintValidator<EmailNotTaken, String> {

    private final UserService userService;

    public EmailNotTakenValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return userService.checkEmailNotTaken( email );
    }
}