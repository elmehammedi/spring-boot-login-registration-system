package com.example.demo.controller.util;

import com.example.demo.service.dto.UserDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches a) {
        ConstraintValidator.super.initialize(a);
    }

    @Override
    public boolean isValid(Object t, ConstraintValidatorContext cvc) {
        UserDto user = (UserDto) t;
        return user.getPassword().equals(user.getMatchingPassword());
    }

}
