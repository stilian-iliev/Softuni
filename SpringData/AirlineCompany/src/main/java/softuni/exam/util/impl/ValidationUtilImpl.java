package softuni.exam.util.impl;

import softuni.exam.util.ValidationUtil;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidationUtilImpl implements ValidationUtil {
    private final Validator validator;

    public ValidationUtilImpl() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator =  factory.getValidator();
    }

    @Override
    public <E> boolean isValid(E entity) {
        return validator.validate(entity).isEmpty();
    }
}
