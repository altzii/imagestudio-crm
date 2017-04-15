package com.imagestudio.controller;

import com.imagestudio.form.ChangePasswordForm;
import com.imagestudio.security.CustomUserDetails;
import com.imagestudio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by alt on 11.04.17.
 */
@Controller
@RequestMapping("/user")
public class ProfileController {
    @Autowired
    UserService userService;

    @GetMapping("/profile")
    public String profilePage(Model model,
                              @AuthenticationPrincipal CustomUserDetails userDetails) {
        model.addAttribute("user", userDetails.getUser());

        return "profile";
    }

    @GetMapping("/change/password")
    public String getChangePasswordPage(Model model) {
        model.addAttribute("change_password_form", new ChangePasswordForm());

        return "user_change_password";
    }

    @PostMapping("/change/password")
    public String changePassword(@ModelAttribute("change_password_form") @Valid ChangePasswordForm changePasswordForm,
                                 BindingResult result,
                                 @AuthenticationPrincipal CustomUserDetails userDetails) {

        if (!result.hasErrors()) {
            userService.changePassword(changePasswordForm, userDetails.getUser());

            return "redirect:/user/profile";
        }

        return "user_change_password";
    }
}
