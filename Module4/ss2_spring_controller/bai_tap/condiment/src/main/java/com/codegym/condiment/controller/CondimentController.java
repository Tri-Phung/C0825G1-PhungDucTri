package com.codegym.condiment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CondimentController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/save")
    public ModelAndView save(@RequestParam(value="condiment", required = false, defaultValue = "") String[] condiments) {
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("condiments", condiments);
        return modelAndView;
    }
}
