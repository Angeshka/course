package com.kursach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemCont extends Global {

    @GetMapping("/item/{id}")
    public String item(Model model, @PathVariable Long id) {
        AddAttributes(model);
        model.addAttribute("trip", repoTrip.getById(id));
        return "item";
    }

}
