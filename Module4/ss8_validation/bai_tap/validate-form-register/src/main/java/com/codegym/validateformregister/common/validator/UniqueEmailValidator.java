package com.codegym.validateformregister.common.validator;

import com.codegym.validateformregister.common.annotation.UniqueEmail;
import com.codegym.validateformregister.entity.User;
import com.codegym.validateformregister.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (userRepository == null) {
            return true;
        }

        if (email == null || email.isEmpty()) {
            return true;
        }

        return !userRepository.existsByEmail(email);
    }

}
