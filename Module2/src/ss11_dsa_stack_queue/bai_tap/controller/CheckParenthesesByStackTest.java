package ss11_dsa_stack_queue.bai_tap.controller;

import ss11_dsa_stack_queue.bai_tap.entity.CheckTheParenthesesByStack;

import static ss11_dsa_stack_queue.bai_tap.entity.CheckTheParenthesesByStack.checkParentheses;

public class CheckParenthesesByStackTest {
    static void main(String[] args) {
        System.out.println("Check parentheses: ");
        String str1 = "s * (s – a) * (s – b) * (s – c) ";
        String str2 = "(– b + (b2 – 4*a*c)^0.5) / 2*a";
        String str3 = "s * (s – a) * (s – b * (s – c)";
        String str4 = "s * (s – a) * s – b) * (s – c)";
        String str5 = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";
        System.out.println(checkParentheses(str1));
        System.out.println(checkParentheses(str2));
        System.out.println(checkParentheses(str3));
        System.out.println(checkParentheses(str4));
        System.out.println(checkParentheses(str5));
    }
}
