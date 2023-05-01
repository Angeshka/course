package com.kursach.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class itemDocsCont extends Global {

    @GetMapping("/itemDocs/{id}")
    public String itemDocs(Model model, @PathVariable Long id) {
        AddAttributes(model);
        model.addAttribute("trip", repoTrip.getById(id));
        model.addAttribute("docs",repoDocs.findByIdTrip(id));
        return "itemDocs";
    }
}
