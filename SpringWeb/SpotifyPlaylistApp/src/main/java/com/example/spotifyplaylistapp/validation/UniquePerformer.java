package com.example.spotifyplaylistapp.validation;

import com.example.spotifyplaylistapp.validation.impl.UniquePerformerValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniquePerformerValidation.class)
public @interface UniquePerformer {

    String message() default "Invalid Performer";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}