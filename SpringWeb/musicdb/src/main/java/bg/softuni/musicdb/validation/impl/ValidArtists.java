package bg.softuni.musicdb.validation.impl;

import bg.softuni.musicdb.repositories.ArtistRepository;
import bg.softuni.musicdb.validation.ContainsArtist;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidArtists implements ConstraintValidator<ContainsArtist, String > {
    private final ArtistRepository artistRepository;

    public ValidArtists(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public void initialize(ContainsArtist constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return artistRepository.existsByName(value);
    }
}
