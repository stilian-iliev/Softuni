package com.example.spotifyplaylistapp.validation.impl;

import com.example.spotifyplaylistapp.models.enums.StyleEnum;
import com.example.spotifyplaylistapp.repositories.StyleRepository;
import com.example.spotifyplaylistapp.validation.ValidStyle;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidStyleValidation implements ConstraintValidator<ValidStyle, StyleEnum> {
    private final StyleRepository styleRepository;

    public ValidStyleValidation(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }


    @Override
    public void initialize(ValidStyle constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(StyleEnum value, ConstraintValidatorContext context) {
        return styleRepository.existsByName(value);
    }
}
