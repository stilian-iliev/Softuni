package bg.softuni.mobilele.models.validation;

import bg.softuni.mobilele.models.validation.impl.MatchingFieldsValidation;
import bg.softuni.mobilele.models.validation.impl.UniqueUsernameValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = MatchingFieldsValidation.class)
public @interface MatchingFields {
    String first();
    String second();
    String message() default "Fields not matching";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
