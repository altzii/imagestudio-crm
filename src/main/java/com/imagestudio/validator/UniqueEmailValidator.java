package com.imagestudio.validator;


import com.imagestudio.model.User;
import com.imagestudio.service.UserService;
import com.imagestudio.validator.annotation.UniqueEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by alt on 06/05/2016.
 */
@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    @Autowired
    UserService userService;

    @Override
    public void initialize(UniqueEmail uniqueEmail) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if (email == null) {
            return false;
        }

        User user = userService.findByEmail(email);
        return user == null;
    }
}
