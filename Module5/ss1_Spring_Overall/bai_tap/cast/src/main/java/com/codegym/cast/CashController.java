package com.codegym.cast;

import com.codegym.cast.service.CashService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CashController {
    CashService cashService;
    public CashController(CashService cashService) {
        this.cashService = cashService;
    }
    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @PostMapping("/convert")
    public ModelAndView convert(@RequestParam("usd") double usd) {
        if (usd <= 0) throw new IllegalArgumentException("Usd must be a positive number");
        double vnd = cashService.convert(usd);
        double rate = 26290.95;
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("rate", rate);
        modelAndView.addObject("usd", usd);
        modelAndView.addObject("vnd", vnd);
        return modelAndView;
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ModelAndView handleMethodArgument(MethodArgumentTypeMismatchException e) {
        ModelAndView modelAndView = new ModelAndView("error");
        String causeMessage = e.getCause().getMessage();
        if (causeMessage.contains("empty")) modelAndView.addObject("error", "Usd cannot be empty");
        else modelAndView.addObject("error", "Usd must be a number");
        return modelAndView;
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView handleIllegalArgumentException(IllegalArgumentException e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", e.getMessage());
        return modelAndView;
    }
}
