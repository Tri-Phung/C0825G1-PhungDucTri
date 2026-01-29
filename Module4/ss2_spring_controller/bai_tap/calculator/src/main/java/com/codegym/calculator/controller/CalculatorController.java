package com.codegym.calculator.controller;

import com.codegym.calculator.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calculator")
    public ModelAndView calculate(@RequestParam("number1") double num1, @RequestParam("number2") double num2, @RequestParam("operation") String operation) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("number1", num1);
        modelAndView.addObject("number2", num2);
        double result;
        String operationName;
        switch (operation) {
            case "add":
                operationName = "Addition";
                result = calculatorService.add(num1, num2);
                break;
            case "subtract":
                operationName = "Subtraction";
                result = calculatorService.subtract(num1, num2);
                break;
            case "multiply":
                operationName = "Multiplication";
                result = calculatorService.multiply(num1, num2);
                break;
            case "divide":
                operationName = "Division";
                if (num2 == 0) {
                    modelAndView.addObject("errorMessage", "Cannot divide by zero!");
                    return modelAndView;
                }
                result = calculatorService.divide(num1, num2);
                break;
            default:
                modelAndView.addObject("errorMessage", "Invalid operation!");
                return modelAndView;
        }

        modelAndView.addObject("result", result);
        modelAndView.addObject("operation", operationName);
        return modelAndView;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ModelAndView handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String causeMessage = ex.getCause().getMessage();
        ModelAndView modelAndView = new ModelAndView("index");
        if (causeMessage.contains("empty")) {
            modelAndView.addObject("errorMessage", "Numbers are required!");
        }
        else {
            modelAndView.addObject("errorMessage", "Please enter valid numbers!");
        }
        return modelAndView;
    }
}
