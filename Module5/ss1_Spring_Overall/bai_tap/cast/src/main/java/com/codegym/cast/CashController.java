package com.codegym.cast;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CashController {
    @GetMapping("")
    public ModelAndView showIndex() {
        return new ModelAndView("index");
    }

    @PostMapping("/convert")
    public ModelAndView convert(@RequestParam("rate") double rate, @RequestParam("usd") double usd) {
        double vnd = usd * rate;
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("usd", usd);
        modelAndView.addObject("rate", rate);
        modelAndView.addObject("vnd", vnd);
        return modelAndView;
    }
}
