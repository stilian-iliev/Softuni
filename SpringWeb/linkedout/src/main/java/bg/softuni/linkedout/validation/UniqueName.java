package bg.softuni.linkedout.validation;


import bg.softuni.linkedout.validation.impl.UniqueNameValidation;

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

    String message() default "Name is already taken.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
