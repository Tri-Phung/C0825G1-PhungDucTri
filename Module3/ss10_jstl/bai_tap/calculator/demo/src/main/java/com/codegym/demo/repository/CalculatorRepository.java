package com.codegym.demo.repository;

import com.codegym.demo.entity.Calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorRepository {
    private static final Calculator calculator = new Calculator(0.0d,0.0d,"+");

    public Calculator getCalculator() {
        return calculator;
    }

    public void saveCalculator(Calculator expression) {
        calculator.setNum1(expression.getNum1());
        calculator.setNum2(expression.getNum2());
        calculator.setOperation(expression.getOperation());
    }
}
