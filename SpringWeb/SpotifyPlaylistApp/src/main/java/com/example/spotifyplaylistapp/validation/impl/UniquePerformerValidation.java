package com.example.spotifyplaylistapp.validation.impl;

import com.example.spotifyplaylistapp.repositories.SongRepository;
import com.example.spotifyplaylistapp.validation.UniquePerformer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePerformerValidation implements ConstraintValidator<UniquePerformer, String> {
    private final SongRepository songRepository;

    public UniquePerformerValidation(SongRepository songRepository) {
        this.songRepository = songRepository;
    }


    @Override
    public void initialize(UniquePerformer constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !songRepository.existsByPerformer(value);
    }
}
