package bg.softuni.coffeeshop.validation.impl;

import bg.softuni.coffeeshop.repositories.CategoryRepository;
import bg.softuni.coffeeshop.validation.UniqueUsername;
import bg.softuni.coffeeshop.validation.ValidCategory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Valid;
import java.util.UUID;

public class ValidCategoryImplementation implements ConstraintValidator<ValidCategory, UUID> {
    private final CategoryRepository categoryRepository;

    public ValidCategoryImplementation(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initialize(ValidCategory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UUID value, ConstraintValidatorContext context) {
        if (value == null) return false;
        return categoryRepository.findById(value).isPresent();
    }
}
