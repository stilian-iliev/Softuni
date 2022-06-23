package bg.softuni.musicdb.validation;

import bg.softuni.musicdb.validation.impl.UniqueEmailValidation;
import bg.softuni.musicdb.validation.impl.ValidArtists;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ValidArtists.class)
public @interface ContainsArtist {


    String message() default "Invalid Artist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
