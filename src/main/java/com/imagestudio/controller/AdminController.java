package com.imagestudio.controller;

import com.imagestudio.service.RoleService;
import com.imagestudio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
