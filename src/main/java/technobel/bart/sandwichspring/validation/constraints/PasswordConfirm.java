package technobel.bart.sandwichspring.validation.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import technobel.bart.sandwichspring.validation.validators.EmailNotTakenValidator;
import technobel.bart.sandwichspring.validation.validators.PasswordConfirmValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordConfirmValidator.class)
public @interface PasswordConfirm {

    String message() default "Passwords are not matching";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
