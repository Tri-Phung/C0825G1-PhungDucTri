package com.codegym.calculator.controller;

import com.codegym.calculator.exception.DivisionByZeroException;
import com.codegym.calculator.exception.InvalidInputException;
import com.codegym.calculator.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calculator")
    public ModelAndView calculate(@RequestParam("number1") String number1, @RequestParam("number2") String number2, @RequestParam("operation") String operation) {
        double num1, num2;
        if (number1.isEmpty() || number2.isEmpty()) {
            throw new InvalidInputException("Please enter numbers!");
        }
        try {
            num1 = Double.parseDouble(String.valueOf(number1));
            num2 = Double.parseDouble(String.valueOf(number2));
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter valid numbers!");
        }
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
                if (num2 == 0) {
                    throw new DivisionByZeroException("Cannot divide by zero!");
                }
                operationName = "Division";
                result = calculatorService.divide(num1, num2);
                break;
            default:
                throw new InvalidInputException("Invalid operation!");
        }
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("number1", number1);
        modelAndView.addObject("number2", number2);
        modelAndView.addObject("result", result);
        modelAndView.addObject("operation", operationName);
        return modelAndView;
    }

    @ExceptionHandler(InvalidInputException.class)
    public ModelAndView handleInvalidInput(InvalidInputException ex) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(DivisionByZeroException.class)
    public ModelAndView handleDivisionByZero(DivisionByZeroException ex) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }
}
