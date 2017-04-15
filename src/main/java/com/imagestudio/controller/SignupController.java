package com.imagestudio.controller;

import com.imagestudio.form.SignupForm;
import com.imagestudio.model.SignupConfirmation;
import com.imagestudio.service.SignupConfirmationService;
import com.imagestudio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by alt on 15.04.17.
 */
@Controller
public class SignupController {
    @Autowired
    UserService userService;

    @Autowired
    SignupConfirmationService signupConfirmationService;

    @GetMapping(value = "/admin/signup")
    public String getSignup(Model model) {
        model.addAttribute("signup_form", new SignupForm());

        return "signup";
    }

    @PostMapping(value = "/admin/signup")
    public String signup(@ModelAttribute("signup_form") @Valid SignupForm signupForm,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "signup";
        }

        userService.signupUser(signupForm);

        return "redirect:/";
    }

    @GetMapping(value = "/confirm_signup")
    public String confirmSignup(@RequestParam(value = "code", required = true) String code, ModelMap modelMap) {
        SignupConfirmation signupConfirmation = signupConfirmationService.findByCode(code);

        if (signupConfirmation != null) {
            userService.confirmSignup(signupConfirmation);

            modelMap.put("message", "Спасибо за подтверждение регистрации!");

        } else {
            modelMap.put("message", "Неверный код подтверждения регистрации!");
        }
        return "signup_confirm";
    }
}
