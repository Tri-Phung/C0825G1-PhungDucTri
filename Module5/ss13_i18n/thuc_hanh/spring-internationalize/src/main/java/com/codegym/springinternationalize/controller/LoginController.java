package com.codegym.springinternationalize.controller;

import com.codegym.springinternationalize.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLoginForm(@RequestParam(value = "lang", required = false, defaultValue = "en") String lang, Model model) {
        model.addAttribute("lang", lang);
        model.addAttribute("user", new User());
        return "login";
    }
    @PostMapping("/doLogin")
    public ModelAndView login(@ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView("/dashboard");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
