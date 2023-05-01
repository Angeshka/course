package com.kursach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemCostsCont extends Global {


    @GetMapping("/itemZatraty/{id}")
    public String itemCosts(Model model, @PathVariable Long id) {
        AddAttributes(model);
        model.addAttribute("trip",repoTrip.getById(id));
        model.addAttribute("costs", repoCosts.findByIdTrip(id));
        return "itemCosts";
    }


}
