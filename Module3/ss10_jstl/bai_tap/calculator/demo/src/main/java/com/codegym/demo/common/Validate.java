package com.codegym.demo.common;

public class Validate {
    public static boolean notANumber(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }
    public static boolean checkDivideByZero(double num2) {
        return num2 != 0;
    }
}
