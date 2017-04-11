package com.imagestudio.controller;

import com.imagestudio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by alt on 08.04.17.
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String usersPage(Model model) {
        model.addAttribute("users", userService.findAll());

        return "users";
    }
}
