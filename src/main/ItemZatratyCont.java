package com.kursach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemZatratyCont extends Global {


    @GetMapping("/itemZatraty/{id}")
    public String itemZatraty(Model model, @PathVariable Long id) {
        AddAttributes(model);
        model.addAttribute("trip",repoTrip.getById(id));
        model.addAttribute("zatraty",repoZatraty.findByIdTrip(id));
        return "itemZatraty";
    }


}
