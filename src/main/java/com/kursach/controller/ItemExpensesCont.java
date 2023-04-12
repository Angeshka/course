package com.kursach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemExpensesCont extends Global {


    @GetMapping("/itemExpenses/{id}")
    public String itemExpenses(Model model, @PathVariable Long id) {
        AddAttributes(model);
        model.addAttribute("trip",repoTrip.getById(id));
        model.addAttribute("expenses", repoExpenses.findByIdTrip(id));
        return "itemExpenses";
    }


}
