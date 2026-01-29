package com.codegym.demo.service;

import com.codegym.demo.entity.Calculator;

import java.util.List;

public interface ICalculatorService extends IService<Calculator>{
    Calculator getExpression();
    Double calculate();
}
