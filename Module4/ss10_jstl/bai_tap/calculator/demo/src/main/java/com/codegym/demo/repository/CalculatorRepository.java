package com.codegym.demo.repository;

import com.codegym.demo.entity.Calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorRepository {
    private static final List<Calculator> calculators = new ArrayList<>();

    public static List<Calculator> getCalculator() {
        return calculators;
    }

    public static void saveCalculator(Calculator calculator) {
        calculators.add(calculator);
    }
}
