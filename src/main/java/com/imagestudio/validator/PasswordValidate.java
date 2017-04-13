package com.imagestudio.validator;

import com.imagestudio.model.User;
import com.imagestudio.security.CustomUserDetails;
import com.imagestudio.service.UserService;
import com.imagestudio.validator.annotation.PasswordCorrect;
import com.imagestudio.validator.annotation.UniqueEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Rus on 11.04.2017.
 */
@Component
public class PasswordValidate implements ConstraintValidator<PasswordCorrect, String> {
    @Autowired
    BCrypt bCrypt;
    @Override
    public void initialize(PasswordCorrect passwordCorrect) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if (password == null) {
            return false;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        return bCrypt.checkpw(password, customUserDetails.getUser().getPassword());
    }
}