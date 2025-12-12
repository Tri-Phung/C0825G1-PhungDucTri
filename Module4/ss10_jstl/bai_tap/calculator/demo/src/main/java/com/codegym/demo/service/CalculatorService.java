package com.codegym.demo.service;

import com.codegym.demo.entity.Calculator;
import com.codegym.demo.repository.CalculatorRepository;

import java.util.List;

public class CalculatorService implements ICalculatorService{
    private final CalculatorRepository calculatorRepository = new CalculatorRepository();
    @Override
    public Calculator getExpression() {
        return null;
    }

    @Override
    public Double calculate(Calculator calculator) {
        if (calculator == null) return null;
        else if (calculator.getOperation().equals("+")) {
            calculator.setResult(calculator.getNum1() + calculator.getNum2());
        }
        else if (calculator.getOperation().equals("-")) {
            calculator.setResult(calculator.getNum1() - calculator.getNum2());
        }
        else if (calculator.getOperation().equals("*")) {
            calculator.setResult(calculator.getNum1() * calculator.getNum2());
        }
        else if (calculator.getOperation().equals("/")) {
            if (calculator.getNum2() != 0) calculator.setResult(calculator.getNum1() / calculator.getNum2());
            else return null;
        }
        return calculator.getResult();
    }

    @Override
    public List<Calculator> getAll() {
        return null;
    }

    @Override
    public Calculator getById(int id) {
        return null;
    }

    @Override
    public void save(Calculator calculator) {
        calculatorRepository.saveCalculator(calculator);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Calculator calculator) {

    }
}
