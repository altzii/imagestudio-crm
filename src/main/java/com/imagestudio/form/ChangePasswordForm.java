package com.imagestudio.form;

import com.imagestudio.validator.annotation.ConfirmingPassword;
import com.imagestudio.validator.annotation.PasswordCorrect;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

/**
 * Created by Rus on 11.04.2017.
 */
public class ChangePasswordForm {
    @Size(min = 3, max = 30, message = "Пароль должен быть от 3 до 30 символов")
    @NotEmpty(message = "Введите пароль")
    @PasswordCorrect
    private String oldPassword;
    @Size(min = 3, max = 30, message = "Пароль должен быть от 3 до 30 символов")
    @NotEmpty(message = "Введите пароль")
    private String newPassword;

    @Size(min = 3, max = 30, message = "Пароль должен быть от 3 до 30 символов")
    @NotEmpty(message = "Подтвердите пароль")
    private String confirmPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    @AssertTrue(message="пароли не совпадают")
    public boolean isPasswordsEquals() {
        if (newPassword != null)
            return this.newPassword.equals(confirmPassword);
        else return false;
    }
}
