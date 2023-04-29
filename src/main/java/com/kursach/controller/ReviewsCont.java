package com.kursach.controller;

import com.kursach.models.Reviews;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewsCont extends Global {

    @GetMapping("/reviews")
    public String reviews(Model model) {
        AddAttributes(model);
        model.addAttribute("reviews", repoReviews.findAll());
        return "reviews";
    }

    @PostMapping("/reviews/add")
    public String reviewAdd(@RequestParam String text) {
        repoReviews.save(new Reviews(getUser().getUsername(), text, DateNow()));
        return "redirect:/reviews";
    }
}
