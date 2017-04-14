package com.imagestudio.form;


import com.imagestudio.validator.annotation.ConfirmingPassword;
import com.imagestudio.validator.annotation.UniqueEmail;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by alt on 08.04.17.
 */
@ConfirmingPassword(password = "password", confirmPassword = "confirmPassword")
public class SignupForm {
    @Email(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Некорректный email")
    @NotEmpty(message = "Поле не должно быть пустым")
    @UniqueEmail
    private String email;

    @Size(min = 3, max = 30, message = "Пароль должен быть от 3 до 30 символов")
    @NotEmpty(message = "Введите пароль")
    private String password;

    @Size(min = 3, max = 30, message = "Пароль должен быть от 3 до 30 символов")
    @NotEmpty(message = "Подтвердите пароль")
    private String confirmPassword;

    @Size(max = 50, message = "Максимальная длина - 50 символов")
    @NotEmpty(message = "Поле не должно быть пустым")
    private String firstName;

    @Size(max = 50, message = "Максимальная длина - 50 символов")
    @NotEmpty(message = "Поле не должно быть пустым")
    private String lastName;

    private String role;

    private boolean isPasswordGenerate;


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean getIsPasswordGenerate() {
        return isPasswordGenerate;
    }

    public void setIsPasswordGenerate(boolean isPasswordGenerate) {
        this.isPasswordGenerate = isPasswordGenerate;
    }
}
