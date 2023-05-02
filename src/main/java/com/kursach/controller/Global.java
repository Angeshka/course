package com.kursach.controller;

import com.kursach.models.Users;
import com.kursach.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;

public class Global {
    @Autowired
    protected RepoUsers repoUsers;//защищенное поле класса repoUsers, которое связывается с бином класса RepoUsers
    @Autowired
    protected RepoTrip repoTrip;
    @Autowired
    protected RepoDohod repoIncome;
    @Autowired
    protected RepoPribl repoProfit;
    @Autowired
    protected RepoZatraty repoCosts;
    @Autowired
    protected RepoDocs repoDocs;

    @Value("${upload.img}")//аннотация, которая позволяет Spring внедрять значение свойства приложения с именем upload.img в это поле.
    protected String uploadImg;//защищенное поле класса uploadImg, в которое будет внедрено значение свойства приложения upload.img.

    protected void AddAttributes(Model model) {

        model.addAttribute("role", getUserRole());
    }

    protected Users getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ((!(auth instanceof AnonymousAuthenticationToken)) && auth != null) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            return repoUsers.findByUsername(userDetail.getUsername());
        }
        return null;
    }

    protected String getUserRole() {
        Users user = getUser();
        if (user != null) return String.valueOf(user.getRole());
        return "NOT";
    }
}
