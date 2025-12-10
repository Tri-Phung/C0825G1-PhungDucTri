package com.codegym.product_discount_calculator;

public class Validate {
    public static boolean inputDoubleDiscount (String input) {
        double result;
        try {
            result = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return !(result <= 0) && !(result > 100);
    }
    public static boolean inputDoublePrice (String input) {
        double result;
        try {
            result = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return !(result <= 0);
    }
}
