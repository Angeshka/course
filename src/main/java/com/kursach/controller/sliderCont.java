package com.kursach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class sliderCont extends Global{

    @GetMapping("/slider")
    public String slider(Model model) {
        AddAttributes(model);
        return "slider";
    }

}
