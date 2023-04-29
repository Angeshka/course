package com.kursach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutCont extends Global {

    @GetMapping("/about")
    public String about(Model model) {
        AddAttributes(model);
        return "about";
    }

    @GetMapping("/ad")
    public String ad(Model model) {
        AddAttributes(model);
        return "ad";
    }

}
