package technobel.bart.sandwichspring.validation.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import technobel.bart.sandwichspring.validation.constraints.NotEquals;

public class NotEqualsValidator implements ConstraintValidator<NotEquals, Number> {

    private double notEqualValue;

    @Override
    public void initialize(NotEquals constraintAnnotation) {
        notEqualValue = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        return value.doubleValue() != notEqualValue;
    }
}
