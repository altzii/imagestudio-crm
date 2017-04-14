package com.imagestudio.validator;


import com.imagestudio.form.SignupForm;
import com.imagestudio.validator.annotation.ConfirmingPassword;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by alt on 06/05/2016.
 */
@Component
public class ConfirmingPasswordValidator implements ConstraintValidator<ConfirmingPassword, SignupForm> {
    private String password;
    private String confirmPassword;
    private String message;

    public void initialize(ConfirmingPassword confirmingPassword) {
        setPassword(confirmingPassword.password());
        setConfirmPassword(confirmingPassword.confirmPassword());
        setMessage(confirmingPassword.message());
    }

    public boolean isValid(SignupForm o, ConstraintValidatorContext constraintValidatorContext) {
        if (o.getIsPasswordGenerate()) {
            return true;
        } else {

            try {
                Object fieldObject = o.getPassword();
                Object equalsToObject = o.getConfirmPassword();

                if (fieldObject == null && equalsToObject == null) {
                    return true;
                }

                boolean matches = (fieldObject != null)
                        && fieldObject.equals(equalsToObject);

                if (!matches) {
                    String msg = getMessage();
                    if (this.message == null
                            || "".equals(getMessage())
                            || ConfirmingPassword.MESSAGE.equals(getMessage())) {
                        msg = "Введенные пароли не совпадают";
                    }
                    constraintValidatorContext.disableDefaultConstraintViolation();
                    constraintValidatorContext.buildConstraintViolationWithTemplate(msg)
                            .addPropertyNode("confirmPassword").addConstraintViolation();
                }

                return matches;
            } catch (final Exception ignored) {
            }
            return false;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
