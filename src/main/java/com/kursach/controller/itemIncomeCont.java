package com.kursach.controller;

import com.kursach.models.Income;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class itemIncomeCont extends Global {

    @GetMapping("/itemIncome/{id}")
    public String itemIncome(Model model, @PathVariable Long id) {
        AddAttributes(model);
        Income Income = repoIncome.findByIdTrip(id);
        model.addAttribute("trip", repoTrip.getById(id));
        model.addAttribute("income", Integer.parseInt(Income.getPrice()) * Integer.parseInt(Income.getQuantity()));
        return "itemIncome";
    }
}
