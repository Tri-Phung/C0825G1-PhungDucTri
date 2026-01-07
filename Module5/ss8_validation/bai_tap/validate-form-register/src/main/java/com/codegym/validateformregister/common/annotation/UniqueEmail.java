package com.codegym.validateformregister.common.annotation;

import com.codegym.validateformregister.common.validator.UniqueEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEmailValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
    String message() default "Email này đã tồn tại. Vui lòng dùng email khác";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
