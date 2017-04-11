package com.imagestudio.controller;

import com.imagestudio.form.SignupForm;
import com.imagestudio.service.RoleService;
import com.imagestudio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by alt on 08.04.17.
 */
@Controller
public class SignupController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getSignup(Model model) {
        model.addAttribute("signup_form", new SignupForm());

        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@ModelAttribute("signup_form") @Valid SignupForm signupForm, BindingResult result) {
        if (result.hasErrors()) {
            return "signup";
        }

        userService.signupUser(signupForm);

        return "redirect:/";
    }
}