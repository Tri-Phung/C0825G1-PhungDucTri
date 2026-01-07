package com.codegym.validateformregister.common.validator;

import com.codegym.validateformregister.entity.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
    }
}
