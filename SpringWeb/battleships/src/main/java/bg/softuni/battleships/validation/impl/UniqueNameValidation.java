package bg.softuni.battleships.validation.impl;

import bg.softuni.battleships.reposiotories.ShipRepository;
import bg.softuni.battleships.validation.UniqueName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidation implements ConstraintValidator<UniqueName, String> {
    private final ShipRepository shipRepository;

    public UniqueNameValidation(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    @Override
    public void initialize(UniqueName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return shipRepository.findByName(value).isEmpty();
    }
}
