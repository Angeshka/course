package com.kursach.controller;

import com.kursach.models.Users;
import com.kursach.models.enums.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfilesCont extends Global {


    @GetMapping("/profiles")
    public String profile(Model model) {
        AddAttributes(model);
        model.addAttribute("users", repoUsers.findAll());
        model.addAttribute("roles", Role.values());
        return "profiles";
    }

    @PostMapping("/profiles/{id}/edit")
    public String userEdit(@PathVariable(value = "id") Long id, @RequestParam Role role) {
        System.out.println(1);
        Users users = repoUsers.getById(id);
        users.setRole(role);
        repoUsers.save(users);
        return "redirect:/profiles";
    }


}

