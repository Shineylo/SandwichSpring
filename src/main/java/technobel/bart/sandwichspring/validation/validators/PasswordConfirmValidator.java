package technobel.bart.sandwichspring.validation.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import technobel.bart.sandwichspring.models.form.user.RegisterForm;
import technobel.bart.sandwichspring.validation.constraints.PasswordConfirm;

public class PasswordConfirmValidator implements ConstraintValidator<PasswordConfirm, RegisterForm> {
    @Override
    public boolean isValid(RegisterForm value, ConstraintValidatorContext context) {
        return value.getPassword().equals(value.getConfirm());
    }
}
