package com.kedar.moviecollection.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kedar.moviecollection.entity.User;
import com.kedar.moviecollection.service.AppService;

@Controller
public class LoginController {

    @Autowired
    private AppService appService;

    @GetMapping("/")
    public String home() {
        return "Home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        user.setEnabled(true);
        appService.registerUser(user);
        return "login";
    }
}
