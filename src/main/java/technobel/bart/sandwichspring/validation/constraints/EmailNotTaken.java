package technobel.bart.sandwichspring.validation.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import technobel.bart.sandwichspring.validation.validators.EmailNotTakenValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailNotTakenValidator.class)
public @interface EmailNotTaken {
    String message() default "email already taken";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
