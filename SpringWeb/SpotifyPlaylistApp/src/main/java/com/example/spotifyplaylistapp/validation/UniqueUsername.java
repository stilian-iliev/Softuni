package com.example.spotifyplaylistapp.validation;

import com.example.spotifyplaylistapp.validation.impl.UniqueUsernameValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueUsernameValidation.class)
public @interface UniqueUsername {

    String message() default "Invalid Username";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}