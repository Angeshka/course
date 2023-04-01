package com.kursach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginCont extends Global {

    @GetMapping("/")
    public String index1(Model model) {
        AddAttributes(model);
        return "login";
    }

    @GetMapping("/index")
    public String index2(Model model) {
        AddAttributes(model);
        return "login";
    }
    @GetMapping("/login")
    public String login(Model model) {
        AddAttributes(model);
        return "login";
    }

}
