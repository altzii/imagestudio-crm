package com.imagestudio.validator.annotation;

import com.imagestudio.validator.PasswordValidate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Rus on 11.04.2017.
 */
@Documented
@Constraint(validatedBy = PasswordValidate.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordCorrect {
    String message() default "неправильно введен пароль";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
