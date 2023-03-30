package com.kursach.controller;

import com.kursach.models.Dohod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class itemDohodCont extends Global {

    @GetMapping("/itemDohod/{id}")
    public String itemDohod(Model model, @PathVariable Long id) {
        AddAttributes(model);
        Dohod dohod = repoDohod.findByIdTrip(id);
        model.addAttribute("trip", repoTrip.getById(id));
        model.addAttribute("dohod", Integer.parseInt(dohod.getPrice()) * Integer.parseInt(dohod.getQuantity()));
        return "itemDohod";
    }
}
