package bg.softuni.linkedout.validation.impl;


import bg.softuni.linkedout.repositories.CompanyRepository;
import bg.softuni.linkedout.validation.UniqueName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidation implements ConstraintValidator<UniqueName, String> {
    private CompanyRepository companyRepository;

    public UniqueNameValidation(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void initialize(UniqueName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return companyRepository.findByName(value).isEmpty();
    }
}
