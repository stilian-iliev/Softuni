package bg.softuni.battleships.validation;

import bg.softuni.battleships.validation.impl.UniqueNameValidation;
import bg.softuni.battleships.validation.impl.UniqueUsernameValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueNameValidation.class)
public @interface UniqueName {

    String message() default "Invalid Username";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
