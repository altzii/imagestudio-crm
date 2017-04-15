package com.imagestudio.controller;

import com.imagestudio.form.SignupForm;
import com.imagestudio.service.RoleService;
import com.imagestudio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by alt on 11.04.17.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping(value = "/signup")
    public String getSignup(Model model) {
        model.addAttribute("signup_form", new SignupForm());

        return "signup";
    }

    @PostMapping(value = "/signup")
    public String signup(@ModelAttribute("signup_form") @Valid SignupForm signupForm,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "signup";
        }

        userService.signupUser(signupForm);

        return "redirect:/";
    }

    @GetMapping("/users")
    public String usersPage(Model model) {
        model.addAttribute("users", userService.findAll());

        return "users";
    }

    @GetMapping("/roles")
    public String rolesPage(Model model) {
        model.addAttribute("roles", roleService.findAll());

        return "roles";
    }
}
