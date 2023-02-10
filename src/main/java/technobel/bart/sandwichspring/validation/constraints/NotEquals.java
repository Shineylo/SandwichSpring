package technobel.bart.sandwichspring.validation.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import technobel.bart.sandwichspring.validation.validators.NotEqualsValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotEqualsValidator.class)
public @interface NotEquals {

    double value() default 0;

    String message() default "value should not be 0";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
