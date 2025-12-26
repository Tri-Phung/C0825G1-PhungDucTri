package com.codegym.cast;

import com.codegym.cast.exception.InvalidInputException;
import com.codegym.cast.service.CashService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView convert(@RequestParam("rate") String rate, @RequestParam("usd") String usd) {
        if (usd == null || usd.trim().isEmpty()) {
            throw new InvalidInputException("Please enter a valid USD amount!");
        }
        double usdAmount;
        try {
            usdAmount = Double.parseDouble(usd.trim());
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter a valid USD amount");
        }

        if (usdAmount < 0) {
            throw new InvalidInputException("Please enter a positive USD amount");
        }

        double rateValue = Double.parseDouble(rate);
        double vnd = cashService.convert(usdAmount, rateValue);
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("rate", rateValue);
        modelAndView.addObject("usd", usdAmount);
        modelAndView.addObject("vnd", vnd);
        return modelAndView;
    }
    @ExceptionHandler(InvalidInputException.class)
    public ModelAndView handleInvalidInputException(InvalidInputException e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", e.getMessage());
        return modelAndView;
    }
}
