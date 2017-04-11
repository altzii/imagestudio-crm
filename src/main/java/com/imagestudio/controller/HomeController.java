package com.imagestudio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by alt on 11.04.17.
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage() {
        return "redirect:/user/profile";
    }
}
