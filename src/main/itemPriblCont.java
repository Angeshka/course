package com.kursach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class itemPriblCont extends Global {


    @GetMapping("/itemPribl/{id}")
    public String itemPribl(Model model, @PathVariable Long id) {
        AddAttributes(model);
        model.addAttribute("trip",repoTrip.getById(id));
        model.addAttribute("pribl",repoPribl.findByIdTrip(id));
        return "itemPribl";
    }

}
