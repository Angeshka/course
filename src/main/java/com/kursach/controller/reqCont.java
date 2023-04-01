package com.kursach.controller;

import com.kursach.models.Users;
import com.kursach.models.enums.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class reqCont extends Global {


    @GetMapping("/reg")
    public String reg(Model model) {
        AddAttributes(model);
        return "reg";
    }

    @PostMapping("/reg")
    public String regUser(Model model, @RequestParam String username, @RequestParam String password) {
        repoUsers.save(new Users(username, password, Role.Пользователь));
        return "redirect:/login";
    }

}
