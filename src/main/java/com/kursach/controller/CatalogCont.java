package com.kursach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogCont extends Global {

    @GetMapping("/catalog-page")
    public String catalog(Model model) {
        AddAttributes(model);
        model.addAttribute("trips",repoTrip.findAll());// добавляет атрибут "trips" в объект model и присваивает ему значение,
        // полученное при вызове метода findAll() репозитория repoTrip
        return "catalog-page";
    }

}
