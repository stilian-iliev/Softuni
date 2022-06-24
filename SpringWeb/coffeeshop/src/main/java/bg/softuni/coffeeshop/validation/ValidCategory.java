package bg.softuni.coffeeshop.validation;

import bg.softuni.coffeeshop.validation.impl.ValidCategoryImplementation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ValidCategoryImplementation.class)
public @interface ValidCategory {
    String message() default "No such category";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
