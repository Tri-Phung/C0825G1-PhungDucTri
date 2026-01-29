package com.codegym.demo.controller;


import com.codegym.demo.common.Validate;
import com.codegym.demo.entity.Calculator;
import com.codegym.demo.service.CalculatorService;
import com.codegym.demo.service.ICalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "calculatorController", value = {"/calculator","/"})
public class CalculatorController extends HttpServlet {
    private final ICalculatorService calculatorService = new CalculatorService();
    String message;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/calculator/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputNum1 = req.getParameter("num1");
        String inputNum2 = req.getParameter("num2");
        String operation = req.getParameter("operation");
        if (inputNum1 == null || inputNum2 == null) return;
        if (Validate.notANumber(inputNum1) || Validate.notANumber(inputNum2)) {
            message = "Input must be a number";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/WEB-INF/calculator/index.jsp").forward(req, resp);
            return;
        }
        if (operation.equals("division") && !Validate.checkDivideByZero(Double.parseDouble(inputNum2))) {
            message = "Cannot divide by zero";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/WEB-INF/calculator/index.jsp").forward(req, resp);
        }
        Double num1 = Double.parseDouble(inputNum1);
        Double num2 = Double.parseDouble(inputNum2);
        Calculator expression = new Calculator(num1, num2, req.getParameter("operation"));
        calculatorService.save(expression);
        Double result = calculatorService.calculate();
        req.setAttribute("result", result);
        req.setAttribute("num1", calculatorService.getExpression().getNum1());
        req.setAttribute("num2", calculatorService.getExpression().getNum2());
        switch (operation) {
            case "addition":
                req.setAttribute("operation", "+");
                break;
            case "subtraction":
                req.setAttribute("operation", "-");
                break;
            case "multiplication":
                req.setAttribute("operation", "x");
                break;
            default:
                req.setAttribute("operation", "/");
                break;
        }
        req.getRequestDispatcher("/WEB-INF/calculator/result.jsp").forward(req, resp);
    }
}
