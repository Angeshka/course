package com.kursach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class itemProfitCont extends Global {


    @GetMapping("/itemPribl/{id}")
    public String itemProfit(Model model, @PathVariable Long id) {
        AddAttributes(model);
        model.addAttribute("trip",repoTrip.getById(id));
        model.addAttribute("profit", repoProfit.findByIdTrip(id));
        return "itemProfit";
    }

}
