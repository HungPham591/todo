package com.spring.todo.component.validator;

import com.spring.todo.common.annotation.PasswordMatches;
import com.spring.todo.model.inputs.AccountInput;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        AccountInput accountInput = (AccountInput) o;
        return accountInput.getPassword().equals(accountInput.getMatchingPassword());
    }
}
