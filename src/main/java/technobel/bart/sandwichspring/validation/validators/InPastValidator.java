package technobel.bart.sandwichspring.validation.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import technobel.bart.sandwichspring.validation.constraints.InPast;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

public class InPastValidator implements ConstraintValidator<InPast, Temporal> {

    private InPast annotation;

    @Override
    public void initialize(InPast constraintAnnotation) {
        annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Temporal value, ConstraintValidatorContext context) {


        context.disableDefaultConstraintViolation();

        if(
                (value instanceof LocalDate && checkLocalDateValid((LocalDate)value) ) ||
                        (value instanceof LocalDateTime && checkLocalDateTime((LocalDateTime)value) )
        ){
            context.buildConstraintViolationWithTemplate("Sould be " + annotation.amount() + " days in the past" )
                    .addConstraintViolation();
            return false;
        }
        else if( !(value instanceof LocalDate) && !(value instanceof LocalDateTime)  ) {
            throw  new IllegalArgumentException();
        }
        else
            return false;


    }

    private boolean checkLocalDateValid(LocalDate localDate){
        return LocalDate.now()
                .minus( annotation.amount(), annotation.unit() )
                .isAfter( localDate );
    }

    private boolean checkLocalDateTime(LocalDateTime localDateTime){
        return LocalDateTime.now()
                .minus( annotation.amount(), annotation.unit() )
                .isAfter( localDateTime );
    }
}
