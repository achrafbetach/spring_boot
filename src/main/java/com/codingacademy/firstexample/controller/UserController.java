package com.codingacademy.firstexample.controller;


import com.codingacademy.firstexample.model.User;
import com.codingacademy.firstexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login.html";
    }

    @GetMapping("/register")
    public String showRegistrationForm(User user) {
        return "signup.html";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "signup.html";
        }

        userService.registerUser(user);
        return "redirect:/login"; // Redirect to a login page
    }
}
