package com.imagestudio.controller;

import com.imagestudio.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by alt on 07.04.17.
 */
@Controller
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/roles")
    public String rolesPage(Model model) {
        model.addAttribute("roles", roleService.findAll());

        return "roles";
    }
}
