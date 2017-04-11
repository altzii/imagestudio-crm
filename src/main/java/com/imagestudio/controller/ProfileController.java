package com.imagestudio.controller;

import com.imagestudio.security.CustomUserDetails;
import com.imagestudio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by alt on 11.04.17.
 */
@Controller
public class ProfileController {
    @Autowired
    UserService userService;

    @GetMapping
    public String profilePage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();

        model.addAttribute("user", customUserDetails.getUser());

        return "profile";
    }
}
